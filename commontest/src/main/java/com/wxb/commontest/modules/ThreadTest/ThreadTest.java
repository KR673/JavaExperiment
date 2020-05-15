package com.wxb.commontest.modules.ThreadTest;


import ch.qos.logback.core.util.TimeUtil;
import lombok.SneakyThrows;
import org.aspectj.weaver.ast.Var;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import java.io.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Description: 并发编程以及synchronized关键字的使用
 * @Author: WangXiaoBo
 * @Date: 2019/2/14 11:24
 * @Version: 1.0
 */
public class ThreadTest {

    //从配置文件中获得
    private static final String SITE_WIDE_SECRET = "admin";
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder(
);

    public static String encrypt(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean match(String rawPassword, String password) {
        return encoder.matches(rawPassword, password);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("admin"));
        //但是把每次结果拿出来进行match，你会发现可以得到true。
    }
}

