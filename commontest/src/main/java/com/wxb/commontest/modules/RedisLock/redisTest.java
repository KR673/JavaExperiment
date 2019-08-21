package com.wxb.commontest.modules.RedisLock;

import com.wxb.commontest.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/21 10:45
 * @Version: 1.0
 */
@Component
public class redisTest {

    @Autowired
    private RedisUtils redisUtils;

    public void redisTest(){
        redisUtils.set("abc", 1);

        System.out.println(redisUtils.get("abc"));
    }

}
