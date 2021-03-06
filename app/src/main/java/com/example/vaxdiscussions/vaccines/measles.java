package com.example.vaxdiscussions.vaccines;

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

/**
 * The measles class file is where the user is able to enter the information about measles vaccine
 * such as the vaccine name, date recieved, descriptions of the vaccine, and other information. All
 * of the textfield information will be saved onto the database.
 */
public class measles extends AppCompatActivity {
    EditText vac_name, vac_date,vac_des,vac_side_eff,vac_other;
    Button save_vacc;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mfireStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measles);
        mAuth = FirebaseAuth.getInstance();
        mfireStore = FirebaseFirestore.getInstance();

        vac_name = findViewById(R.id.measles);
        vac_date = findViewById(R.id.measles_recieved_date);
        vac_des = findViewById(R.id.measles_vac_des);
        vac_side_eff = findViewById(R.id.measles_side_effects);
        vac_other = findViewById(R.id.measles_other_vac_info);
        save_vacc = findViewById(R.id.button_save_vacc);

        mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String VaccineName,VaccineDate,VaccineDesc,VaccineSide,VaccineOther;
                DocumentSnapshot document = task.getResult();
                VaccineName = document.getString("measles");
                VaccineDate =document.getString("measlesVaccineDate");
                VaccineDesc =document.getString("measlesVaccineDescription");
                VaccineSide =document.getString("measlesVaccineSideEffects");
                VaccineOther =document.getString("measlesOther");
                if(VaccineName != null && !VaccineName.isEmpty()) {
                    vac_name.setText(VaccineName);
                    vac_date.setText(VaccineDate);
                    vac_des.setText(VaccineDesc);
                    vac_side_eff.setText(VaccineSide);
                    vac_other.setText(VaccineOther);
                }
            }
        });
        save_vacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> Vaccine_info = new HashMap<>();
                Vaccine_info.put("measles",vac_name.getText().toString());
                Vaccine_info.put("measlesVaccineDate",vac_date.getText().toString());
                Vaccine_info.put("measlesVaccineDescription",vac_des.getText().toString());
                Vaccine_info.put("measlesVaccineSideEffects",vac_side_eff.getText().toString());
                Vaccine_info.put("measlesOther",vac_other.getText().toString());
                mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).update(Vaccine_info).addOnSuccessListener(new OnSuccessListener<Void>() {

                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(measles.this, com.example.vaxdiscussions.activities.Vaccine_info.class);
                        startActivity(intent);

                    }
                });
            }
        });
    }
}