package com.example.sematec4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
RecyclerView recyclerView;
    List<Item> mItem=new ArrayList<>();
    Recycler_Adapter madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView=findViewById(R.id.recyclerView);
        madapter=new Recycler_Adapter(mItem,this);
        recyclerView.setAdapter(madapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        setData();
    }

    private void setData() {
        mItem.add(new Item(R.drawable.dina1,"Majid Bagheri","09361278899","Karaj"));
        mItem.add(new Item(R.drawable.dina2,"Dina Bagheri","09352350645","Karaj"));
        mItem.add(new Item(R.drawable.dina3,"Ali Amiri","09361278899","Ardebil"));
        mItem.add(new Item(R.drawable.dina4,"Reza Askari","09352350645","qom"));
        mItem.add(new Item(R.drawable.dina5,"Hamid Niyazi","09361271199","Karaj"));
        mItem.add(new Item(R.drawable.dina7,"Fereydoon Koorei","09126655593","Karaj"));
        mItem.add(new Item(R.drawable.dina4,"Amir Barzegari","09361277799","Karaj"));
        mItem.add(new Item(R.drawable.dina1,"Pouya Heydari","09352350645","Tehran"));
        mItem.add(new Item(R.drawable.dina2,"Javad Saeidi","09361275599","Shiraz"));
        mItem.add(new Item(R.drawable.dina5,"Mohamad Bahari","09352350645","Isfehan"));
        madapter.notifyDataSetChanged();
    }
}
