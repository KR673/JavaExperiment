package com.wxb.commontest.config;

import com.wxb.commontest.redistemplate.MyRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置
 *
 * @author 施龙飞
 * @email 3076308873@qq.com
 * @date 2018-12-25 21:20
 */
@Configuration
public class RedisConfig {

    @Autowired
    private LettuceConnectionFactory factory;

    @Bean
    public MyRedisTemplate initRedisTemplate() throws Exception {
        factory.setShareNativeConnection(false);
        MyRedisTemplate myRedisTemplate = new MyRedisTemplate();
        myRedisTemplate.setConnectionFactory(factory);
        myRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        myRedisTemplate.setKeySerializer(new StringRedisSerializer());
        myRedisTemplate.afterPropertiesSet();
        return myRedisTemplate;
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations(MyRedisTemplate initRedisTemplate) {
        return initRedisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations<String, String> valueOperations(MyRedisTemplate initRedisTemplate) {
        return initRedisTemplate.opsForValue();
    }

    @Bean
    public ListOperations<String, String> listOperations(MyRedisTemplate initRedisTemplate) {
        return initRedisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, String> setOperations(MyRedisTemplate initRedisTemplate) {
        return initRedisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, String> zSetOperations(MyRedisTemplate initRedisTemplate) {
        return initRedisTemplate.opsForZSet();
    }
}
