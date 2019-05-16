package com.example.sematec4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.Recycler_Holder> {
    List<Item> itemList;
    Context mycontext;

    public Recycler_Adapter(List<Item> itemList, Context mycontext) {
        this.itemList = itemList;
        this.mycontext = mycontext;
    }

    @NonNull
    @Override
    public Recycler_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_items,parent,false);
        Recycler_Holder recyclerHolder=new Recycler_Holder(v);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Holder holder, int position) {
        Item aItem = itemList.get(position);
        holder.img.setImageResource(aItem.getUavatar());
        holder.tvrname.setText(aItem.getUname());
        holder.tvrphone.setText(aItem.getUphone());
        holder.tvraddress.setText(aItem.getUaddress());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class Recycler_Holder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tvrname;
        TextView tvrphone;
        TextView tvraddress;

        public Recycler_Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            tvrname=itemView.findViewById(R.id.tvr_name);
            tvrphone=itemView.findViewById(R.id.tvr_phone);
            tvraddress=itemView.findViewById(R.id.tvr_address);

        }
    }
}
