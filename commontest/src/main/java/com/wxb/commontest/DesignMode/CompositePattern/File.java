package com.wxb.commontest.DesignMode.CompositePattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/1 15:41
 * @Version: 1.0
 */
public class File extends Component{

    private String name;
    private String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remover(Component component) {
    }

    @Override
    public void print() {
        System.out.println(this.name);;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
