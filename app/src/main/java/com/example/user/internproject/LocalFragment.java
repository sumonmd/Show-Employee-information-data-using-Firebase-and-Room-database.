package com.example.user.internproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.MODE_PRIVATE;

/*LocalFragment work with PersonModel,EmployeeDao for room, Myadapter*/

public class LocalFragment extends Fragment {
    @Nullable
    ArrayList<PersonModel> employeeList = new ArrayList<PersonModel>();
    ArrayList<PersonModel> showList = new ArrayList<>();

    RecyclerView recyclerView;


    MyAdapter myAdapter;
    String [] names,designations;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local,container,false);
        recyclerView = view.findViewById(R.id.recyclerViewId);

        // SharedPreferences working
        SharedPreferences prefs = getActivity().getSharedPreferences("firebase", MODE_PRIVATE);
        Boolean restoredText = prefs.getBoolean("name", false);
        if (!restoredText) {
            get_json();
        }

        showList = (ArrayList<PersonModel>) MainActivity.myDatabase.employeeDao().getAll();
        myAdapter = new MyAdapter(showList,getContext());

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;

    }


    public void get_json(){
        String json;
        try{
            InputStream is = getActivity().getAssets().open("app.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0; i< jsonArray.length();i++){

                JSONObject employeeObject = jsonArray.getJSONObject(i);

                PersonModel person=new PersonModel();
                person.setName(employeeObject.getString("name"));
                person.setDesignation(employeeObject.getString("designation"));
                person.setTeam(employeeObject.getString("team"));
                person.setImage(employeeObject.getString("image"));
                employeeList.add(person);

            }
            MainActivity.myDatabase.employeeDao().addUser(employeeList);
            SharedPreferences.Editor editor = getActivity().getSharedPreferences("firebase", MODE_PRIVATE).edit();
            editor.putBoolean("name", true);
            editor.apply();


        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }


    public LocalFragment() {

    }
}

