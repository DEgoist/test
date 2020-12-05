package com.dzc.bean;

public class XhsNewsProvider extends  NewsProvider {
    public XhsNewsProvider(XhsNewsListennerImpl newsListenner, XhsNewsRegisterImpl newsRegister) {
        super(newsListenner, newsRegister);
    }
}
