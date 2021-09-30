package com.example.animemotion.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.animemotion.R;
import com.example.animemotion.interfaces.OnBackPressedListener;
import com.example.animemotion.model.JikanTopAnimeList;
import com.example.animemotion.view.fragments.HomeFragment;
import com.example.animemotion.view.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivityView extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private BottomNavigationView btnNavMenu;
    private SearchView search_view_bar;
    public static int idAnime;
    public static String anime;
    private AdapterListSearchAnime listAdapter;
    protected OnBackPressedListener onBackPressedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        search_view_bar = findViewById(R.id.search_view_bar);
        search_view_bar.setOnQueryTextListener(this);
        showSelectedFragment(new HomeFragment());
        btnNavMenu = (BottomNavigationView) findViewById(R.id.btnNavMenu);
        btnNavMenu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_search:
//                    showSelectedFragment(new SearchFragment());
                    break;
                case R.id.menu_home:
                    showSelectedFragment(new HomeFragment());
                    break;
                case R.id.menu_info:
                    break;
            }
            return false;
        });
    }

    public void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContent, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(HomeFragment.listener != null){
            HomeFragment.listener.onBackPressed();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if(!query.isEmpty()){
            anime = query;
            showSelectedFragment(new SearchFragment());
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(!newText.isEmpty() && newText.length() > 3){
            anime = newText;
            showSelectedFragment(new SearchFragment());
        }
        return false;
    }
}