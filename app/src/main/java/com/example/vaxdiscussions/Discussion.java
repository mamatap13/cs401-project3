package com.example.vaxdiscussions;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Discussion extends AppCompatActivity {
    EditText covid_19, childhood_vaccine,why_vaccine,side_effect,moderna_or_pfizer;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discussion_page);

        covid_19 = findViewById(R.id.covid);
        childhood_vaccine = findViewById(R.id.childhood_vaccines);
        why_vaccine = findViewById(R.id.topic_vaccine);
        side_effect = findViewById(R.id.side_effect_stories);
        moderna_or_pfizer = findViewById(R.id.mode_or_pfiz);
        login = findViewById(R.id.button_main_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
