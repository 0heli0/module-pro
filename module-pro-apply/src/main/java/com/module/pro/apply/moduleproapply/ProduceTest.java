package com.module.pro.apply.moduleproapply;

import java.util.ArrayList;
import java.util.List;

public class ProduceTest {
    static List<Integer> goods = new ArrayList<>();
    static Handler producer = new Handler();

    public static void main(String[] args){
        ProduceThread produce = new ProduceThread(producer);
        CustomThread custom = new CustomThread(producer);
        for (int i = 0; i <20 ; i++) {

            Thread c = new Thread(custom);
            Thread p = new Thread(produce);
            Thread p2 = new Thread(produce);
            p2.start();
            p.start();
            c.start();

        }

    }
}
