package com.example.animemotion.interfaces;

import com.example.animemotion.model.AnimeInfo;
import com.example.animemotion.model.JikanTopAnimeList;

import java.util.ArrayList;

public interface IAnimeInfoFragment {

    interface Iterator{
        void getAnimeInfo(int mal_id);
    }

    interface Presenter{
        void getAnimeInfo(int mal_id);
        void showAnimeInfo(AnimeInfo animeInfo);
        void hideProgressBar();
        void onFailure(String failure);
    }

    interface View{
        void showAnimeInfo(AnimeInfo animeInfo);
        void hideProgressBar();
        void onFailure(String failure);
    }

}
