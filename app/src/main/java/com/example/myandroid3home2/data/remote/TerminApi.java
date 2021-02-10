package com.example.myandroid3home2.data.remote;

import com.example.myandroid3home2.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TerminApi {

    @GET(EndPoints.GET_FILM)
    Call<Film> getFilm(
            @Path("id") String id
    );

    @GET(EndPoints.GET_FILMS)
    Call<List<Film>> getFilms();
}
