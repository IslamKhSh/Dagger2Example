package com.example.islam.dagger2example;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

public class ConstructorInjectionAdapter extends RecyclerView.Adapter<CommonViewHolder> {

    private ArrayList<String> itemsList;

    @Inject
    public ConstructorInjectionAdapter(ArrayList<String> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public CommonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CommonViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_recyler,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder commonViewHolder, int position) {
        commonViewHolder.textView.setText(itemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
