package com.example.animemotion.model.animecaps;

public class AnimeCapsData {
    private int episode_id;
    private String title;
    private String title_japanese;
    private String title_romanji;
    private boolean filler;
    private boolean recap;
    private String video_url;
    private String forum_url;

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_japanese() {
        return title_japanese;
    }

    public void setTitle_japanese(String title_japanese) {
        this.title_japanese = title_japanese;
    }

    public String getTitle_romanji() {
        return title_romanji;
    }

    public void setTitle_romanji(String title_romanji) {
        this.title_romanji = title_romanji;
    }

    public boolean isFiller() {
        return filler;
    }

    public void setFiller(boolean filler) {
        this.filler = filler;
    }

    public boolean isRecap() {
        return recap;
    }

    public void setRecap(boolean recap) {
        this.recap = recap;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getForum_url() {
        return forum_url;
    }

    public void setForum_url(String forum_url) {
        this.forum_url = forum_url;
    }
}
