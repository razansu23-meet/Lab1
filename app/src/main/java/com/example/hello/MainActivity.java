package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text;
    private EditText Email;
    private EditText Password;
    private Button SignIn;
    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        SignIn = findViewById(R.id.signin);
        SignUp = findViewById(R.id.signup);
        SignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == SignIn)
        {
            if (Password.getText().toString().length() == 6 && Email.getText().toString().contains("@") && Email.getText().toString().contains(".com") )
                text.setText(Email.getText().toString());
        }
        if(view == SignUp)
        {
            Context context = getApplicationContext();
            CharSequence text = "Signup is under construction";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }


    }
}