package com.wxb.commontest.DesignMode.FactoryPattern.SimpleFactoyPattern;

import java.util.Objects;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/20 16:55
 * @Version: 1.0
 */
public class CarFactory {

    public static CarType getCar(String car){
        if(Objects.equals(car, "benz")){
            return new Benz();
        }else if(Objects.equals(car, "bmw")){
            return new Bmw();
        }else{
            return new Benz();
        }
    }
}
