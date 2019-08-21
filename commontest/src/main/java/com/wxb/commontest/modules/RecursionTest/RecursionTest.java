package com.wxb.commontest.modules.RecursionTest;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/15 10:52
 * @Version: 1.0
 */
public class RecursionTest {

    public static void main(String[] args) {
        System.out.println(multiplyTenTimes(10, 10));
    }

    //一个数的n次幂
    public static double multiplyTenTimes(int times , int number){

        if(times == 1){
            return number;
        }else {
            times-=1;
            return number * multiplyTenTimes(times, number);
        }
    }
}

