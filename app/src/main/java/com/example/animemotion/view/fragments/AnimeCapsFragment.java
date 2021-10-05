package com.example.animemotion.view.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.animemotion.R;
import com.example.animemotion.interfaces.IAnimeCapsFragment;
import com.example.animemotion.model.animecaps.AnimeCapsData;
import com.example.animemotion.presenter.AnimeCapsPresenter;

import java.util.ArrayList;

public class AnimeCapsFragment extends Fragment implements IAnimeCapsFragment.View {
    private WebView web_caps;
    private IAnimeCapsFragment.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AnimeCapsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_web, container, false);
        web_caps = root.findViewById(R.id.web_caps);
        WebSettings webSettings = web_caps.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Bundle data = getArguments();
        int id = data.getInt("anime_caps");
        presenter.getAnimeCaps(id);
        return root;
    }

    private void cargarPagina(String url) {
        web_caps.loadUrl(url);
    }

    @Override
    public void showAnimeCaps(ArrayList<AnimeCapsData> animeCapsData) {
        cargarPagina(animeCapsData.get(0).getVideo_url());
    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onFailure(String failure) {

    }
}