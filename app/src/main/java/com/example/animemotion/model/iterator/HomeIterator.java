package com.example.animemotion.model.iterator;

import com.example.animemotion.interfaces.IHomeFragment;
import com.example.animemotion.interfaces.IServiceJikanApi;
import com.example.animemotion.model.JikanTopAnime;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeIterator implements IHomeFragment.Iterator {
    private IHomeFragment.Presenter presenter;

    public HomeIterator(IHomeFragment.Presenter presenter){
        this.presenter = presenter;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    public void getTopAnimeList() {
        IServiceJikanApi service = retrofit.create(IServiceJikanApi.class);
        service.getTopAnimeList().enqueue(new Callback<JikanTopAnime>() {
            @Override
            public void onResponse(Call<JikanTopAnime> call, Response<JikanTopAnime> response) {
                if(response.isSuccessful()){
                    JikanTopAnime lista = response.body();
                    presenter.showTopAnimeList(lista.getTop());
                }else{
                    presenter.onFailure("Codigo de error: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<JikanTopAnime> call, Throwable t) {
                presenter.onFailure(t.getMessage());
            }
        });
    }

}
