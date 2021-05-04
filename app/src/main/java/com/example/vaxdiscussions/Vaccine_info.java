package com.example.vaxdiscussions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Vaccine_info extends AppCompatActivity {
    TextView fullName,vacc_covid,vacc_flu,vac_meas,vac_small,vacc_chicken,vacc_hepaB,vacc_hepaA,vacc_diph;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mfireStore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_info);
        fullName=findViewById(R.id.user_info);
        vacc_covid = findViewById(R.id.vaccine_info);
        vac_small =findViewById(R.id.vaccine_info2);
        vacc_flu = findViewById(R.id.vaccine_info3);
        vac_meas = findViewById(R.id.vaccine_info4);
        vacc_chicken = findViewById(R.id.vaccine_info5);
        vacc_hepaB = findViewById(R.id.vaccine_info6);
        vacc_diph = findViewById(R.id.vaccine_info7);
        vacc_hepaA = findViewById(R.id.vaccine_info8);
        mAuth = FirebaseAuth.getInstance();
        mfireStore = FirebaseFirestore.getInstance();


        mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                           @Override
                                           public void onComplete (@NonNull Task < DocumentSnapshot > task) {
                                               String first_name,last_name;
                                               DocumentSnapshot document = task.getResult();
                                               first_name = document.getString("FirstName");
                                               last_name = document.getString("LastName");
                                               fullName.setText(first_name + " " + last_name);
                                           }
        });
        vacc_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, Vaccine_entry.class);
                startActivity(intent);
            }
        });
        vacc_flu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, Influenza.class);
                startActivity(intent);
            }
        });
        vac_meas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, measles.class);
                startActivity(intent);
            }
        });
        vac_small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, smallPox.class);
                startActivity(intent);
            }
        });
        vacc_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, Chickenpox.class);
                startActivity(intent);
            }
        });
        vacc_hepaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, HepatitisB.class);
                startActivity(intent);
            }
        });
        vacc_diph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, Diphtheria.class);
                startActivity(intent);
            }
        });
        vacc_hepaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, HepatitisA.class);
                startActivity(intent);
            }
        });
    }

}