package com.wxb.commontest.modules.ThreadTest;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/16 16:15
 * @Version: 1.0
 */
@RequestMapping("/test/")
@RestController
public class ThreadLocalController {

    @GetMapping("/threadTest")
    public Map threadTest() throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        new Thread(() -> {
            try {
                new ThreadLocalController().numberAdd(numbers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                new ThreadLocalController().printFile(numbers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(numbers);
        return new HashMap<>() {{
            put("data", "234");
        }};
    }

    public synchronized void numberAdd(List numbers) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "开始执行");
        Thread.sleep(3000);
        numbers.add(1);
        System.err.println("线程 : " + Thread.currentThread().getName() + " number : " + JSON.toJSONString(numbers));
    }

    public synchronized void printFile(List numbers) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "开始执行");
        Thread.sleep(3000);
        numbers.add(2);
        System.err.println("线程 : " + Thread.currentThread().getName() + " number : " + JSON.toJSONString(numbers));
    }
}
