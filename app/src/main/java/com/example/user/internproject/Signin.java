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

import androidx.appcompat.app.AppCompatActivity;

import static com.parse.Parse.getApplicationContext;

public class Signin extends AppCompatActivity {
    EditText edEmail,edPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
    }

    public void login(View view) {
        if( TextUtils.isEmpty(edEmail.getText())){

            edEmail.setError( "Email is required!" );

        }
        else if( TextUtils.isEmpty(edPassword.getText())){

            edPassword.setError( "Password is required!" );

        }
        else{
            ParseUser.logInInBackground( edEmail.getText().toString(),edPassword.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if (parseUser != null) {
                        Toast.makeText(Signin.this, "Welcome Back", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Signin.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(Signin.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public void Signup(View view) {
        Intent intent = new Intent(Signin.this,Signup.class);
        startActivity(intent);
    }

    public void forgotPassword(View view) {

        Intent intent = new Intent(Signin.this,ResetPasswordActivity.class);
        startActivity(intent);

    }

    public void backUp(View view) {
        onBackPressed();
    }
}
