package com.dzc.bean;

import org.springframework.context.annotation.Bean;

public class DowJonesNewsRegisterImpl implements NewsRegister {
    public void registerNews() {
        System.out.println("存储DowJones新闻消息");
    }

//    @Bean
//    public NewsListenner newsListenner(){
//        return null;
//    }
}
