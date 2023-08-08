package com.android.expandablelistexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.NestedViewHolder> {

    private List<String> mList;
    Context context;
    Button save_buton;
    List <String> arrayList = new ArrayList<>();
    Activity activity;

    SharedPreferences.Editor sharedPreferences;
    SharedPreferences preferences;

    public NestedAdapter(List<String> mList, Context context, Button save_buton){
        this.mList = mList;
        this.context = context;
        this.save_buton = save_buton;


    }
    @NonNull
    @Override
    public NestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item , parent , false);

        return new NestedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedViewHolder holder, int position) {



        holder.mTv.setText(mList.get(position));


        holder.checkBox.setChecked(getFromSave(holder.mTv.getText().toString() + holder.getAdapterPosition()));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveChecked(holder.mTv.getText() + String.valueOf(holder.getAdapterPosition()), isChecked);
                String text = holder.mTv.getText().toString();

                if (holder.checkBox.isChecked()){
                    arrayList.add(text);
                    System.out.println(text +"\n");
                }

            }
        });


        save_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item", Toast.LENGTH_SHORT).show();

                for (String item : arrayList){
                    System.out.println("Items " +  item);

                }
                preferences = context.getSharedPreferences("Button", Context.MODE_PRIVATE);
                preferences.edit().clear().commit();
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                context.startActivity(intent);
                

            }
        });
        
    }
    private void saveChecked(String s, boolean isChecked) {
         sharedPreferences =
                context.getSharedPreferences("Button", android.content.Context.MODE_PRIVATE)
                        .edit();
        sharedPreferences.putBoolean(s, isChecked);
        sharedPreferences.commit();
    }

    private boolean getFromSave(String s) {
        preferences = context.getSharedPreferences("Button", Context.MODE_PRIVATE);
        return preferences.getBoolean(s, false);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NestedViewHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBox;
        private TextView mTv;
        Button save_button;
        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.nestedItemTv);
            checkBox = itemView.findViewById(R.id.checkbox);
            save_button = itemView.findViewById(R.id.save_button);


        }

    }

}

