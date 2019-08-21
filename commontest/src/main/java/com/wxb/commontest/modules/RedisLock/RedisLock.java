package com.wxb.commontest.modules.RedisLock;


import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/21 10:45
 * @Version: 1.0
 */
public class RedisLock implements Lock {

    protected RedisProperties.Jedis jedis;
    protected String lockKey;

    public RedisLock(RedisProperties.Jedis jedis, String lockKey) {
        this.jedis = jedis;
        this.lockKey = lockKey;
    }

    public void sleepBySencond(int sencond){
        try {
            Thread.sleep(sencond*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
