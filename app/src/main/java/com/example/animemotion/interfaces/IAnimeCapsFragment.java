package com.example.animemotion.interfaces;

import com.example.animemotion.model.animecaps.AnimeCapsData;

import java.util.ArrayList;

public interface IAnimeCapsFragment {

    interface Iterator{
        void getAnimeCaps(int mal_id);
    }

    interface Presenter{
        void getAnimeCaps(int mal_id);
        void showAnimeCaps(ArrayList<AnimeCapsData> animeCapsData);
        void hideProgressBar();
        void onFailure(String failure);
    }

    interface View{
        void showAnimeCaps(ArrayList<AnimeCapsData> animeCapsData);
        void hideProgressBar();
        void onFailure(String failure);
    }

}
