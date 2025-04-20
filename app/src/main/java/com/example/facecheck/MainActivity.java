package com.example.facecheck;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.Manifest;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextUsernameTest);
        password = findViewById(R.id.editTextTextPassword);
        logInBtn = findViewById(R.id.buttonLogIn);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a username", Toast.LENGTH_LONG).show();
                } else if(!username.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a password", Toast.LENGTH_LONG).show();
                } else if(username.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter credentials", Toast.LENGTH_LONG).show();
                } else {
                    username.setText("");
                    password.setText("");
                    Intent intent = new Intent(MainActivity.this, Self.class);
                    startActivity(intent);
                }
            }
        });
    }
}