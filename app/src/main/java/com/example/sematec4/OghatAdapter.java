package com.example.sematec4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OghatAdapter extends RecyclerView.Adapter<OghatAdapter.OghatHolder> {
ArrayList<String> citylist;
String cityClick;

    public OghatAdapter(ArrayList<String> citylist) {
        this.citylist = citylist;
    }

    @NonNull
    @Override
    public OghatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.oghat_items,parent,false);
        final OghatHolder holder = new OghatHolder(v);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Log.d("@@@@",holder.tvoghatitem.getText().toString());
                cityClick=holder.tvoghatitem.getText().toString();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OghatHolder holder, int position) {
                holder.tvoghatitem.setText(citylist.get(position));
    }

    @Override
    public int getItemCount() {
        return citylist.size();
    }

    public class OghatHolder extends RecyclerView.ViewHolder{
        TextView tvoghatitem;

        public OghatHolder(@NonNull View itemView) {
            super(itemView);
            tvoghatitem=itemView.findViewById(R.id.tv_item_oghat);
        }

    }
}
