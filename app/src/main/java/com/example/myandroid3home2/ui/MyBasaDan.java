package com.example.myandroid3home2.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myandroid3home2.R;
import com.example.myandroid3home2.data.remote.RetrofitFactory;
import com.example.myandroid3home2.model.Film;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBasaDan extends AppCompatActivity {
    private String id;
    private TextView title, description, producer, people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_basa_dan);
        init();

        Intent intent = getIntent();
        id = intent.getStringExtra("kay");
        Toast.makeText(this, "Garila " + id, Toast.LENGTH_SHORT).show();
        getFilmId();
    }

    private void init() {
        title = findViewById(R.id.tile_film);
        description = findViewById(R.id.description_film);
        producer = findViewById(R.id.producer_film);
        people = findViewById(R.id.people_film);

    }

    private void getFilmId() {
        RetrofitFactory.getInstance().getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                title.setText(response.body().getTitle());
                producer.setText(response.body().getProducer());
                description.setText(response.body().getDescription());
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
            }
        });
    }
}