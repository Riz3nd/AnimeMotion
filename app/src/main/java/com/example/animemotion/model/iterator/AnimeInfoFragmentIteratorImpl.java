package com.example.animemotion.model.iterator;

import com.example.animemotion.interfaces.IAnimeInfoFragment;
import com.example.animemotion.interfaces.IServiceJikanApi;
import com.example.animemotion.model.AnimeInfo;
import com.example.animemotion.model.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeInfoFragmentIteratorImpl implements IAnimeInfoFragment.Iterator {
    private IAnimeInfoFragment.Presenter presenter;
    private RetrofitClient client;
    public AnimeInfoFragmentIteratorImpl(IAnimeInfoFragment.Presenter presenter){
        this.presenter = presenter;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    public void getAnimeInfo(int mal_id) {

        IServiceJikanApi service = retrofit.create(IServiceJikanApi.class);
        service.getAnimeInfo(mal_id).enqueue(new Callback<AnimeInfo>() {
            @Override
            public void onResponse(Call<AnimeInfo> call, Response<AnimeInfo> response) {
                if(response.isSuccessful()){
                    AnimeInfo animeInfo = response.body();
                    presenter.showAnimeInfo(animeInfo);
                }
            }

            @Override
            public void onFailure(Call<AnimeInfo> call, Throwable t) {
                presenter.onFailure(t.getMessage());
            }
        });
    }
}
