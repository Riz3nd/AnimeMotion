package com.example.animemotion.interfaces;

import com.example.animemotion.model.JikanTopAnimeList;

import java.util.ArrayList;

public interface IHomeFragment {

    interface Iterator{
        void getTopAnimeList();
    }

    interface Presenter{
        void getTopAnimeList();
        void showTopAnimeList(ArrayList<JikanTopAnimeList> topAnimeList);
        void hideProgressBar();
        void onFailure(String failure);
    }

    interface View{
        void showTopAnimeList(ArrayList<JikanTopAnimeList> topAnimeList);
        void hideProgressBar();
        void onFailure(String failure);
    }

}
