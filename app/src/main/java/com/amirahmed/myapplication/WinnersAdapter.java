package com.amirahmed.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WinnersAdapter extends RecyclerView.Adapter<WinnersAdapter.WinnersViewHolder> {

    private List<WinnerRootClass> winners;

    Context context;

    WinnersAdapter(List<WinnerRootClass> winners) {
        this.winners = winners;
    }

    @NonNull
    @Override
    public WinnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_winner,parent,false);

        context = parent.getContext();
        return new WinnersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WinnersViewHolder holder, final int position) {

        holder.name.setText(winners.get(position).getName());
        holder.type.setText(winners.get(position).getType());

        Glide.with(context).load("https://www.kingfaisalappstore.org/" + winners.get(position).getImg()).into(holder.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,WebActivity.class);
                intent.putExtra("url",winners.get(position).getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return winners.size();
    }

    class WinnersViewHolder extends RecyclerView.ViewHolder {

        ImageView pic;
        TextView name,type;

        WinnersViewHolder(@NonNull View itemView) {
            super(itemView);

            pic = itemView.findViewById(R.id.pic);
            name = itemView.findViewById(R.id.name);
            type = itemView.findViewById(R.id.type);
        }
    }
}
