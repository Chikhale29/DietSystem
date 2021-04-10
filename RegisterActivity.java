package com.javatpoint.dietsqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button _btnreg, _btnlog, view;
    EditText repassword, password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _btnreg = findViewById(R.id.btn);
        _btnlog = findViewById(R.id.btn1);
        view = findViewById(R.id.btn2);


        username = findViewById(R.id.Email);
        password = findViewById(R.id.Pwdd);
        repassword = findViewById(R.id.repwd);
        ViewAll();

        _btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);

            }
        });
        db = new DatabaseHelper(this);

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                String repass = repassword.getText().toString();
                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean usercheckResult = db.checkusername(user);
                        if (usercheckResult == false) {
                            Boolean regResult = db.insertData(user, pass);
                            if (regResult == true) {
                                Toast.makeText(RegisterActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "User ALready Exists. \n Please SignIn", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password not Matching", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });


    }

    public void ViewAll() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getAllData();
                if (res.getCount() == 0) {

                    Log.d("Success","In View all method");

                    showMessage("Error", "Nothing found");
                    return;

                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("lname: " + res.getString(0) + "\n");
                    buffer.append("pass " + res.getString(1) + "\n");
                    buffer.append("email: " + res.getString(2) + "\n");
                    buffer.append("phone " + res.getString(3) + "\n");



                }
                showMessage("Data", buffer.toString());

            }
        }) ;


    }
    public void showMessage(String title,String Message){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}

