package com.example.vaxdiscussions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DiscussionsList extends AppCompatActivity {

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discussions_list);




        login.setOnClickListener(v -> {
            Intent intent = new Intent(DiscussionsList.this, LoginMenu.class);
            startActivity(intent);
        });
    }


}

