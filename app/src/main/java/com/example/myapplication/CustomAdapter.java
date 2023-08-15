package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList id,name,score,level;
    CustomAdapter(Context context,ArrayList id ,ArrayList name,ArrayList score,ArrayList level){
        this.context=context;
        this.id=id;
        this.name=name;
        this.score=score;
        this.level=level;
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.score_txt.setText(String.valueOf(score.get(position)));
        holder.level_txt.setText(String.valueOf(level.get(position)));

    }

    @Override
    public int getItemCount() {
        return id.size();
    }
    public  class  MyViewHolder extends  RecyclerView.ViewHolder{
        TextView id_txt,name_txt,score_txt,level_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt=itemView.findViewById(R.id.id);
            name_txt=itemView.findViewById(R.id.name);
            score_txt=itemView.findViewById(R.id.score);
            level_txt=itemView.findViewById(R.id.level);
        }
    }
}