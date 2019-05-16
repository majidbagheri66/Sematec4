package com.example.sematec4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

public class SecondActivity extends AppCompatActivity {
TextView tvname,tvfamily,tvage,tvemail;
Button btnyes,btnno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //init
        tvage=findViewById(R.id.tv_age);
        tvemail=findViewById(R.id.tv_email);
        tvfamily=findViewById(R.id.tv_family);
        tvname=findViewById(R.id.tvr_name);
        btnyes=findViewById(R.id.btn_yes);
        btnno=findViewById(R.id.btn_no);
        //init
        //page load
        Intent intent=getIntent();
        tvname.setText(intent.getStringExtra("namekey"));
        tvfamily.setText(intent.getStringExtra("familykey"));
        tvage.setText(intent.getStringExtra("agekey"));
        tvemail.setText(intent.getStringExtra("emailkey"));
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hawk.init(SecondActivity.this).build();
                Hawk.put("namekey",tvname.getText().toString());
                Hawk.put("familykey",tvfamily.getText().toString());
                Hawk.put("agekey",tvage.getText().toString());
                Hawk.put("emailkey",tvemail.getText().toString());
                Intent intent1=new Intent();
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                setResult(RESULT_CANCELED,intent2);
                finish();
            }
        });

    }
}
