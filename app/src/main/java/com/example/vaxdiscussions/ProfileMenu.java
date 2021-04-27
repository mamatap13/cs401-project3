package com.example.vaxdiscussions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class ProfileMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_menu);
    }

    public void launchSettingsMenu(View view) {
        Intent intent = new Intent(this, SettingsMenu.class);
        startActivity(intent);
    }
}