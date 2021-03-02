package com.example.myandroid3home2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myandroid3home2.data.remote.RetrofitFactory;
import com.example.myandroid3home2.model.Film;
import com.example.myandroid3home2.ui.FilmAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FilmAdapter.Listenerr {

    private RecyclerView recyclerView;
    private FilmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyc();
        lodFilm();

    }

    private void initRecyc() {
        adapter = new FilmAdapter();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        adapter.setListener(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
    }

    private void lodFilm() {
//        RetrofitFactory
//                .getInstance()
//                .getFilm("ebbb6b7c-945c-41ee-a792-de0e43191bd8")
//                .enqueue(new Callback<Film>() {
//                    @Override
//                    public void onResponse(Call<Film> call, Response<Film> response) {
//                        if (response.isSuccessful() && response.body() !=null) {
//                            Log.d("tag", response.body().getTitle());
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<Film> call, Throwable t) {
//                        Log.d("tag", t.getLocalizedMessage());
//                    }
//                });
        RetrofitFactory
                .getInstance()
                .getFilms()
                .enqueue(new Callback<List<Film>>() {
                    @Override
                    public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                        if (response.isSuccessful() && response.body() !=null){
                            Log.d("dadada", "Responce" + response.body().size());

                            adapter.setList(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Film>> call, Throwable t) {
                        Log.d("dadada", "Responce" + t.getLocalizedMessage());

                    }
                });
    }


    @Override
    public void onClickfilm(String id) {
        Intent intent = new Intent(MainActivity.this, MyBasaDan.class);
        intent.putExtra("kay",id);

        startActivity(intent);

        Toast.makeText(this, "list" , Toast.LENGTH_SHORT).show();

    }


}






