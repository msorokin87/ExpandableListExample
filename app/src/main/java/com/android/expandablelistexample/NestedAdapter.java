package com.android.expandablelistexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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

    Activity activity;
    ArrayList<String> pre_goods = new ArrayList<>();
    String one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele;
    int size;
    DatabaseHelper myDB;
    EditText edit_name_list;
    String transfer;



    SharedPreferences.Editor sharedPreferences;
    SharedPreferences preferences;

    public NestedAdapter(List<String> mList, Context context, Button save_buton, String transfer){
        this.mList = mList;
        this.context = context;
        this.save_buton = save_buton;
        this.transfer = transfer;



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
        holder.groop_index.setText(String.valueOf(holder.getAdapterPosition()));


        holder.checkBox.setChecked(getFromSave(holder.mTv.getText().toString() + holder.getAdapterPosition()));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveChecked(holder.mTv.getText() + String.valueOf(holder.getAdapterPosition()), isChecked);

                String text = holder.mTv.getText().toString();
                String edit = holder.text_desc.getText().toString();

                if (holder.checkBox.isChecked()){

                    holder.text_desc.setEnabled(false);
                    holder.text_desc.setHint(R.string.hint_block);

                    myDB = new DatabaseHelper(save_buton.getContext());
                    myDB.addGoods(text, edit);
                    // myDB.updateGroopName(text,text);

                    } else if (edit.isEmpty()) {
                    myDB = new DatabaseHelper(save_buton.getContext());
                    myDB.addGoods(text, "emty");
                }

                if (!holder.checkBox.isChecked()) {
                    holder.text_desc.setEnabled(true);
                    holder.text_desc.setHint(R.string.hint_add);

                    String text1 = holder.mTv.getText().toString();
                    String untext = holder.mTv.getText().toString();
                    myDB = new DatabaseHelper(save_buton.getContext());
                    System.out.println("Снято " + text1);
                    myDB.deleteOneRaw(untext);
                }

            }
        });

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.updateGroopName(holder.mTv.getText().toString(), transfer);
            }
        });
        save_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = myDB.readAllData();
                if (cursor.getCount()==0){
                    Toast.makeText(context, "Ничего не выбрано", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), ListActivity.class);
                    context.startActivity(intent);
                }
                else while (cursor.moveToNext()){
                    pre_goods.add(cursor.getString(1));
                }
                size = pre_goods.size();
                System.out.println(size);

                for (int i = 0 ; i<size; i++){
                    if (i == 0) {
                        one = pre_goods.get(0);
                    }
                    if (i == 1) {
                        two = pre_goods.get(1);
                    }
                    if (i == 2) {
                        three = pre_goods.get(2);
                    }
                    if (i == 3) {
                        four = pre_goods.get(3);
                    }
                    if (i == 4) {
                        fife = pre_goods.get(4);
                    }
                    if (i == 5) {
                        six = pre_goods.get(5);
                    }
                    if (i == 6) {
                        seven = pre_goods.get(6);
                    }
                    if (i == 7) {
                        eith = pre_goods.get(7);
                    }
                    if (i == 8) {
                        nine = pre_goods.get(8);
                    }
                    if (i == 9) {
                        thene = pre_goods.get(9);
                    }
                    if (i == 10) {
                        eleven = pre_goods.get(10);
                    }
                    if (i == 11) {
                        tvele = pre_goods.get(11);
                    }

                }
                myDB = new DatabaseHelper(save_buton.getContext());
                myDB.addAllinSort(one, two, three, four, fife, six, seven, eith, nine, thene, eleven, tvele);
                myDB.deleteAllData();



                preferences = context.getSharedPreferences("Button", Context.MODE_PRIVATE);
                preferences.edit().clear().commit();
                Intent intent = new Intent(v.getContext(), ListActivity.class);
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
        private TextView mTv,  groop_index;
        EditText text_desc;
        Button save_button;
        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.nestedItemTv);
            checkBox = itemView.findViewById(R.id.checkbox);
            save_button = itemView.findViewById(R.id.save_button);
            text_desc = itemView.findViewById(R.id.text_desc);
            groop_index = itemView.findViewById(R.id.groop_index);
            edit_name_list = itemView.findViewById(R.id.edit_name_list);



        }

    }


}

