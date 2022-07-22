package com.example.arishti_app;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText phone;
    EditText password;
    EditText address;
    EditText email;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.login_name);
        phone = findViewById(R.id.login_phone);
        address = findViewById(R.id.login_address);
        password = findViewById(R.id.login_pwd);
        email = findViewById(R.id.login_email);
        login = findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyData();
                Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });
    }

        boolean correctEmail(EditText text){
            CharSequence email = text.getText().toString();
            return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        }

        boolean dataNull(EditText text){
            CharSequence string = text.getText().toString();
            return TextUtils.isEmpty(string);
        }
        void verifyData(){
            if(dataNull(password)){
                Toast toast = Toast.makeText(this, "Password must be entered!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                if(password.getText().toString().length()<4 || password.getText().toString().length()>12){
                    password.setError("Password must be between 4 to 12 characters.");
                }
            }
            if (dataNull(phone)){
                phone.setError("Contact no. must be entered.");
            }
            else {
                if(phone.getText().toString().length() != 10){
                    phone.setError("Enter a 10 digit phone number!");
                }
            }
            if (!correctEmail(email)){
                email.setError("Enter valid mail-id");
            }
        }
}