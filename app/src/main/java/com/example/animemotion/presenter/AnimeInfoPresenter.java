package com.example.animemotion.presenter;

import com.example.animemotion.interfaces.IAnimeInfoFragment;
import com.example.animemotion.model.AnimeInfo;
import com.example.animemotion.model.iterator.AnimeInfoIterator;

public class AnimeInfoPresenter implements IAnimeInfoFragment.Presenter {
    private IAnimeInfoFragment.Iterator iterator;
    private IAnimeInfoFragment.View view;

    public AnimeInfoPresenter(IAnimeInfoFragment.View view){
        this.view = view;
        this.iterator = new AnimeInfoIterator(this);
    }

    @Override
    public void getAnimeInfo(int mal_id) {
        iterator.getAnimeInfo(mal_id);
    }

    @Override
    public void showAnimeInfo(AnimeInfo animeInfo) {
        view.showAnimeInfo(animeInfo);
//        view.hideProgressBar();
    }

    @Override
    public void hideProgressBar() {
        view.hideProgressBar();
    }

    @Override
    public void onFailure(String failure) {
        view.onFailure(failure);
    }
}
