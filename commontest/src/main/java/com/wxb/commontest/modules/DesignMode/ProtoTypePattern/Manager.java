package com.wxb.commontest.modules.DesignMode.ProtoTypePattern;

import com.mchange.v2.codegen.bean.CloneableExtension;

import java.util.HashMap;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/23 16:33
 * @Version: 1.0
 */
public class Manager extends CloneableExtension {

    private HashMap<String, Product> center = new HashMap<>();

    public void register(String name, Product product){
        center.put(name, product);
    }

    public Product create(String name){
        return center.get(name).getClone();
    }

}
