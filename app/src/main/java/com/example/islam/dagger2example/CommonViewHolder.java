package com.example.islam.dagger2example;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CommonViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public CommonViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.item_text);
    }
}
