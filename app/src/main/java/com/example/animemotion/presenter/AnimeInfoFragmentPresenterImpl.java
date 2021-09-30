package com.example.animemotion.presenter;

import com.example.animemotion.interfaces.IAnimeInfoFragment;
import com.example.animemotion.model.AnimeInfo;
import com.example.animemotion.model.iterator.AnimeInfoFragmentIteratorImpl;

public class AnimeInfoFragmentPresenterImpl implements IAnimeInfoFragment.Presenter {
    private IAnimeInfoFragment.Iterator iterator;
    private IAnimeInfoFragment.View view;

    public AnimeInfoFragmentPresenterImpl(IAnimeInfoFragment.View view){
        this.view = view;
        this.iterator = new AnimeInfoFragmentIteratorImpl(this);
    }

    @Override
    public void getAnimeInfo(int mal_id) {
        iterator.getAnimeInfo(mal_id);
    }

    @Override
    public void showAnimeInfo(AnimeInfo animeInfo) {
        view.showAnimeInfo(animeInfo);
        view.hideProgressBar();
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
