package com.example.animemotion.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.animemotion.R;
import com.example.animemotion.interfaces.IAnimeInfoFragment;
import com.example.animemotion.model.AnimeInfo;
import com.example.animemotion.presenter.AnimeInfoFragmentPresenterImpl;
import com.example.animemotion.utils.UtilsNetwork;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class AnimeInfoFragment extends Fragment implements IAnimeInfoFragment.View {
    private IAnimeInfoFragment.Presenter presenter;
    private TextView synopsis_anime_info, title_info_anime, score_info_anime, geners_info_anime;
    private ImageView img_anime_info;
    private ProgressBar indeterminateBarInfo;
    private CardView card_img_info;
    private Translator translator;
    private String synopsis = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AnimeInfoFragmentPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_anime_info, container, false);
        synopsis_anime_info = root.findViewById(R.id.synopsis_anime_info);
        indeterminateBarInfo = root.findViewById(R.id.indeterminateBarInfo);
        img_anime_info = root.findViewById(R.id.img_anime_info);
        score_info_anime = root.findViewById(R.id.score_info_anime);
        geners_info_anime = root.findViewById(R.id.geners_info_anime);
        title_info_anime = root.findViewById(R.id.title_info_anime);
        card_img_info = root.findViewById(R.id.card_img_info);
        if(getContext() != null){
            init();
        }
        return root;
    }

    public void init(){
        Bundle data = getArguments();
        if(UtilsNetwork.isOnline(getContext())){
            if(data != null){
                int res = data.getInt("id_anime");
                presenter.getAnimeInfo(res);
            }
        }else{
            Toast.makeText(getContext(),"No hay internet",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showAnimeInfo(AnimeInfo animeInfo) {
        prepareModel(animeInfo.getSynopsis());

        String genres = "";
        title_info_anime.setText(animeInfo.getTitle());
        //synopsis_anime_info.setText("Synopsis: \n" + animeInfo.getSynopsis());
        score_info_anime.setText("Score: " + animeInfo.getScore());
            Glide.with(getContext())
                    .load(animeInfo.getImage_url())
                    .into(img_anime_info);
            for(int i = 0; i < animeInfo.getGenres().size(); i++){
                genres += animeInfo.getGenres().get(i).getName()+", ";
            }
            genres = genres.trim();
            genres = genres.substring(0,genres.length()-1);
            geners_info_anime.setText("Geners: " + genres);
    }

    @Override
    public void hideProgressBar() {
        indeterminateBarInfo.setVisibility(View.GONE);
        card_img_info.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailure(String failure) {
        Toast.makeText(getContext(),failure, Toast.LENGTH_SHORT).show();
    }

    public void prepareModel(String text) {
        TranslatorOptions options = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.SPANISH)
                .build();
        translator = Translation.getClient(options);

        translator.downloadModelIfNeeded().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                traducir(text);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public void traducir(String text) {
        translator.translate(text).addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String s) {
                synopsis = s;
                synopsis = synopsis.substring(0,synopsis.length()-27);
                synopsis_anime_info.setText("Synopsis: \n" + synopsis);
            }
        });
    }
}