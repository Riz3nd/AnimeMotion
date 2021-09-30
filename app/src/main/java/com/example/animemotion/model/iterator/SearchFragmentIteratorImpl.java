package com.example.animemotion.model.iterator;

import com.example.animemotion.interfaces.ISearchFragment;
import com.example.animemotion.interfaces.IServiceJikanApi;
import com.example.animemotion.model.AnimeSearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragmentIteratorImpl implements ISearchFragment.Iterator {
    ISearchFragment.Presenter presenter;

    public SearchFragmentIteratorImpl(ISearchFragment.Presenter presenter){
        this.presenter = presenter;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    public void getSearchAnimeList(String anime) {
        System.out.println("ENTRAMOS AQUIIIIIIIIIII");
        IServiceJikanApi service = retrofit.create(IServiceJikanApi.class);
        service.searchAnime(anime).enqueue(new Callback<AnimeSearch>() {
            @Override
            public void onResponse(Call<AnimeSearch> call, Response<AnimeSearch> response) {
                if(response.isSuccessful()){
                    AnimeSearch lista = response.body();
                    System.out.println("LISTA DE BUSQUEDAAAAAAAAAAAAAAA:::"+lista.getResults().get(1).getTitle());
                    presenter.showSearchAnimeList(lista.getResults());
                }else{
                    presenter.onFailure("Codigo de error: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<AnimeSearch> call, Throwable t) {
                presenter.onFailure(t.getMessage());
            }
        });
    }
}
