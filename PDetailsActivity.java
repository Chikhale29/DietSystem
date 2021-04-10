package com.javatpoint.dietsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PDetailsActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button _btnreg;
    EditText  _txtlname, _txtpass, _txtemail, _txtphone;
    private Spinner spinner;
    private Spinner spinner1;
    private Spinner spinner2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_details);

        _btnreg = (Button) findViewById(R.id.btn);

        _txtlname = (EditText) findViewById(R.id.lName);
        _txtpass = (EditText) findViewById(R.id.Pwdd);
        _txtemail = (EditText) findViewById(R.id.Email);
        _txtphone = (EditText) findViewById(R.id.Phone);
       // Spinner start

        spinner = findViewById(R.id.spinner);


        final List<String> categories = new ArrayList<String>();

        categories.add("Veg");
        categories.add("Non-Veg");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        spinner.setAdapter(dataAdapter);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(PDetailsActivity.this, "Selected : "+ categories.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//spinner stop
        // Spinner start

        spinner1 = findViewById(R.id.spinner1);
        final List<String> categories1 = new ArrayList<String>();
        categories1.add("Diabetes");
        categories1.add("Cancer");
        categories1.add("Ulcer");


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
        spinner1.setAdapter(dataAdapter1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(PDetailsActivity.this, "Selected : "+ categories1.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//spinner stop
        // Spinner start

        spinner2 = findViewById(R.id.spinner2);
        final List<String> categories2 = new ArrayList<String>();
        categories2.add("Summer");
        categories2.add("Winter");
        categories2.add("Rainy");


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        spinner2.setAdapter(dataAdapter2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(PDetailsActivity.this, "Selected : "+ categories2.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//spinner stop

        db = new DatabaseHelper(this);

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lname = _txtlname.getText().toString();
                String pass = _txtpass.getText().toString();
                String email = _txtemail.getText().toString();
                String phone = _txtphone.getText().toString();


                db.Data(lname,pass,email,phone);
                Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_SHORT).show();
                Intent int1=new Intent(getApplicationContext(),HWidthActivity.class);
                startActivity(int1);

            }
        });

    }



}