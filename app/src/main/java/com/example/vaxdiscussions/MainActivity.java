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

    Button profileMenu, discussionlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileMenu = (Button) findViewById(R.id.button_profile_login);
        discussionlist = (Button) findViewById(R.id.button_discussion_menu);


        profileMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginMenu.class);
            startActivity(intent);
        });


        discussionlist.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DiscussionsList.class);
            startActivity(intent);
        });

    }

}