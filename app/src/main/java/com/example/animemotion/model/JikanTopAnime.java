package com.example.animemotion.model;

import java.util.ArrayList;
import java.util.List;

public class JikanTopAnime {
    private String request_hash;
    private boolean request_cached;
    private int request_cache_expiry;
    private ArrayList<JikanTopAnimeList> top;

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

    public ArrayList<JikanTopAnimeList> getTop() {
        return top;
    }

    public void setTop(ArrayList<JikanTopAnimeList> top) {
        this.top = top;
    }
}
