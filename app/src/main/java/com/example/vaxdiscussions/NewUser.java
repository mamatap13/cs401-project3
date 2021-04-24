package com.example.vaxdiscussions;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewUser extends AppCompatActivity {
    EditText fname,lname,username,password;
    Button save_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_page);

        fname = findViewById(R.id.edittext_firstname);
        lname = findViewById(R.id.edittext_lastname);
        username = findViewById(R.id.create_username);
        password = findViewById(R.id.create_password);

        save_profile= findViewById(R.id.button_save_profile);

        save_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
