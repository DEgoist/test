package com.dzc.bean;

public class DowJonesNewsProvider extends NewsProvider{

    public DowJonesNewsProvider() {
        super();
    }

    public DowJonesNewsProvider(DowJonesNewsListennerImpl dowJonesNewsListenner, DowJonesNewsRegisterImpl dowJonesNewsRegister) {
        super(dowJonesNewsListenner, dowJonesNewsRegister);
    }
}
