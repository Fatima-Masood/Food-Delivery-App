package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText;
    private Spinner dobSpinner;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize views
        nameEditText = findViewById(R.id.et_name);
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        dobSpinner = findViewById(R.id.spinner_dob);
        signUpButton = findViewById(R.id.btn_signup);

        // Handle sign up button click
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String dob = dobSpinner.getSelectedItem().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform sign-up operation (for example, call an API)
                    Toast.makeText(SignUp.this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignUp.this, HomeScreen.class);
                    startActivity(intent);
                }
            }
        });
    }
}
