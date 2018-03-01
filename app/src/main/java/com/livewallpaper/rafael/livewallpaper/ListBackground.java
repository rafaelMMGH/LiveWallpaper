package com.livewallpaper.rafael.livewallpaper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.livewallpaper.rafael.livewallpaper.Common.Common;
import com.livewallpaper.rafael.livewallpaper.Interface.ItemClickListener;
import com.livewallpaper.rafael.livewallpaper.Model.BackgroundItem;
import com.livewallpaper.rafael.livewallpaper.ViewHolder.ListBackgroundViewHolder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class ListBackground extends AppCompatActivity {

    Query query;
    FirebaseRecyclerOptions<BackgroundItem> options;
    FirebaseRecyclerAdapter<BackgroundItem,ListBackgroundViewHolder> adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_background);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(Common.CATEGORY_SELECTED);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_list_background);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        loadBackgroundList();
    }

    private void loadBackgroundList() {
        query = FirebaseDatabase.getInstance().getReference(Common.STR_BACKGROUND)
                .orderByChild("idCategory").equalTo(Common.CATEGORY_ID_SELECTED);


        options = new FirebaseRecyclerOptions.Builder<BackgroundItem>()
                .setQuery(query,BackgroundItem.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<BackgroundItem, ListBackgroundViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ListBackgroundViewHolder holder, int position, @NonNull final BackgroundItem model) {
                Picasso.with(getBaseContext())
                        .load(model.getImageUrl())
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(holder.background, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                Picasso.with(getBaseContext())
                                        .load(model.getImageUrl())
                                        .error(R.drawable.ic_broken_image_black_24dp)
                                        .into(holder.background, new Callback() {
                                            @Override
                                            public void onSuccess() {

                                            }

                                            @Override
                                            public void onError() {
                                                Log.e("Error Image","No se pudo cargar la imagen");
                                            }
                                        });

                            }
                        });

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int position) {
                        //Code later for Background details
                    }
                });
            }

            @Override
            public ListBackgroundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_background_item,parent,false);
                int height = parent.getMeasuredHeight()/2;
                itemView.setMinimumHeight(height);
                return new ListBackgroundViewHolder(itemView);



            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        if(adapter != null)
            adapter.startListening();

    }

    @Override
    public void onStop() {
        if(adapter != null)
            adapter.stopListening();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter != null)
            adapter.startListening();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish(); //Close activity when back button is pressed
        return super.onOptionsItemSelected(item);
    }
}
