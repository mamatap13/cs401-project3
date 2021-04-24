package com.example.vaxdiscussions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;
    String correct_username = "admin";
    String correct_password = "Pass@12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate inputs
                if(TextUtils.isEmpty(username.getText().toString() )|| TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this,"Empty data provided",Toast.LENGTH_LONG).show();
                }
                else if(username.getText().toString().equals(correct_username)){
                    //Check password
                    if(password.getText().toString().equals(correct_password))
                    {
                        Toast.makeText(MainActivity.this,"Successfully Logged in!",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Invalid Username / Password",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid Username/Password",Toast.LENGTH_LONG).show();
                }
            }
        });

*/

    }

    public void launchProfileMenu(View view) {
        Intent intent = new Intent(this, LoginMenu.class);
        startActivity(intent);
    }
}