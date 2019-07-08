package com.module.pro.apply.moduleproapply;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProduceThread extends Thread{

    private Handler handler;

    public ProduceThread(Handler handler){
        this.handler = handler;
    }

    @Autowired
    public void run(){
        try {
            handler.produce();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
