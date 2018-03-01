package com.livewallpaper.rafael.livewallpaper.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.livewallpaper.rafael.livewallpaper.Interface.ItemClickListener;
import com.livewallpaper.rafael.livewallpaper.R;

/**
 * Created by rafael on 24/02/18.
 */

public class categoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView category_name;
    public ImageView background_image;

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public categoryViewHolder(View itemView) {
        super(itemView);
        background_image = (ImageView) itemView.findViewById(R.id.image);
        category_name = (TextView) itemView.findViewById(R.id.name);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        itemClickListener.onclick(v,getAdapterPosition());

    }
}
