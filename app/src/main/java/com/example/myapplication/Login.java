package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    EditText editname, editpassword;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        editname=findViewById(R.id.editname);
        editpassword=findViewById(R.id.editpassword);
        loginBtn=findViewById(R.id.button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editname.getText().toString();
                String password=editpassword.getText().toString();

                if(TextUtils.isEmpty(name)|| TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this,"Please Enter All Fields",Toast.LENGTH_SHORT).show();

                }
                else {
                    if(name.equals("User")&& password.equals("123456"))
                    {
                        Toast.makeText(Login.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Login.this, HomeScreen.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
}