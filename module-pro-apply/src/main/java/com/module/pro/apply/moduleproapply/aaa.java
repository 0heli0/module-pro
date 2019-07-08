package com.module.pro.apply.moduleproapply;

public class aaa {

    public static void main(String[] args) {
        new Child("mike");

    }

}
    class  People{
        String name;
        public People(){
            System.err.println(1);
        }
        public People(String name){
            System.err.println(2);
            this.name = name;
        }
        }
    class Child extends People{
        People father;
        public Child(String name){
            System.err.println(3);
            this.name = name;
            father = new People(name+":f");
        }
        public Child(){
            System.err.println(4);
        }
    }