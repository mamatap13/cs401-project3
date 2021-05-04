package com.example.vaxdiscussions.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.vaxdiscussions.R;

/**
 * Main Activity with 2 buttons, navigate to login page and discussions
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Class attributes
     */
    Button profileMenu, discussionlist;

    /**
     * Sets on click listeners for two buttons
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profileMenu = findViewById(R.id.button_profile_login);
        discussionlist = findViewById(R.id.button_discussion_menu);


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