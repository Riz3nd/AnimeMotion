package com.example.animemotion.model.animeInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnimeInfoRelated {
    private List<AnimeInfoData> Adaptation;
    @SerializedName("Alternative version")
    private List<AnimeInfoData> Alternative;
    @SerializedName("Side story")
    private List<AnimeInfoData> Side;
    @SerializedName("Spin-off")
    private List<AnimeInfoData> Spin;

    public List<AnimeInfoData> getAdaptation() {
        return Adaptation;
    }

    public void setAdaptation(List<AnimeInfoData> adaptation) {
        Adaptation = adaptation;
    }

    public List<AnimeInfoData> getAlternative() {
        return Alternative;
    }

    public void setAlternative(List<AnimeInfoData> alternative) {
        Alternative = alternative;
    }

    public List<AnimeInfoData> getSide() {
        return Side;
    }

    public void setSide(List<AnimeInfoData> side) {
        Side = side;
    }

    public List<AnimeInfoData> getSpin() {
        return Spin;
    }

    public void setSpin(List<AnimeInfoData> spin) {
        Spin = spin;
    }
}
