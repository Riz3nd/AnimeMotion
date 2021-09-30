package com.example.animemotion.view;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.animemotion.R;
import com.example.animemotion.model.JikanTopAnimeList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterListTopAnime extends RecyclerView.Adapter<AdapterListTopAnime.viewHolder> implements View.OnClickListener {
    private ArrayList<JikanTopAnimeList> mData;
    private ArrayList<JikanTopAnimeList> originalData;
    private LayoutInflater mInflate;
    private Context context;
    private View.OnClickListener listener;

    public AdapterListTopAnime(ArrayList<JikanTopAnimeList> itemArray, Context context){
        this.mInflate = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemArray;
        this.originalData = new ArrayList<>();
        originalData.addAll(mData);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }

    @NonNull
    @Override
    public AdapterListTopAnime.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.list_element_home_fragment,null);
        view.setOnClickListener(this);
        return new AdapterListTopAnime.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListTopAnime.viewHolder holder, int position) {
        holder.binData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void filter(String strSearch){
        if(strSearch.length()==0){
            mData.clear();
            mData.addAll(originalData);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ArrayList<JikanTopAnimeList> lista = (ArrayList<JikanTopAnimeList>) mData.stream().filter(i -> i.getTitle().toLowerCase().contains(strSearch)).collect(Collectors.toList());
                mData.clear();
                mData.addAll(lista);
            }else{
                mData.clear();
                for (JikanTopAnimeList i: originalData){
                    if(i.getTitle().toLowerCase().contains(strSearch)){
                        originalData.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null ){
            listener.onClick(view);
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView titleTopAnime, scoreTop, episodesTop;
        private ImageView imgTopAnime;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titleTopAnime = itemView.findViewById(R.id.titleTopAnime);
            scoreTop = itemView.findViewById(R.id.scoreTop);
            imgTopAnime = itemView.findViewById(R.id.imgTopAnime);
            episodesTop = itemView.findViewById(R.id.episodesTop);
        }

        public void binData(final JikanTopAnimeList item) {
            titleTopAnime.setText(item.getTitle());
            scoreTop.setText(" " + item.getScore());
            episodesTop.setText("Capitulos: " + item.getEpisodes());
            Glide.with(context)
                    .load(item.getImage_url())
                    .into(imgTopAnime);
        }
    }
}
