package com.example.vaxdiscussions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HepatitisA extends AppCompatActivity {

    EditText vac_name, vac_date,vac_des,vac_side_eff,vac_other;
    Button save_vacc;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mfireStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hepatitis);
        mAuth = FirebaseAuth.getInstance();
        mfireStore = FirebaseFirestore.getInstance();

        vac_name = findViewById(R.id.HepatitisA);
        vac_date = findViewById(R.id.HepatitisA_recieved_date);
        vac_des = findViewById(R.id.HepatitisA_vac_des);
        vac_side_eff = findViewById(R.id.HepatitisA_side_effects);
        vac_other = findViewById(R.id.HepatitisA_other_vac_info);
        save_vacc = findViewById(R.id.button_save_vacc);

        mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String VaccineName,VaccineDate,VaccineDesc,VaccineSide,VaccineOther;
                DocumentSnapshot document = task.getResult();
                VaccineName = document.getString("HepatitisA");
                VaccineDate =document.getString("HepatitisAVaccineDate");
                VaccineDesc =document.getString("HepatitisAVaccineDescription");
                VaccineSide =document.getString("HepatitisAVaccineSideEffects");
                VaccineOther =document.getString("HepatitisAOther");
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
                Vaccine_info.put("HepatitisA",vac_name.getText().toString());
                Vaccine_info.put("HepatitisAVaccineDate",vac_date.getText().toString());
                Vaccine_info.put("HepatitisAVaccineDescription",vac_des.getText().toString());
                Vaccine_info.put("HepatitisAVaccineSideEffects",vac_side_eff.getText().toString());
                Vaccine_info.put("HepatitisAOther",vac_other.getText().toString());
                mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).update(Vaccine_info).addOnSuccessListener(new OnSuccessListener<Void>() {

                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(HepatitisA.this, Vaccine_info.class);
                        startActivity(intent);

                    }
                });
            }
        });
    }
}