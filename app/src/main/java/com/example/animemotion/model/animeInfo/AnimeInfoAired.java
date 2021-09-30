package com.example.animemotion.model.animeInfo;

import java.util.List;

public class AnimeInfoAired {
    private String From;
    private String  to;
    private AnimeInfoProp prop;
    private String string;

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public AnimeInfoProp getProp() {
        return prop;
    }

    public void setProp(AnimeInfoProp prop) {
        this.prop = prop;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
