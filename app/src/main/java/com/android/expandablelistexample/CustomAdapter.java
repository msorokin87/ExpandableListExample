package com.android.expandablelistexample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter
        .MyViewHolder> {
   private Context context;
   private Activity activity;
   private  ArrayList goods_title;

    public CustomAdapter(Context context, Activity activity,
                          ArrayList goods_title) {
        this.context = context;
        this.activity = activity;

        this.goods_title = goods_title;

    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, @SuppressLint("RecyclerView")final int position) {

        holder.text_title.setText(String.valueOf(goods_title.get(position)));


        holder.layout_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowActivity.class);
               // intent.putExtra("id", String.valueOf(goods_id.get(position)));
                intent.putExtra("title", String.valueOf(goods_title.get(position)));
               // intent.putExtra("desc", String.valueOf(goods_desc.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return goods_title.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_title, text_desc;
        ConstraintLayout layout_raw;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text_title = itemView.findViewById(R.id.text_title);
            //text_desc = itemView.findViewById(R.id.text_desc);
            layout_raw = itemView.findViewById(R.id.layout_raw);

        }
    }
}
