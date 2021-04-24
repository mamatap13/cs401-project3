package com.example.vaxdiscussions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DiscussionsList extends AppCompatActivity {
    EditText covid_19, childhood_vaccine,why_vaccine,side_effect,moderna_or_pfizer;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discussions_list);

        covid_19 = findViewById(R.id.disc_covid);
        childhood_vaccine = findViewById(R.id.childhood_vaccines);
        why_vaccine = findViewById(R.id.topic_vaccine);
        side_effect = findViewById(R.id.side_effect_stories);
        moderna_or_pfizer = findViewById(R.id.mode_or_pfiz);
        login = findViewById(R.id.button_main_login);

        login.setOnClickListener(v -> {
            Intent intent = new Intent(DiscussionsList.this, LoginMenu.class);
            startActivity(intent);
        });
    }


}

