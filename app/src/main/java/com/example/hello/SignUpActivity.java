package com.example.hello;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text;
    private EditText Email;
    private EditText Password;
    private EditText Name;
    private Button submit;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth= FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        text = findViewById(R.id.signupt);
        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }




    @Override
    public void onClick(View view) {
        if(view == submit)
        {
            create_user(Email.getText().toString(),Password.getText().toString());
        }





    }
    public void create_user(String email, String password){
    mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                User user = new User(Name.getText().toString(),Email.getText().toString(),Password.getText().toString());
                String uid= mAuth.getCurrentUser().getUid().toString();
                database.getReference("users").child(uid).setValue(user);
                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                // intent.putExtra("key", this.);
                startActivity(intent);


            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(SignUpActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

            }
        }
    });}
}