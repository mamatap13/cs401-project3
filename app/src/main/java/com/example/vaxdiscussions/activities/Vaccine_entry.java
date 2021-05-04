package com.example.vaxdiscussions.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vaxdiscussions.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/*
The Vaccine_entry class file is where the user will be able to enter the information
on the vaccine such as the vaccine name, date, side effects, and other informations.

 */
public class Vaccine_entry extends AppCompatActivity {
    EditText vac_name, vac_date,vac_des,vac_side_eff,vac_other;
    Button save_vacc;
    private FirebaseAuth mAuth; //getting the authorized user
    private FirebaseFirestore mfireStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_entry); //layout file
        mAuth = FirebaseAuth.getInstance();
        mfireStore = FirebaseFirestore.getInstance();

        //Setting up the ids' from the layout page
        vac_name = findViewById(R.id.vaccine_name);
        vac_date = findViewById(R.id.recieved_date);
        vac_des = findViewById(R.id.vac_des);
        vac_side_eff = findViewById(R.id.side_effects);
        vac_other = findViewById(R.id.other_vac_info);
        save_vacc = findViewById(R.id.button_save_vacc);

        mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String VaccineName,VaccineDate,VaccineDesc,VaccineSide,VaccineOther;

                DocumentSnapshot document = task.getResult(); //Set up for reading the inputs for the vaccine information
                VaccineName = document.getString("Covid19");
                VaccineDate =document.getString("CovidVaccineDate");
                VaccineDesc =document.getString("CovidVaccineDescription");
                VaccineSide =document.getString("CovidVaccineSideEffects");
                VaccineOther =document.getString("CovidOther");
                if(VaccineName != null && !VaccineName.isEmpty()) {
                    //writting the vaccine info into the database or firestore
                    vac_name.setText(VaccineName);
                    vac_date.setText(VaccineDate);
                    vac_des.setText(VaccineDesc);
                    vac_side_eff.setText(VaccineSide);
                    vac_other.setText(VaccineOther);
                }
            }
        });
        /*
        The on click listener for save vacccine button to store the vaccine information onto the firestore under the usercollection
         */
        save_vacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> Vaccine_info = new HashMap<>();
                Vaccine_info.put("Covid19",vac_name.getText().toString());
                Vaccine_info.put("CovidVaccineDate",vac_date.getText().toString());
                Vaccine_info.put("CovidVaccineDescription",vac_des.getText().toString());
                Vaccine_info.put("CovidVaccineSideEffects",vac_side_eff.getText().toString());
                Vaccine_info.put("CovidOther",vac_other.getText().toString());
                mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).update(Vaccine_info).addOnSuccessListener(new OnSuccessListener<Void>() {

                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(Vaccine_entry.this, Vaccine_info.class);
                        startActivity(intent);

                    }
                });
            }
        });
    }
}