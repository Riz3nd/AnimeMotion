package com.example.animemotion.presenter;

import com.example.animemotion.interfaces.IHomeFragment;
import com.example.animemotion.model.iterator.HomeIterator;
import com.example.animemotion.model.JikanTopAnimeList;

import java.util.ArrayList;

public class HomePresenter implements IHomeFragment.Presenter {
    private IHomeFragment.Iterator iterator;
    private IHomeFragment.View view;

    public HomePresenter(IHomeFragment.View view){
        this.view = view;
        this.iterator = new HomeIterator(this);
    }

    @Override
    public void getTopAnimeList() {
        iterator.getTopAnimeList();
    }


    @Override
    public void showTopAnimeList(ArrayList<JikanTopAnimeList> topAnimeList) {
        view.showTopAnimeList(topAnimeList);
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
