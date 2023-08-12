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
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter
        .MyViewHolder> {
   private Context context;
   private Activity activity;
   ArrayList<String> id_row, one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele;

    public CustomAdapter(Context context, Activity activity, ArrayList<String> id_row, ArrayList<String> one,
                         ArrayList<String> two, ArrayList<String> three, ArrayList<String> four,
                         ArrayList<String> fife, ArrayList<String> six, ArrayList<String> seven,
                         ArrayList<String> eith, ArrayList<String> nine, ArrayList<String> thene,
                         ArrayList<String> eleven, ArrayList<String> tvele) {
        this.context = context;
        this.activity = activity;
        this.id_row = id_row;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.fife = fife;
        this.six = six;
        this.seven = seven;
        this.eith = eith;
        this.nine = nine;
        this.thene = thene;
        this.eleven = eleven;
        this.tvele = tvele;
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

        holder.text_title.setText(String.valueOf(id_row.get(position)));
        holder.text_desc.setText(String.valueOf(one.get(position)));




        holder.layout_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("id", String.valueOf(id_row.get(position)));
                intent.putExtra("one", String.valueOf(one.get(position)));
                intent.putExtra("two", String.valueOf(two.get(position)));
                intent.putExtra("three", String.valueOf(three.get(position)));
                intent.putExtra("for", String.valueOf(four.get(position)));
                intent.putExtra("fife", String.valueOf(fife.get(position)));
                intent.putExtra("six", String.valueOf(six.get(position)));
                intent.putExtra("seven", String.valueOf(seven.get(position)));
                intent.putExtra("eith", String.valueOf(eith.get(position)));
                intent.putExtra("nine", String.valueOf(nine.get(position)));
                intent.putExtra("thene", String.valueOf(thene.get(position)));
                intent.putExtra("eleven", String.valueOf(eleven.get(position)));
                intent.putExtra("tvelve", String.valueOf(tvele.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return id_row.size();
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
