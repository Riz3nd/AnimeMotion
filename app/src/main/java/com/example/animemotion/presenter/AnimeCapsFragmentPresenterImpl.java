package com.example.animemotion.presenter;

import com.example.animemotion.interfaces.IAnimeCapsFragment;
import com.example.animemotion.model.animecaps.AnimeCapsData;
import com.example.animemotion.model.iterator.AnimeCapsFragmentIteratorImpl;

public class AnimeCapsFragmentPresenterImpl implements IAnimeCapsFragment.Presenter {
    private IAnimeCapsFragment.Iterator iterator;
    private IAnimeCapsFragment.View view;

    public AnimeCapsFragmentPresenterImpl(IAnimeCapsFragment.View view) {
        this.view = view;
        iterator = new AnimeCapsFragmentIteratorImpl(this);
    }

    @Override
    public void getAnimeCaps(int mal_id) {
        iterator.getAnimeCaps(mal_id);
    }

    @Override
    public void showAnimeCaps(AnimeCapsData animeCapsData) {
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
