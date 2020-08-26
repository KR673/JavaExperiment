package com.wxb.commontest.modules;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

class Animal {
    private void beat() {
        System.out.println("心脏跳动...");
    }

    public void breath() {
        beat();
        System.out.println("吸一口气，吐一口气，呼吸中...");
    }
}

class Bird {
    // 将原来的父类组合到原来的子类，作为子类的一个组合成分
    private Animal a;

    public Bird(Animal a) {
        this.a = a;
    }

    // 重新定义一个自己的breath()方法
    public void breath() {
        // 直接复用Animal提供的breath()方法来实现Bird的breath()方法。
        a.breath();
    }

    public void fly() {
        System.out.println("我在天空自在的飞翔...");
    }
}

class Wolf {
    // 将原来的父类组合到原来的子类，作为子类的一个组合成分
    private Animal a;
    // 重新定义一个自己的breath()方法
    public void breath() {
        // 直接复用Animal提供的breath()方法来实现Wolf的breath()方法。
        a.breath();
    }
    public void run() {
        System.out.println("我在陆地上的快速奔跑...");
    }
}

public class testtest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BigInteger bigInteger = new BigInteger("111111111111111111111111111111111111111111");
        BigInteger bigInteger2 = new BigInteger("3");
        BigInteger divide = bigInteger.multiply(bigInteger2);
        System.out.println(divide.toString());
    }
}
