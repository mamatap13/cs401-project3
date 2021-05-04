package com.example.vaxdiscussions.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vaxdiscussions.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
/*
User is able to log into the system with the firebase Authorizations and setup a
log in usrname and password.
 */

public class LoginMenu extends AppCompatActivity {

    Button createNewUser;

    EditText email, password;
    Button btnLogin;
    String correct_username = "admin";
    String correct_password = "Pass@12";
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_menu);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button_login);

        createNewUser = findViewById(R.id.button_create_user);
        createNewUser.setOnClickListener(v -> {
            Intent intent = new Intent(LoginMenu.this, NewUser.class);
            startActivity(intent);
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate inputs
                if(TextUtils.isEmpty(email.getText().toString() )|| TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(LoginMenu.this,"Empty data provided",Toast.LENGTH_LONG).show();
                }
                else if(email.getText().toString().equals(correct_username)){
                    //Check password
                    if(password.getText().toString().equals(correct_password))
                    {
                        Toast.makeText(LoginMenu.this,"Successfully Logged in!",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(LoginMenu.this,"Invalid Username/Password",Toast.LENGTH_LONG).show();
                    mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Intent intent = new Intent(LoginMenu.this, ProfileMenu.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}