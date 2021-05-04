package com.example.vaxdiscussions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vaxdiscussions.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
/*
new users can set up an account by entering his/her first name, last name, username
and password. Then a new users will be added to the firebase database.
 */
public class NewUser extends AppCompatActivity {
    EditText fname,lname,email,password;
    Button save_profile;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mfireStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_page);

        fname = findViewById(R.id.edittext_firstname);
        lname = findViewById(R.id.edittext_lastname);
        email = findViewById(R.id.create_username);
        password = findViewById(R.id.create_password);

        mAuth = FirebaseAuth.getInstance();
        mfireStore = FirebaseFirestore.getInstance();
        save_profile= findViewById(R.id.button_save_profile);

        save_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(NewUser.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Map<String,Object> fullName = new HashMap<>();
                        fullName.put("FirstName",fname.getText().toString());
                        System.out.println(mAuth.getCurrentUser().getUid());
                        fullName.put("LastName",lname.getText().toString());
                        mfireStore.collection("userscollection").document(mAuth.getCurrentUser().getUid()).set(fullName).addOnSuccessListener(new OnSuccessListener<Void>() {

                            @Override
                            public void onSuccess(Void aVoid) {
                                Intent intent = new Intent(NewUser.this, ProfileMenu.class);
                                startActivity(intent);

                            }
                        });


                    }
                });

            }
        });
    }
}
