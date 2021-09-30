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
import android.widget.Toast;

import com.example.animemotion.R;
import com.example.animemotion.interfaces.IHomeFragment;
import com.example.animemotion.interfaces.OnBackPressedListener;
import com.example.animemotion.model.JikanTopAnimeList;
import com.example.animemotion.presenter.HomeFragmentPresenterImpl;
import com.example.animemotion.utils.UtilsNetwork;
import com.example.animemotion.view.AdapterListTopAnime;
import com.example.animemotion.view.HomeActivityView;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements IHomeFragment.View, OnBackPressedListener{
    private IHomeFragment.Presenter presenter;
    private RecyclerView recyclerTopAnime;
    private ProgressBar indeterminateBar;
    private static ArrayList<JikanTopAnimeList> arrayTop;
    private FragmentContainerView fragmentContainerInfo;
    public static OnBackPressedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomeFragmentPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerTopAnime = root.findViewById(R.id.recycler_top_anime);
        indeterminateBar = root.findViewById(R.id.indeterminate_progress_bar);
        fragmentContainerInfo = root.findViewById(R.id.fragment_container_info);
        if(getContext() != null){
            init();
        }
        return root;
    }

    public void init(){
        if(UtilsNetwork.isOnline(getContext())){
            if(arrayTop == null){
                presenter.getTopAnimeList();
            }else{
                hideProgressBar();
                listTopAnime(arrayTop);
            }
        }else {
            Toast.makeText(getContext(),"No hay internet",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        listener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        listener = this;
    }


    @Override
    public void showTopAnimeList(ArrayList<JikanTopAnimeList> topAnimeList) {
        arrayTop = topAnimeList;
        listTopAnime(topAnimeList);
    }

    @Override
    public void hideProgressBar() {
        indeterminateBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String failure) {
        Toast.makeText(getContext(), failure, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        recyclerTopAnime.setVisibility(View.VISIBLE);
        fragmentContainerInfo.setVisibility(View.GONE);
    }

    private void listTopAnime(ArrayList<JikanTopAnimeList> array){
            AdapterListTopAnime listAdapter = new AdapterListTopAnime(array, getContext());
            recyclerTopAnime.setLayoutManager(new LinearLayoutManager(getContext()));
            listAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HomeActivityView.idAnime = array.get(recyclerTopAnime.getChildAdapterPosition(view)).getMal_id();
                    int id = array.get(recyclerTopAnime.getChildAdapterPosition(view)).getMal_id();
                    Bundle data = new Bundle();
                    AnimeInfoFragment fragment = new AnimeInfoFragment();
                    data.putInt("id_anime", id);
                    fragment.setArguments(data);
                    FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container_info, fragment)
                    .addToBackStack(null);
                    ft.commit();
                    fragmentContainerInfo.setVisibility(View.VISIBLE);
                    recyclerTopAnime.setVisibility(View.GONE);
                }
            });
            recyclerTopAnime.setAdapter(listAdapter);
    }

}