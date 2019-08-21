package com.wxb.commontest.redistemplate;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

public class MyRedisTemplate extends StringRedisTemplate {
    public static ThreadLocal<Integer> REDIS_DB_INDEX = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    @Override
    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        try {
            Integer dbIndex = REDIS_DB_INDEX.get();
            //如果设置了dbIndex
            if (dbIndex != null) {
                if (connection instanceof LettuceConnectionFactory) {
                    if (((LettuceConnectionFactory) connection).getDatabase() != dbIndex) {
                        connection.select(dbIndex);
                    }
                } else {
                    connection.select(dbIndex);
                }
            } else {
                connection.select(1);
            }
        } finally {
            REDIS_DB_INDEX.remove();
        }
        return super.preProcessConnection(connection, existingConnection);
    }
}
