package com.module.pro.apply.moduleproapply;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {
        method01();

    }

    static void method01(){
        List<Integer> queue = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            queue.add(i);
        }

        int count = 1;
        int startNum = 0;
        while (queue.size() > 0) {
            System.err.print("count:"+count+" ");
            if(queue.size() == 1){
                System.err.println();
                System.err.print(queue.get(0));
                queue.remove(0);
                return;
            }
            startNum = startNum%queue.size();
            if(count == 3){
                System.err.println("startNum:"+(startNum+1)+" queue.size:"+queue.size()+" queue.remove:"+queue.get(startNum));
                queue.remove(startNum);
                startNum = startNum - 1;
                count = 0;
            }
            startNum++;
            count++;
        }
    }

    static void method02(){
        List<Integer> queue = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }
    }
}
