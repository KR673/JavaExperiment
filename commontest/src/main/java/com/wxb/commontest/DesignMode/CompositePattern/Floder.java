package com.wxb.commontest.DesignMode.CompositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/1 15:31
 * @Version: 1.0
 */
public class Floder extends Component {

    private String name;
    private List<Component> components = new ArrayList<>();
    private Integer level;

    public Floder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(Component component) {
        this.components.add(component);
    }

    @Override
    public void remover(Component component) {
        this.components.remove(component);
    }

    @Override
    public void print() {
        System.out.println(this.getName());

        if(this.level == null){
            this.level = 1;
        }

        String profix = "";

        for (int i = 0; i < level; i++) {
            profix += "--";
        }

        for (Component component : this.components) {

            if(component instanceof Floder){
                ((Floder) component).level = this.level + 1;
            }
            System.out.print(profix);
            component.print();
        }
    }

    @Override
    public String getContent() {
        return null;
    }

}
