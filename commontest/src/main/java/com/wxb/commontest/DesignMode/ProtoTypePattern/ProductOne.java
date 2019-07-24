package com.wxb.commontest.DesignMode.ProtoTypePattern;

import com.wxb.commontest.Param;
import lombok.Data;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 17:32
 * @Version: 1.0
 */
@Data
public class ProductOne extends Product{

    private String param;

    public ProductOne(String param){
        this.param = param;
    }

    @Override
    public void method() {
        System.out.println("执行方法一, 参数为 : " + param);
    }

    @Override
    public Product getClone() {

        try {
            return (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

    }
}
