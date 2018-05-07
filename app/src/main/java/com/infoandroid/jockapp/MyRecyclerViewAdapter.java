package com.infoandroid.jockapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infoandroid.jockapp.model.JokeModel;
import com.infoandroid.jockapp.model.response.JokeResponse;
import com.infoandroid.jockapp.sharepreference.AppSharedPreference;
import com.infoandroid.jockapp.util.Constants;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    private JokeResponse jokeResponse;
    private ArrayList<JokeModel> jokeModels;
    private String name,lastName;


    // Data is passed into the constructor
    public MyRecyclerViewAdapter(Context context,  ArrayList<JokeModel> jokeModels) {
        this.mInflater = LayoutInflater.from(context);
        this.jokeModels = jokeModels;
        name = AppSharedPreference.getString(Constants.NAME_KEY,"",context);
        lastName = AppSharedPreference.getString(Constants.LAST_NAME_KEY,"",context);
    }
    // Inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    // Binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.neme_text.setText(name+" "+lastName);
        String animal = jokeModels.get(position).getJoke();
        holder.myTextView.setText(animal);
    }
    // Total number of cells
    @Override
    public int getItemCount() {
        return jokeModels.size();
    }

    // Stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView myTextView;
        public TextView neme_text;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.info_text);
            neme_text = (TextView) itemView.findViewById(R.id.neme_text);

        }


    }


}
