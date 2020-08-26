package com.wxb.commontest.modules;

import java.util.Arrays;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/9/4 13:37
 * @Version: 1.0
 */

public class CommonTest {
    public static void main(String[] args) {
//        Thread aaa = new Thread(() -> System.out.println("aaa"));
//        Parent parent = new Son("parent", 30);
//        Parent son = new Son("son", 10);
//        ArrayList<Parent> parentArrayList = new ArrayList<>();
//        parentArrayList.add(parent);
//        parentArrayList.add(son);
//        for (Parent p : parentArrayList) {
//            System.out.println("name :" + p.getName() + "\tage : " + p.getAge());
//        }
//        System.out.println("aaa");

        String[] array = { "e", "b", "c", "a", "d" };
        Arrays.sort(array, String.CASE_INSENSITIVE_ORDER);
        
    }
}
class Son extends Parent{

    public String name;
    public Integer age;

    public Son(String name , Integer age){
        super(name, age);
    }

    @Override
    protected void sayName() {
        System.out.println("Son");
    }

    public void playGame(){
       System.out.println("play game");
   }

}
class SonT extends Parent{

    public SonT(String name, Integer age) {
        super(name, age);
    }

    @Override
    protected void sayName() {
        System.out.println("SonT");
    }
}
abstract class Parent{
    public String name;
    public Integer age;

    public Parent(String name , Integer age){
        this.name = name;
        this.age = age;
    }
    protected abstract void sayName();

    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
}
