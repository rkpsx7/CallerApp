package com.example.callerapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {
    private TextView tvName,tvNum;
    private CardView cardView;
    private clickListener clickListener;
    public viewHolder(@NonNull View itemView,clickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        tvNum = itemView.findViewById(R.id.tvNum);
        cardView = itemView.findViewById(R.id.cardView);
    }

    public void setData(Model contact){
        tvName.setText(contact.getName());
        tvNum.setText(contact.getNo());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(contact);
            }
        });

    }
}
