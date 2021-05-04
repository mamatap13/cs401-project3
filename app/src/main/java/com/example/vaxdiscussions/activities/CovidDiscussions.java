package com.example.vaxdiscussions.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vaxdiscussions.R;

/**
 * Discussion page with comments from users, user can choose to reply
 */
public class CovidDiscussions extends AppCompatActivity {

    /**
     * class attribute
     */
    Button reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_discussions);

        reply = findViewById(R.id.button_reply);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CovidDiscussions.this, Reply_page.class);
                startActivity(intent);
            }
        });

    }
}