package com.dzc.bean;

public class NewsProvider {
    private NewsListenner newsListenner;
    private NewsRegister newsRegister;

    public NewsProvider() {

    }

    public NewsProvider(NewsListenner newsListenner, NewsRegister newsRegister) {
        this.newsListenner = newsListenner;
        this.newsRegister = newsRegister;
    }

    public void showNewsListerAndNewsRegister(){
        newsListenner.getNews();
        newsRegister.registerNews();
    }

    public NewsListenner getNewsListenner() {
        return newsListenner;
    }

    public void setNewsListenner(NewsListenner newsListenner) {
        this.newsListenner = newsListenner;
    }

    public NewsRegister getNewsRegister() {
        return newsRegister;
    }

    public void setNewsRegister(NewsRegister newsRegister) {
        this.newsRegister = newsRegister;
    }
}
