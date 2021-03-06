package com.example.vaxdiscussions.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.vaxdiscussions.vaccines.Chickenpox;
import com.example.vaxdiscussions.vaccines.Diphtheria;
import com.example.vaxdiscussions.vaccines.HepatitisA;
import com.example.vaxdiscussions.vaccines.HepatitisB;
import com.example.vaxdiscussions.vaccines.Influenza;
import com.example.vaxdiscussions.R;
import com.example.vaxdiscussions.vaccines.measles;
import com.example.vaxdiscussions.vaccines.smallPox;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Gives user information about vaccines
 */
public class Vaccine_info extends AppCompatActivity {
    /**
     * Class attribute
     */
    TextView fullName,vacc_covid,vacc_flu,vac_meas,vac_small,vacc_chicken,vacc_hepaB,vacc_hepaA,vacc_diph;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mfireStore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_info);
        //setting up the user ids' fpr the different kinds of vaccines
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


        //The mfirestore would save the user first name and last name onto the Vaccine information page
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
        //The on Click listener to goto the vaccine entry page for covid-19 vaccine
        vacc_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, Vaccine_entry.class);
                startActivity(intent);
            }
        });
        //The on Click listener to goto the vaccine entry page for Influenza vaccine
        vacc_flu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, Influenza.class);
                startActivity(intent);
            }
        });
        //The on Click listener to goto the vaccine entry page for Measles vaccine
        vac_meas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, measles.class);
                startActivity(intent);
            }
        });
        //The on Click listener to goto the vaccine entry page for smallpox vaccine
        vac_small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, smallPox.class);
                startActivity(intent);
            }
        });
        //The on Click listener to goto the vaccine entry page for chickenpox vaccine
        vacc_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, Chickenpox.class);
                startActivity(intent);
            }
        });
        //The on Click listener to goto the vaccine entry page for Hepatitis B vaccine
        vacc_hepaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, HepatitisB.class);
                startActivity(intent);
            }
        });
        //The on Click listener to goto the vaccine entry page for Diaptheria vaccine
        vacc_diph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, Diphtheria.class);
                startActivity(intent);
            }
        });
        //The on Click listener to goto the vaccine entry page for Hepatitis A vaccine
        vacc_hepaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vaccine_info.this, HepatitisA.class);
                startActivity(intent);
            }
        });
    }

}