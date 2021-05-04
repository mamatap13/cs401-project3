package com.example.vaxdiscussions.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vaxdiscussions.R;

/**
 * User's after login menu, allows user to navigate to digital immunization card, discussions, or settings
 */
public class ProfileMenu extends AppCompatActivity {
    /**
     * Class Attributes
     */
        Button immunization;
        Button discussion, settings;


    /**
     * Sets 3 buttons on the profile menu: immunization card, discussions, and settings
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_menu);
        immunization= findViewById(R.id.button_label_immu_card);
        discussion = findViewById(R.id.button_profile_to_disc);
        settings = findViewById(R.id.button_label_settings);

        immunization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileMenu.this, Vaccine_info.class);
                startActivity(intent);

            }
        });
        discussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileMenu.this, Discussions_after_login.class);
                startActivity(intent);

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileMenu.this, SettingsMenu.class);
                startActivity(intent);

            }
        });
    }
}