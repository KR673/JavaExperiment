package com.wxb.commontest.modules.GenericityTest;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/15 15:33
 * @Version: 1.0
 */
public class GenericityTest {

    public static void main(String[] args) {
    }

}

class CommonTest<T>{
    T talk;

    public void output(interTest<? extends T> abc, interTest<? extends T> value){

    }
}

interface interTest<E>{
    E input(E value);
}