package com.wxb.commontest.modules.ConsoleShow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/10/21 11:38
 * @Version: 1.0
 */
public class Progress {

    public static void main(String[] args) throws InterruptedException {

        int tatle = 1000;

        new Thread(() -> {for (int i = 0; i < tatle; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showProgress(tatle , i);

        }}).start();

        int tatle2 = 100;

        System.out.println();

        new Thread(() -> {for (int i = 0; i < tatle2; i++) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showProgress(tatle2 , i);

        }}).start();


    }

    public static void showProgress(int total, int progress){

        List<String> charactor = new ArrayList<>(100);

        for (int i = 0; i < 20; i++) {
            charactor.add("-");
        }

        int rate = progress * 20 / total;

        for (int i = 0; i < rate; i++) {
            charactor.set(i, "*");
        }
        String format = String.format("\r当前进度 : [%s] %.2f%%", charactor.stream().collect(Collectors.joining("")), (float)progress * 100 / total);
        System.out.print(format);
    }
}

