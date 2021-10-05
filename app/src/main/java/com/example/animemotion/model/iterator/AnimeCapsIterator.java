package com.example.animemotion.model.iterator;

import com.example.animemotion.interfaces.IAnimeCapsFragment;
import com.example.animemotion.interfaces.IServiceJikanApi;
import com.example.animemotion.model.AnimeCaps;
import com.example.animemotion.model.AnimeInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeCapsIterator implements IAnimeCapsFragment.Iterator{
    private IAnimeCapsFragment.Presenter presenter;

    public AnimeCapsIterator(IAnimeCapsFragment.Presenter presenter) {
        this.presenter = presenter;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    public void getAnimeCaps(int mal_id) {
        IServiceJikanApi service = retrofit.create(IServiceJikanApi.class);
        service.getAnimeCap(mal_id).enqueue(new Callback<AnimeCaps>() {
            @Override
            public void onResponse(Call<AnimeCaps> call, Response<AnimeCaps> response) {
                if(response.isSuccessful()){
                    AnimeCaps caps = response.body();
                    presenter.showAnimeCaps(caps.getEpisodes());
//                    System.out.println("EPISODIOS: "+caps.getEpisodes().get(1).getVideo_url());
                }else {
                    presenter.onFailure("Error: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<AnimeCaps> call, Throwable t) {
                presenter.onFailure("Error: "+t.getMessage());
            }
        });

    }
}
