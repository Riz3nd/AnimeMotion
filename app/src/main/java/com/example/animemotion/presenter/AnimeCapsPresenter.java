package com.example.animemotion.presenter;

import com.example.animemotion.interfaces.IAnimeCapsFragment;
import com.example.animemotion.model.animecaps.AnimeCapsData;
import com.example.animemotion.model.iterator.AnimeCapsIterator;

import java.util.ArrayList;

public class AnimeCapsPresenter implements IAnimeCapsFragment.Presenter {
    private IAnimeCapsFragment.Iterator iterator;
    private IAnimeCapsFragment.View view;

    public AnimeCapsPresenter(IAnimeCapsFragment.View view) {
        this.view = view;
        iterator = new AnimeCapsIterator(this);
    }

    @Override
    public void getAnimeCaps(int mal_id) {
        iterator.getAnimeCaps(mal_id);
    }

    @Override
    public void showAnimeCaps(ArrayList<AnimeCapsData> animeCapsData) {
        view.showAnimeCaps(animeCapsData);
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
