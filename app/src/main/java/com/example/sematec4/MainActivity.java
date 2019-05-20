package com.example.sematec4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btnsend;
    EditText txtname,txtfamily,txtage,txtemail;
ListView listView;
String[] menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MENU
        drawerLayout=findViewById(R.id.drawer);
        listView=findViewById(R.id.list_view);
        menu=new String[]{"Intent Project","Recycler View Project","Oghat Sharei"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,menu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (menu[position]==menu[0]){
                    drawerLayout.closeDrawers();
                }
                else if (menu[position]==menu[1]){
                    Intent intent = new Intent(MainActivity.this,RecyclerActivity.class);
                    startActivity(intent);
                }
                else if (menu[position]==menu[2]){
                    Intent intent = new Intent(MainActivity.this,OghatActivity.class);
                    startActivity(intent);
                }
            }
        });
        //MENU
        //Layout
        btnsend=findViewById(R.id.btn_send);
        txtage=findViewById(R.id.txt_age);
        txtemail=findViewById(R.id.txt_email);
        txtfamily=findViewById(R.id.txt_family);
        txtname=findViewById(R.id.txt_name);
        Hawk.init(this).build();
        if (!Hawk.contains(null)){
            txtname.setText(Hawk.get("namekey").toString());
            txtfamily.setText(Hawk.get("familykey").toString());
            txtage.setText(Hawk.get("agekey").toString());
            txtemail.setText(Hawk.get("emailkey").toString());
        }

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=txtname.getText().toString();
                String family=txtfamily.getText().toString();
                String age =txtage.getText().toString();
                String email=txtemail.getText().toString();
                if (name.length()>=3 && family.length()>=4 && (Integer.parseInt(age)>0 && Integer.parseInt(age)<110 )){

                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("namekey",name);
                    intent.putExtra("familykey",family);
                    intent.putExtra("agekey",age);
                    intent.putExtra("emailkey",email);
                    startActivityForResult(intent,66);
                }
                else {
                    v.requestFocus();
                    Toast.makeText(MainActivity.this, "لطفا اطلاعات را صحیح وارد کنید.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==66){
            if (resultCode==RESULT_OK){
                txtname.setText(Hawk.get("namekey").toString());
                txtfamily.setText(Hawk.get("familykey").toString());
                txtage.setText(Hawk.get("agekey").toString());
                txtemail.setText(Hawk.get("emailkey").toString());
                Toast.makeText(this, "اطلاعات با موفقیت ذخیره شد", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "متاسفانه اطلاعات ذخیره نشد", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
