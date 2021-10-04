package com.example.animemotion.model;

import com.example.animemotion.model.animecaps.AnimeCapsData;

import java.util.ArrayList;

public class AnimeCaps {
    private String request_hash;
    private boolean request_cached;
    private int request_cache_expiry;
    private int episodes_last_page;
    private ArrayList<AnimeCapsData> episodes;

    public String getRequest_hash() {
        return request_hash;
    }

    public void setRequest_hash(String request_hash) {
        this.request_hash = request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public void setRequest_cached(boolean request_cached) {
        this.request_cached = request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public void setRequest_cache_expiry(int request_cache_expiry) {
        this.request_cache_expiry = request_cache_expiry;
    }

    public int getEpisodes_last_page() {
        return episodes_last_page;
    }

    public void setEpisodes_last_page(int episodes_last_page) {
        this.episodes_last_page = episodes_last_page;
    }

    public ArrayList<AnimeCapsData> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<AnimeCapsData> episodes) {
        this.episodes = episodes;
    }
}
