package com.example.cleandia;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    Button signupBtn;
    EditText name,email,password,confirmPassword;
    FirebaseAuth fAuth;
    TextView loginLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.signupName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        signupBtn = (Button) findViewById(R.id.signupBtn);
        fAuth = FirebaseAuth.getInstance();
        loginLink = findViewById(R.id.loginLink);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nm = name.getText().toString().trim();
                String mail = email.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                String cpwd = confirmPassword.getText().toString().trim();

                if(TextUtils.isEmpty(nm)){
                    name.setError("Enter the name ");
                    return;
                }

                if(TextUtils.isEmpty(mail)){
                    email.setError("Enter the Email ");
                    return;
                }
                if(TextUtils.isEmpty(pwd)){
                    password.setError("Enter the password ");
                    return;
                }
                if(TextUtils.isEmpty(cpwd)){
                    confirmPassword.setError("Enter the Confirm Password");
                    return;
                }

                if(pwd.length() < 12){
                    password.setError("Password must be more than 12 letters");
                    return;
                }
                if(!cpwd.equals(pwd)){
                    confirmPassword.setError("Your password is not matching");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(mail,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this,"User Registered.",Toast.LENGTH_SHORT).show();
                            Intent signupIntent = new Intent(SignUp.this,MainActivity.class);
                            startActivity(signupIntent);
                        }
                        else{
                            Toast.makeText(SignUp.this,"Error "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,Login.class));
            }
        });
    }
}