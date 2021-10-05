package com.example.animemotion.presenter;

import com.example.animemotion.interfaces.ISearchFragment;
import com.example.animemotion.model.iterator.SearchIterator;
import com.example.animemotion.model.animesearch.AnimeSearchResults;

import java.util.ArrayList;

public class SearchPresenter implements ISearchFragment.Presenter {
    private ISearchFragment.Iterator iterator;
    private ISearchFragment.View view;

    public SearchPresenter(ISearchFragment.View view){
        this.view = view;
        this.iterator = new SearchIterator(this);
    }

    @Override
    public void getSearchAnimeList(String anime) {
        iterator.getSearchAnimeList(anime);
    }

    @Override
    public void showSearchAnimeList(ArrayList<AnimeSearchResults> searchAnimeList) {
        view.showSearchAnimeList(searchAnimeList);
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
