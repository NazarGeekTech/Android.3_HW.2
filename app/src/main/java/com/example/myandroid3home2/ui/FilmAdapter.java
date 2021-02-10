package com.example.myandroid3home2.ui;

import android.content.Context;
import android.location.GpsStatus;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroid3home2.R;
import com.example.myandroid3home2.model.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private List<Film> list = new ArrayList<>();
    private Listenerr listenerr;

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view, listenerr);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.ViewHolder holder, int position) {
       holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setList(List<Film> responce) {
        list.addAll(responce);
        notifyDataSetChanged();
    }

    public void setListener(Listenerr listener) {
        this.listenerr = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView film_title;
        private Listenerr listener;

        public ViewHolder(@NonNull View itemView, Listenerr listener) {
            super(itemView);
            this.listener = listener;
            film_title = itemView.findViewById(R.id.film_title);
        }

        public void bind(Film film) {
            film_title.setText(film.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickfilm(film.getId());
                }
            });
        }
    }
    public interface Listenerr{
        void onClickfilm(String id);
    }
}




