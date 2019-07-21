package com.example.user.internproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<PersonModel> employeeList;
    Context context;


    public MyAdapter(ArrayList<PersonModel>employeeList , Context context) {
        this.employeeList = employeeList;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.single_view_layout, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nameTextView.setText(employeeList.get(position).getName());
        holder.designationTextView.setText(employeeList.get(position).getDesignation());
        holder.teamTextView.setText(employeeList.get(position).getTeam());
       // holder.imageTextview.setImageResource(employeeList.get(position).getTeam());
        Glide
                .with(context)
                .load(employeeList.get(position).getImage())
                .centerCrop()
                .into(holder.imageTextview);
       // holder.imageView.setImageResource(employeeList.get(position).getTeam());

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView,designationTextView,teamTextView;
        ImageView imageTextview;
       // ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameViewId);
            designationTextView = itemView.findViewById(R.id.designationViewId);
            teamTextView = itemView.findViewById(R.id.teamViewId);
            imageTextview = itemView.findViewById(R.id.myImageViewId);
            
        }
    }
}
