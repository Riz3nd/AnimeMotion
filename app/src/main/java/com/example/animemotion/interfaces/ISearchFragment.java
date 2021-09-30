package com.example.animemotion.interfaces;

import com.example.animemotion.model.AnimeSearch;
import com.example.animemotion.model.JikanTopAnimeList;
import com.example.animemotion.model.animesearch.AnimeSearchResults;

import java.util.ArrayList;

public interface ISearchFragment {

    interface Iterator{
        void getSearchAnimeList(String anime);
    }

    interface Presenter{
        void getSearchAnimeList(String anime);
        void showSearchAnimeList(ArrayList<AnimeSearchResults> searchAnimeList);
        void hideProgressBar();
        void onFailure(String failure);
    }

    interface View{
        void showSearchAnimeList(ArrayList<AnimeSearchResults> searchAnimeList);
        void hideProgressBar();
        void onFailure(String failure);
    }
}
