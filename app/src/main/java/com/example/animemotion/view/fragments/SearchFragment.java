package com.example.animemotion.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.animemotion.R;
import com.example.animemotion.interfaces.ISearchFragment;
import com.example.animemotion.model.animesearch.AnimeSearchResults;
import com.example.animemotion.presenter.SearchPresenter;
import com.example.animemotion.view.AdapterListSearchAnime;
import com.example.animemotion.view.HomeActivity;

import java.util.ArrayList;

public class SearchFragment extends Fragment implements ISearchFragment.View {
    private ISearchFragment.Presenter presenter;
    private RecyclerView recycler_search_anime;
    private AdapterListSearchAnime listAdapter;
    private FragmentContainerView fragment_container_search;
    private ProgressBar indeterminate_progress_bar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SearchPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        recycler_search_anime = root.findViewById(R.id.recycler_search_anime);
        fragment_container_search = root.findViewById(R.id.fragment_container_search);
        indeterminate_progress_bar = root.findViewById(R.id.indeterminate_progress_bar);
        init();
        return root;
    }

    private void init() {
        String anime = HomeActivity.anime;
        presenter.getSearchAnimeList(anime);
    }

    @Override
    public void showSearchAnimeList(ArrayList<AnimeSearchResults> searchAnimeList) {
        listSearchAnime(searchAnimeList);
    }

    @Override
    public void hideProgressBar() {
        indeterminate_progress_bar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String failure) {

    }

    private void listSearchAnime(ArrayList<AnimeSearchResults> array){
        listAdapter = new AdapterListSearchAnime(array, getContext());
        recycler_search_anime.setLayoutManager(new LinearLayoutManager(getContext()));
        listAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.idAnime = array.get(recycler_search_anime.getChildAdapterPosition(view)).getMal_id();
                int id = array.get(recycler_search_anime.getChildAdapterPosition(view)).getMal_id();
                Bundle data = new Bundle();
                AnimeInfoFragment fragment = new AnimeInfoFragment();
                data.putInt("id_anime", id);
                fragment.setArguments(data);
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container_search, fragment)
                        .addToBackStack(null);
                ft.commit();
                fragment_container_search.setVisibility(View.VISIBLE);
                recycler_search_anime.setVisibility(View.GONE);
            }
        });
        recycler_search_anime.setAdapter(listAdapter);
    }

}