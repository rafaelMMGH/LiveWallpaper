package com.livewallpaper.rafael.livewallpaper.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.livewallpaper.rafael.livewallpaper.Interface.ItemClickListener;
import com.livewallpaper.rafael.livewallpaper.R;

/**
 * Created by rafael on 27/02/18.
 */

public class ListBackgroundViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ItemClickListener itemClickListener;
    public ImageView background;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ListBackgroundViewHolder(View itemView) {
        super(itemView);

        background = itemView.findViewById(R.id.image);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onclick(view, getAdapterPosition());

    }
}
