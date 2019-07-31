package com.wxb.commontest.DesignMode.MementoPattern;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/30 21:14
 * @Version: 1.0
 */
@Data
public class MementoCaretaker {
    private List<SteamNameMemento> mementos = new ArrayList<>();

    public void addMemento(SteamNameMemento memento){
        mementos.add(memento);
    }

    public SteamNameMemento getMemento(Integer index){

        if(index > mementos.size()){
            return new SteamNameMemento("");
        }

        return mementos.get(index);
    }
}
