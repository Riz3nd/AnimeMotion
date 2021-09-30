package com.example.animemotion.model;

import com.example.animemotion.model.animeInfo.AnimeInfoAired;
import com.example.animemotion.model.animeInfo.AnimeInfoData;
import com.example.animemotion.model.animeInfo.AnimeInfoExternalLinks;
import com.example.animemotion.model.animeInfo.AnimeInfoRelated;

import java.util.ArrayList;
import java.util.List;

public class AnimeInfo {
    private String request_hash;
    private boolean request_cached;
    private int request_cache_expiry;
    private int mal_id;
    private String url;
    private String image_url;
    private String trailer_url;
    private String title;
    private String title_english;
    private String title_japanese;
    private List<String> title_synonyms;
    private String type;
    private String source;
    private int episodes;
    private String status;
    private boolean airing;
    private AnimeInfoAired aired;
    private String duration;
    private String rating;
    private double score;
    private int scored_by;
    private int rank;
    private int popularity;
    private int favorites;
    private String synopsis;
    private String background;
    private String premiered;
    private String broadcast;
    private AnimeInfoRelated related;
    private List<AnimeInfoData> producers;
    private List<AnimeInfoData> licensors;
    private List<AnimeInfoData> studios;
    private List<AnimeInfoData> genres;
    private List<AnimeInfoData> explicit_genres;
    private List<AnimeInfoData> demographics;
    private List<AnimeInfoData> themes;
    private List<String> opening_themes;
    private List<String> ending_themes;
    private List<AnimeInfoExternalLinks> external_links;

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

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_english() {
        return title_english;
    }

    public void setTitle_english(String title_english) {
        this.title_english = title_english;
    }

    public String getTitle_japanese() {
        return title_japanese;
    }

    public void setTitle_japanese(String title_japanese) {
        this.title_japanese = title_japanese;
    }

    public List<String> getTitle_synonyms() {
        return title_synonyms;
    }

    public void setTitle_synonyms(List<String> title_synonyms) {
        this.title_synonyms = title_synonyms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAiring() {
        return airing;
    }

    public void setAiring(boolean airing) {
        this.airing = airing;
    }

    public AnimeInfoAired getAired() {
        return aired;
    }

    public void setAired(AnimeInfoAired aired) {
        this.aired = aired;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getScored_by() {
        return scored_by;
    }

    public void setScored_by(int scored_by) {
        this.scored_by = scored_by;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public AnimeInfoRelated getRelated() {
        return related;
    }

    public void setRelated(AnimeInfoRelated related) {
        this.related = related;
    }

    public List<AnimeInfoData> getProducers() {
        return producers;
    }

    public void setProducers(List<AnimeInfoData> producers) {
        this.producers = producers;
    }

    public List<AnimeInfoData> getLicensors() {
        return licensors;
    }

    public void setLicensors(List<AnimeInfoData> licensors) {
        this.licensors = licensors;
    }

    public List<AnimeInfoData> getStudios() {
        return studios;
    }

    public void setStudios(List<AnimeInfoData> studios) {
        this.studios = studios;
    }

    public List<AnimeInfoData> getGenres() {
        return genres;
    }

    public void setGenres(List<AnimeInfoData> genres) {
        this.genres = genres;
    }

    public List<AnimeInfoData> getExplicit_genres() {
        return explicit_genres;
    }

    public void setExplicit_genres(List<AnimeInfoData> explicit_genres) {
        this.explicit_genres = explicit_genres;
    }

    public List<AnimeInfoData> getDemographics() {
        return demographics;
    }

    public void setDemographics(List<AnimeInfoData> demographics) {
        this.demographics = demographics;
    }

    public List<AnimeInfoData> getThemes() {
        return themes;
    }

    public void setThemes(List<AnimeInfoData> themes) {
        this.themes = themes;
    }

    public List<String> getOpening_themes() {
        return opening_themes;
    }

    public void setOpening_themes(List<String> opening_themes) {
        this.opening_themes = opening_themes;
    }

    public List<String> getEnding_themes() {
        return ending_themes;
    }

    public void setEnding_themes(List<String> ending_themes) {
        this.ending_themes = ending_themes;
    }

    public List<AnimeInfoExternalLinks> getExternal_links() {
        return external_links;
    }

    public void setExternal_links(List<AnimeInfoExternalLinks> external_links) {
        this.external_links = external_links;
    }
}
