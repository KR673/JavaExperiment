package com.wxb.commontest.DesignMode.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/30 16:40
 * @Version: 1.0
 */
public class SubjectImpl implements Subject {

    //存放订阅者
    private List<Observer> observers=new ArrayList<Observer>();

    //期刊版本
    private int version;

    @Override
    public void addObserver(Observer obj) {

    }

    @Override
    public void deleteObserver(Observer obj) {

    }

    @Override
    public void notifyObserver() {

    }
}
