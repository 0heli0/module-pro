package com.module.pro.apply.moduleproapply.conditonTest;

import com.module.pro.apply.moduleproapply.singleton.Singleton3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    private static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();
    static int count;
    private static int num = 1;


    public static void main(String[] args) throws InterruptedException{
       /* while (count < 30) {
            ConditionTreadA a = new ConditionTreadA();
            ConditionTreadB b = new ConditionTreadB();
            ConditionTreadC c = new ConditionTreadC();
            a.start();
            b.start();
            c.start();
            count++;
        }
*/
       Integer a= 6;
       aa(a);
        System.err.println(a);
    }
    static void aa(Integer a){
        a = 155;
    }

    static class ConditionTreadA extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {

                while (num != 1) {
                    conditionA.await();
                }
                num = 2;
                System.out.print("A");
                conditionB.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    static class ConditionTreadB extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                while (num != 2) {
                    conditionB.await();
                }
                num = 3;
                System.out.print("B");
                conditionC.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    static class ConditionTreadC extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                while (num != 3) {
                    conditionC.await();
                }
                num = 1;
                System.out.print("C");
                System.out.println();
                conditionA.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

}
