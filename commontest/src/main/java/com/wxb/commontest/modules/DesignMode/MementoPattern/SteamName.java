package com.wxb.commontest.modules.DesignMode.MementoPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/30 21:12
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class SteamName {

    private String name;

    //保存状态
    public SteamNameMemento save() {
        return new SteamNameMemento(this.name);
    }

    //恢复状态
    public void restore(SteamNameMemento memento) {
        this.name = memento.getName();
    }

    public void show(){
        System.out.println(this.name);
    }
}
