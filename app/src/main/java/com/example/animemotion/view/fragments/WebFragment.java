package com.example.animemotion.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.animemotion.R;
import com.example.animemotion.interfaces.IAnimeCapsFragment;
import com.example.animemotion.model.animecaps.AnimeCapsData;
import com.example.animemotion.presenter.AnimeCapsFragmentPresenterImpl;

public class WebFragment extends Fragment implements IAnimeCapsFragment.View {
    private WebView web_caps;
    private IAnimeCapsFragment.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AnimeCapsFragmentPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_web, container, false);
        web_caps = root.findViewById(R.id.web_caps);
        Bundle data = getArguments();
        int id = data.getInt("anime_caps");
        System.out.println("BUSCAR CAPITULO: "+id);

        presenter.getAnimeCaps(id);
        return root;
    }

    private void cargarPagina(String id) {
//        System.out.println("RESULTADO: "+id);
        web_caps.loadUrl(id);
    }

    @Override
    public void showAnimeCaps(AnimeCapsData animeCapsData) {
        System.out.println("RESULTADO: "+animeCapsData.getVideo_url());
        cargarPagina(animeCapsData.getVideo_url());
    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onFailure(String failure) {

    }
}