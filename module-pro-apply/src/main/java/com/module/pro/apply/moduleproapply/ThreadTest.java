package com.module.pro.apply.moduleproapply;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static Lock lock = new ReentrantLock();
    private static int count = 1;
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    static class ThreadA extends Thread {

        @Override
        public void run() {

            lock.lock();
//            System.err.print("A");
            try {
                    while (count != 1) {
                        A.await(); // 会释放lock锁
                    }
                count = 2;
                System.out.print("A");
                B.signal(); // 唤醒相应线程

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class ThreadB extends Thread {

        @Override
        public void run() {

            lock.lock();
//            System.err.print("B");
            try {
                    while (count != 2) {
                        B.await();
                    }
                count = 3;
                System.out.print("B");

                C.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class ThreadC extends Thread {

        @Override
        public void run() {
            lock.lock();
//            System.err.print("C");
            try {
                    while (count  != 3){
                        C.await();
                    }
                System.out.println("C");
                count = 1;
                A.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread threadA = new ThreadA();
            Thread threadB = new ThreadB();
            Thread threadC = new ThreadC();
            threadA.start();
            threadB.start();
            threadC.start();
        }
    }
}
