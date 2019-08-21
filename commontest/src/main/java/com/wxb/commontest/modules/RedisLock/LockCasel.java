package com.wxb.commontest.modules.RedisLock;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/8/21 11:27
 * @Version: 1.0
 */
public class LockCasel extends RedisLock{
    public LockCasel(RedisProperties.Jedis jedis, String lockKey) {
        super(jedis, lockKey);
    }

}
