package com.module.pro.apply.moduleproapply;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 {
    volatile private static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();

    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();

    public static void main(String[] args){

        Thread threadA = new Thread(){
            public void run(){
                try {
                    lock.lock();
                    while(nextPrintWho != 1){
                        conditionA.await();
                    }

                        System.out.print("ThreadA-");
                    nextPrintWho = 2;
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        };


        Thread threadB = new Thread(){
            public void run(){
                try {
                    lock.lock();
                    while(nextPrintWho != 2){
                        conditionB.await();
                    }

                        System.out.print("ThreadB-");
                    nextPrintWho = 3;
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        };

        Thread threadC = new Thread(){
            public void run(){
                try {
                    lock.lock();
                    while(nextPrintWho != 3){
                        conditionC.await();
                    }

                        System.out.println("ThreadC");
                    nextPrintWho = 1;
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        };


        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];

        for(int i=0;i<5;i++){

            Thread A = new Thread(threadA);
            Thread B = new Thread(threadB);
            Thread C = new Thread(threadC);
            A.start();
            B.start();
            C.start();

           /* aArray[i].start();
            bArray[i].start();
            cArray[i].start();*/
        }

    }

}
