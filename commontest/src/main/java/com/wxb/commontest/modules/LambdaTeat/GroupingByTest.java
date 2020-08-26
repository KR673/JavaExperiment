package com.wxb.commontest.modules.LambdaTeat;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/28 10:25
 * @Version: 1.0
 */
public class GroupingByTest {

    public static void main(String[] args) throws InterruptedException {
        List<String> dynamicCharector = new ArrayList<>() {{
            add("\\");
            add("|");
            add("-");
            add("/");
            add("|");
            add("-");
        }};

        List<String> progress = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            progress.add(".");
        }

        int count = 1000;
        for (int i = 0; i < count; i++) {
            Thread.sleep(100);

            int progressInt =  i * 100 / 1000;
            for (int j = 0; j < progressInt; j++) {
                progress.set(j, "*");
            }

            String showProgress = progress.stream().collect(Collectors.joining(""));
            System.out.print("\r进度 : [" + showProgress + "]");
        }
    }

}

@Data
class User {
    private Integer age;
    private String userName;

    public User(Integer age, String userName) {
        this.age = age;
        this.userName = userName;
    }
}