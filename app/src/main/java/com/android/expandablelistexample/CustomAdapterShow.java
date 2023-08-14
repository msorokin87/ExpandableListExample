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

public class CustomAdapterShow extends RecyclerView.Adapter<CustomAdapterShow
        .MyViewHolder> {
   private Context context;
   private Activity activity;
   DatabaseHelper myDb;
   ArrayList<String> one, desc_two;

    public CustomAdapterShow(Context context, Activity activity,
                             ArrayList<String> one, ArrayList<String> desc_two) {
        this.context = context;
        this.activity = activity;
        this.one = one;
        this.desc_two = desc_two;

    }

    @NonNull
    @Override
    public CustomAdapterShow.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterShow.MyViewHolder holder, @SuppressLint("RecyclerView")final int position) {

        holder.text_title.setText(String.valueOf(one.get(position)));

         holder.text_desc.setText(desc_two.get(position));





    }

    @Override
    public int getItemCount() {
        return one.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_title, text_desc;
        ConstraintLayout layout_raw;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text_title = itemView.findViewById(R.id.text_title);
            text_desc = itemView.findViewById(R.id.text_desc);
            layout_raw = itemView.findViewById(R.id.layout_raw);



        }
    }
}
