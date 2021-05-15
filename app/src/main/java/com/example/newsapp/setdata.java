package com.example.newsapp;

public class setdata {
    String articlelink,heading;
    String im;

    public setdata(String im, String articlelink, String heading) {
        this.im = im;
        this.articlelink = articlelink;
        this.heading = heading;
    }


    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getArticlelink() {
        return articlelink;
    }

    public void setArticlelink(String articlelink) {
        this.articlelink = articlelink;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}
