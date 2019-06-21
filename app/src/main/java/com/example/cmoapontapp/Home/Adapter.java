package com.example.cmoapontapp.Home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cmoapontapp.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public MyViewHolder(TextView v){

            super(v);
            textView = v;
        }
    }

    public Adapter(String[] myDataset){
        mDataset=myDataset;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }




}
