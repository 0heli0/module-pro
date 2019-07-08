package com.module.pro.apply.moduleproapply.conditonTest;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTreadB extends Thread{

    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Integer[] flag = new Integer[1];
    private int num;

    @Override
    public void run() {
        super.run();
        lock.lock();
        try {
            if(flag[0]  != 2){
                condition.await();
            }
            flag[0] = 3;
            System.out.print("B");
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
