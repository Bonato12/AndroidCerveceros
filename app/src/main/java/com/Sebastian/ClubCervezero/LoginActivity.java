package com.Sebastian.ClubCervezero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Sebastian.ClubCervezero.view.ContainerActivity;
import com.Sebastian.ClubCervezero.view.CreateAccountActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonLogin;
    private EditText TextMail;
    private EditText TextPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        TextMail = findViewById(R.id.mail);
        TextPassword = findViewById(R.id.password);
        botonLogin = findViewById(R.id.buttonLogin);
        botonLogin.setOnClickListener(this);

    }

    private void loginUser(){
        String mail = TextMail.getText().toString();
        String password = TextPassword.getText().toString();

        if(TextUtils.isEmpty(mail)){
            Toast.makeText(this,"Mail required",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Password required",Toast.LENGTH_LONG).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }

                    }
                });




    }


    @Override
    public void onClick(View view) {
        loginUser();



    }


    public void onCreateAccount(View view) {

        Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);

        startActivity(intent);

    }
}
