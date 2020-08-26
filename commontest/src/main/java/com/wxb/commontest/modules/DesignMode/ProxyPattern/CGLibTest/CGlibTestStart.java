package com.wxb.commontest.modules.DesignMode.ProxyPattern.CGLibTest;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/22 16:41
 * @Version: 1.0
 */
public class CGlibTestStart {
    public static void main(String[] args) {

        CGlibObject cGlibObject = new CGlibObject();
        CGlibTest cGlibTest = new CGlibTest();

        CGlibObject instance = (CGlibObject)cGlibTest.getInstance(cGlibObject);

        instance.output();
        instance.input();

    }
}
