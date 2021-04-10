package com.javatpoint.dietsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
EditText username,password;
Button btnlogin;
DatabaseHelper db;
    private TextView textViewSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
    username=(EditText)findViewById(R.id.Email);
    password=(EditText)findViewById(R.id.Pwdd);
       btnlogin=(Button)findViewById(R.id.btn);
       db=new DatabaseHelper(this);
       btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
               if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter the credentials", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   Boolean result=db.checkusernamePassword(user,pass);
                   if(result==true)
                   {
                       Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                       Intent intent=new Intent(getApplicationContext(),PDetailsActivity.class);
                       startActivity(intent);

                   }
                   else{
                       Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                   }
                }

            }
        });

    }
}