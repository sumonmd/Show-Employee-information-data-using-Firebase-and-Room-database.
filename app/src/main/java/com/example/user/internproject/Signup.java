package com.example.user.internproject;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    EditText edName,edEmail,edPassword,edConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
    }

    public void signUP(View view) {
        if( TextUtils.isEmpty(edName.getText())){

            edName.setError( "Full Name  is required!" );

        }
        else if( TextUtils.isEmpty(edEmail.getText())){

            edEmail.setError( "Email is required!" );

        }
        else if( TextUtils.isEmpty(edPassword.getText())){

            edPassword.setError( "Password is required!" );

        }
        else if( TextUtils.isEmpty(edConfirmPassword.getText())){

            edConfirmPassword.setError( "Confirm Password is required!" );

        }
        else if( !edPassword.getText().toString().equals(edConfirmPassword.getText().toString())){

            Toast.makeText(Signup.this, "Password Don't Match", Toast.LENGTH_LONG).show();

        }
        else{
            ParseUser user = new ParseUser();
// Set the user's username and password, which can be obtained by a forms

            user.setUsername(edEmail.getText().toString().trim());
            user.setEmail(edEmail.getText().toString().trim());
            user.setPassword(edPassword.getText().toString());
            user.put("name",edName.getText().toString().trim());

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(Signup.this,"Welcome", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Signup.this,Signin.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(Signup.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    }

    public void backUp2(View view) {
        onBackPressed();
    }
}
