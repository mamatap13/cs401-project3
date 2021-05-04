package com.example.vaxdiscussions.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vaxdiscussions.R;

/**
 * Page allows a user to enter in a reply to a comment
 */
public class Reply_page extends AppCompatActivity {

    /**
     * Class attribute
     */
    Button enter_reply;

    /**
     * Sets the reply button to navigate to previous page
     * @param savedInstanceState
     */
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