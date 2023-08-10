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
   private  ArrayList one1, two2, three3, four4, fife5, six6, seven7, eith8, nine9, thene10, eleven11, tvelve12;

    public CustomAdapter(Context context, Activity activity, ArrayList one1, ArrayList two2,
                         ArrayList three3, ArrayList four4, ArrayList fife5, ArrayList six6,
                         ArrayList seven7, ArrayList eith8, ArrayList nine9, ArrayList thene10,
                         ArrayList eleven11, ArrayList tvelve12) {
        this.context = context;
        this.activity = activity;
        this.one1 = one1;
        this.two2 = two2;
        this.three3 = three3;
        this.four4 = four4;
        this.fife5 = fife5;
        this.six6 = six6;
        this.seven7 = seven7;
        this.eith8 = eith8;
        this.nine9 = nine9;
        this.thene10 = thene10;
        this.eleven11 = eleven11;
        this.tvelve12 = tvelve12;
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

        holder.text_title.setText(String.valueOf(one1.get(position)));
        holder.text_desc.setText(String.valueOf(two2.get(position)));


        holder.layout_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowActivity.class);
               // intent.putExtra("id", String.valueOf(goods_id.get(position)));
                intent.putExtra("title", String.valueOf(one1.get(position)));
               // intent.putExtra("desc", String.valueOf(goods_desc.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return one1.size();
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
