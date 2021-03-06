package com.example.vaxdiscussions.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vaxdiscussions.R;

/**
 * User can navigate through each discussion and choose to reply
 */
public class Discussions_after_login extends AppCompatActivity {
    /**
     * class attribute
     */
    EditText covid_19, childhood_vaccine,why_vaccine,side_effect,moderna_or_pfizer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussions_after_login);

        covid_19 = findViewById(R.id.disc_covid);
        childhood_vaccine = findViewById(R.id.childhood_vaccines);
        why_vaccine = findViewById(R.id.topic_vaccine);
        side_effect = findViewById(R.id.side_effect_stories);
        moderna_or_pfizer = findViewById(R.id.mode_or_pfiz);

        covid_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Discussions_after_login.this, CovidDiscussions.class); //change to covid_19mpage
                startActivity(intent);
            }
        });
        childhood_vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Discussions_after_login.this, LoginMenu.class); //change to covid_19mpage
                startActivity(intent);
            }
        });
        why_vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Discussions_after_login.this, LoginMenu.class); //change to covid_19mpage
                startActivity(intent);
            }
        });
        side_effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Discussions_after_login.this, LoginMenu.class); //change to covid_19mpage
                startActivity(intent);
            }
        });
        moderna_or_pfizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Discussions_after_login.this, LoginMenu.class); //change to covid_19mpage
                startActivity(intent);
            }
        });

    }
}