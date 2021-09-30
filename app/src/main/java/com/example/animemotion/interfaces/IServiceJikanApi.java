package com.example.animemotion.interfaces;

import com.example.animemotion.model.AnimeInfo;
import com.example.animemotion.model.AnimeSearch;
import com.example.animemotion.model.JikanTopAnime;
import com.example.animemotion.model.JikanTopAnimeList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IServiceJikanApi {

    @GET("top/anime")
    Call<JikanTopAnime> getTopAnimeList();

    @GET("anime/{id}")
    Call<AnimeInfo> getAnimeInfo(@Path("id") int id);

    @GET("search/anime")
    Call<AnimeSearch> searchAnime(@Query("q") String anime);

}
