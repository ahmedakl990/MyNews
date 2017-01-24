package com.example.hp.mynews.datafetch;

/**
 * Created by ahmed akl on 1/24/2017.
 */

public class NewsData {

    private String url;
    private String img;
    private String desc;
    private String title;

    public NewsData() {
    }

    public NewsData(String url, String img, String desc, String title) {
        this.url = url;
        this.img = img;
        this.desc = desc;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
}
