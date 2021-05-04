package com.example.vaxdiscussions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button profileMenu, discussionlist, settingsMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profileMenu = findViewById(R.id.button_profile_login);
        discussionlist = findViewById(R.id.button_discussion_menu);
        settingsMenu = findViewById(R.id.button_label_settings);


        profileMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginMenu.class);
            startActivity(intent);
        });


        discussionlist.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DiscussionsList.class);
            startActivity(intent);
        });


    }
    public void opensettingsmenu(){
        Intent intent = new Intent(this,SettingsMenu.class);
        startActivity(intent);
    }

}