package com.example.vaxdiscussions.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vaxdiscussions.R;
import com.google.firebase.auth.FirebaseAuth;


/**
 * User can enter the settings menu.
 */
public class SettingsMenu extends AppCompatActivity {

    /**
     * Settings menu oncreate for notification and logout
     * @param savedInstanceState
     */

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);

        logout = (Button) findViewById(R.id.button_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SettingsMenu.this, MainActivity.class));
            }
        });
    }
}