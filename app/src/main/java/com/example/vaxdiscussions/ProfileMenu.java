package com.example.vaxdiscussions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileMenu extends AppCompatActivity {
        Button immunization;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_menu);
        immunization= findViewById(R.id.button_label_immu_card);
    }


    public void launchSettingsMenu(View view) {
        Intent intent = new Intent(ProfileMenu.this, Vaccine_info.class);
        startActivity(intent);

    }
}