package com.example.animemotion.presenter;

import com.example.animemotion.interfaces.IHomeFragment;
import com.example.animemotion.model.iterator.HomeFragmentIteratorImpl;
import com.example.animemotion.model.JikanTopAnimeList;

import java.util.ArrayList;

public class HomeFragmentPresenterImpl implements IHomeFragment.Presenter {
    private IHomeFragment.Iterator iterator;
    private IHomeFragment.View view;

    public HomeFragmentPresenterImpl(IHomeFragment.View view){
        this.view = view;
        this.iterator = new HomeFragmentIteratorImpl(this);
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
