package com.Sebastian.ClubCervezero.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseUser;
import com.Sebastian.ClubCervezero.R;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText TextMail;
   // private EditText TextName;
    //private EditText TextUsername;
    private EditText TextPassword;
    private EditText TextPassword2;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        showToolbar(getResources().getString(R.string.app_toolbar_title_createacount));

        firebaseAuth = FirebaseAuth.getInstance();

        TextMail = findViewById(R.id.mail);
       // TextName = findViewById(R.id.name);
        //TextUsername = findViewById(R.id.username);
        TextPassword = findViewById(R.id.password);
        TextPassword2 = findViewById(R.id.password2);
        buttonRegister = findViewById(R.id.button);
        buttonRegister.setOnClickListener(this);
    }

    @SuppressLint("RestrictedApi")
    public void showToolbar(String titulo) {

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle(titulo);

        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void registerUser(){
        String mail = TextMail.getText().toString();
        //String name = TextName.getText().toString().trim();
       // String userName = TextUsername.getText().toString().trim();
        String password = TextPassword.getText().toString();
        String password2 = TextPassword2.getText().toString().trim();

        if (password.equals(password2)){
            firebaseAuth.createUserWithEmailAndPassword(mail, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Authentication Success.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                        }
                    });
        }else{
            Toast.makeText(getApplicationContext(), "Password no coinciden", Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onClick(View v) {

        registerUser();
    }




}
