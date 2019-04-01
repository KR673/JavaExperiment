package com.wxb.commontest.JavaScriptTest;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/2/19 9:32
 * @Version: 1.0
 */
public class JavaScriptTest {

    static ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");

    public static void main(String[] args) throws ScriptException {

        String test = "(x + 1) * 1212.311231% + 192.32%";

//        System.out.println(test = test.replaceAll("(\\d\\.?\\d{1})(\\%)", "$1/100"));
        System.out.println(test = test.replaceAll("\\%", "/100"));
//        System.out.println(scriptEngine.eval(test.replaceAll("[x]", "3.2")));
        //System.out.println(scriptEngine.eval(test));
    }

}
