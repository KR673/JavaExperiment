package com.wxb.commontest.LambdaTeat;

/**
 * @Description: 函数式编程
 * @Author: WangXiaoBo
 * @Date: 2018/11/3 14:34
 * @Version: 1.0
 */
public class LambdaTest {

    public static void main(String[] args) {

        // 第一种
        outputNumber(() -> System.out.println("1")).getNumber();

        // 第二种
        FunctionInterface functionInterface = () -> System.out.println("adv");
        functionInterface.getNumber();

    }

    public static FunctionInterface outputNumber(FunctionInterface number){
        return number;
    }

}

//函数式借口
interface FunctionInterface {
    void getNumber();
}