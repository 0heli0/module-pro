package com.module.pro.apply.moduleproapply;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Handler {

    Lock lock = new ReentrantLock();
    List<Integer> goods = new ArrayList<>();

    /**
     * 生产
     *
     */
    public synchronized void produce() {

        while (goods.size() > 30) {
            try {
                System.err.println("商品已满");
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int num;
        if (goods.size() == 0) {
            num = 1;
        } else {
            num = goods.get(goods.size() - 1) + 1;
        }
        goods.add(num);
        System.out.print("生产了商品"+num+" 现有商品：");
        goods.forEach(item -> System.out.print(item + " "));
        System.out.println();
        this.notifyAll();

    }

    /**
     * 消费
     *
     */
    public synchronized void custom() {

        while (goods.size() <= 0) {
            try {
                System.err.println("没有库存");
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Integer num = goods.remove(goods.size() - 1);
        System.out.print("消费了"+num+" 剩余商品：");
        goods.forEach(item -> System.out.print(item + " "));
        System.out.println();
        this.notifyAll();
    }
}
