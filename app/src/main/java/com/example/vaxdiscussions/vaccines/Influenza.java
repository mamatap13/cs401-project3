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
 * The Influenza class file is where the user is able to enter the information about Influenza vaccine
 * such as the vaccine name, date recieved, descriptions of the vaccine, and other information. All
 * of the textfield information will be saved onto the database.
 */
public class Influenza extends AppCompatActivity {
    EditText vac_name, vac_date,vac_des,vac_side_eff,vac_other;
    Button save_vacc;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mfireStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_influenza);
        mAuth = FirebaseAuth.getInstance();
        mfireStore = FirebaseFirestore.getInstance();

        vac_name = findViewById(R.id.Influenza);
        vac_date = findViewById(R.id.Influenza_recieved_date);
        vac_des = findViewById(R.id.Influenza_vac_des);
        vac_side_eff = findViewById(R.id.Influenza_side_effects);
        vac_other = findViewById(R.id.Influenza_other_vac_info);
        save_vacc = findViewById(R.id.button_save_vacc);

        mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String VaccineName,VaccineDate,VaccineDesc,VaccineSide,VaccineOther;
                DocumentSnapshot document = task.getResult();
                VaccineName = document.getString("Influenza");
                VaccineDate =document.getString("InfluenzaVaccineDate");
                VaccineDesc =document.getString("InfluenzaVaccineDescription");
                VaccineSide =document.getString("InfluenzaVaccineSideEffects");
                VaccineOther =document.getString("InfluenzaOther");
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
                Vaccine_info.put("Influenza",vac_name.getText().toString());
                Vaccine_info.put("InfluenzaVaccineDate",vac_date.getText().toString());
                Vaccine_info.put("InfluenzaVaccineDescription",vac_des.getText().toString());
                Vaccine_info.put("InfluenzaVaccineSideEffects",vac_side_eff.getText().toString());
                Vaccine_info.put("InfluenzaOther",vac_other.getText().toString());
                mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).update(Vaccine_info).addOnSuccessListener(new OnSuccessListener<Void>() {

                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(Influenza.this, com.example.vaxdiscussions.activities.Vaccine_info.class);
                        startActivity(intent);

                    }
                });
            }
        });
    }
}