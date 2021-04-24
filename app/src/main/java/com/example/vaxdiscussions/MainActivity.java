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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void launchProfileMenu(View view) {
        Intent intent = new Intent(this, LoginMenu.class);
        startActivity(intent);
    }

    public void launchDiscussionsList(View view) {
        Intent intent = new Intent(this, DiscussionsList.class);
        startActivity(intent);
    }
}