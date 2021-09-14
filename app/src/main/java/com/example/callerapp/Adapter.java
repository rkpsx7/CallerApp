package com.example.callerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<viewHolder> {

    private ArrayList<Model> contacts = new ArrayList<>();
    private clickListener clickListener;

    public Adapter(ArrayList<Model> contacts, com.example.callerapp.clickListener clickListener) {
        this.contacts = contacts;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new viewHolder(v,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Model item = contacts.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
