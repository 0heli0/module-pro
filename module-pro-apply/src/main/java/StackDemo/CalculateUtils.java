package StackDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CalculateUtils {
    public static void main(String[] args) {
        getI(1);
    }
    static void getI(int i){
        int j = i++;
        System.err.println(i);
        System.err.println(j+"---");
        if(i<5){
            getI(i);
        }
    }

    /**
     * 将中缀运算符转换为后缀运算符
     * @param param  2+5*(12-10)+6-5
     * @return
     */
    public static List<String> calculate(String param){
        param = param.replaceAll(" ", "");// 去除空格
        List<String> list = new ArrayList<>();
        Stack stack = new Stack();
        for (int i = 0; i < param.length(); i++) {
//            if(param.charAt(i))
        }
        return list;
    }
}
