package com.javatpoint.dietsqlite;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView customerbtn,adminbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customerbtn=findViewById(R.id.customerbtn);

        adminbtn=findViewById(R.id.adminbtn);


        customerbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(int1);
                finish();
            }
        });

        adminbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(int1);
                finish();
            }
        });

    }
}
