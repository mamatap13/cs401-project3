package com.example.vaxdiscussions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reply_page extends AppCompatActivity {

    Button enter_reply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_page);

        enter_reply = findViewById(R.id.button_enter_Reply);

        enter_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reply_page.this, CovidDiscussions.class);
                startActivity(intent);
            }
        });
    }
}