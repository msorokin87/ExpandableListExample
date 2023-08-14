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
   DatabaseHelper myDb;
   ArrayList<String> id_row, one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele;
   ArrayList<String> id_row_d, one_d, two_d, three_d, four_d, fife_d, six_d, seven_d, eith_d, nine_d, thene_d, eleven_d, tvele_d;

    public CustomAdapter(Context context, Activity activity, ArrayList<String> id_row,
                         ArrayList<String> one, ArrayList<String> two, ArrayList<String> three,
                         ArrayList<String> four, ArrayList<String> fife, ArrayList<String> six,
                         ArrayList<String> seven, ArrayList<String> eith, ArrayList<String> nine,
                         ArrayList<String> thene, ArrayList<String> eleven, ArrayList<String> tvele,
                         ArrayList<String> id_row_d, ArrayList<String> one_d, ArrayList<String> two_d,
                         ArrayList<String> three_d, ArrayList<String> four_d, ArrayList<String> fife_d,
                         ArrayList<String> six_d, ArrayList<String> seven_d, ArrayList<String> eith_d,
                         ArrayList<String> nine_d, ArrayList<String> thene_d, ArrayList<String> eleven_d,
                         ArrayList<String> tvele_d) {

        this.context = context; this.activity = activity; this.id_row = id_row; this.one = one;
        this.two = two; this.three = three; this.four = four; this.fife = fife; this.six = six;
        this.seven = seven; this.eith = eith; this.nine = nine; this.thene = thene; this.eleven = eleven;
        this.tvele = tvele; this.id_row_d = id_row_d; this.one_d = one_d; this.two_d = two_d; this.three_d = three_d;
        this.four_d = four_d; this.fife_d = fife_d; this.six_d = six_d; this.seven_d = seven_d;
        this.eith_d = eith_d; this.nine_d = nine_d; this.thene_d = thene_d; this.eleven_d = eleven_d;
        this.tvele_d = tvele_d;
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
                myDb = new DatabaseHelper(holder.layout_raw.getContext());
                Intent intent = new Intent(context, ShowActivity.class);
                myDb.addGoods(String.valueOf(one.get(position)));
                myDb.addGoods(String.valueOf(two.get(position)));
                myDb.addGoods(String.valueOf(three.get(position)));
                myDb.addGoods(String.valueOf(four.get(position)));
                myDb.addGoods(String.valueOf(fife.get(position)));
                myDb.addGoods(String.valueOf(six.get(position)));
                myDb.addGoods(String.valueOf(seven.get(position)));
                myDb.addGoods(String.valueOf(eith.get(position)));
                myDb.addGoods(String.valueOf(nine.get(position)));
                myDb.addGoods(String.valueOf(thene.get(position)));
                myDb.addGoods(String.valueOf(eleven.get(position)));
                myDb.addGoods(String.valueOf(tvele.get(position)));

                myDb.addDesc(String.valueOf(one_d.get(position)));
                myDb.addDesc(String.valueOf(two_d.get(position)));
                myDb.addDesc(String.valueOf(three_d.get(position)));
                myDb.addDesc(String.valueOf(four_d.get(position)));
                myDb.addDesc(String.valueOf(fife_d.get(position)));
                myDb.addDesc(String.valueOf(six_d.get(position)));
                myDb.addDesc(String.valueOf(seven_d.get(position)));
                myDb.addDesc(String.valueOf(eith_d.get(position)));
                myDb.addDesc(String.valueOf(nine_d.get(position)));
                myDb.addDesc(String.valueOf(thene_d.get(position)));
                myDb.addDesc(String.valueOf(eleven_d.get(position)));
                myDb.addDesc(String.valueOf(tvele_d.get(position)));

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
