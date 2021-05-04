package com.example.vaxdiscussions.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.vaxdiscussions.R;


/**
 * User can enter the settings menu.
 */
public class SettingsMenu extends AppCompatActivity {

    /**
     * Settings menu oncreate for notification and logout
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);
    }
}