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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text;
    private EditText Email;
    private EditText Password;
    private Button SignIn;
    private Button SignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        text = findViewById(R.id.text);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        SignIn = findViewById(R.id.signin);
        SignUp = findViewById(R.id.signup);
        SignIn.setOnClickListener(this);
        SignUp.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == SignIn)
        {
            if (Password.getText().toString().length() == 6 && Email.getText().toString().contains("@") && Email.getText().toString().contains(".com") )
                text.setText(Email.getText().toString());
            signIn_user(Email.getText().toString(),Password.getText().toString());
        }
        if(view == SignUp)
        {
            Context context = getApplicationContext();
            CharSequence text = "Signup is under construction";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent intent = new Intent(this, SignUpActivity.class);
           // intent.putExtra("key", this.);
            startActivity(intent);

        }


    }
    public void signIn_user(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            // intent.putExtra("key", this.);
                            startActivity(intent);


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });}
}