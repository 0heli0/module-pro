package com.module.pro.apply.moduleproapply;

import java.util.List;

public class CustomThread extends Thread {
    private Handler handler;

    public CustomThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            handler.custom();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
