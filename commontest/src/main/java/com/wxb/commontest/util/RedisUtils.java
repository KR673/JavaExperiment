package com.wxb.commontest.util;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.wxb.commontest.redistemplate.MyRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author 施龙飞
 * @email 3076308873@qq.com
 * @date 2018-12-25 21:20
 */
@Component
public class RedisUtils {
    @Autowired
    private MyRedisTemplate initRedisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private HashOperations<String, String, Object> hashOperations;
    @Autowired
    private ListOperations<String, String> listOperations;
    @Autowired
    private SetOperations<String, String> setOperations;


    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24 * 5-60*60*6;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;

    /**
     * 首页的失效时长
     */
    public final static long INDEX_EXPIRE = 60 * 60 * 15;

    /**
     * 首页的失效时长
     */
    public final static long CAPTCHA_EXPIRE = 60 * 60 * 5;

    /**
     * 一天的失效时间
     */
    public final static long ONE_DAY_EXPIRE = 60 * 60 * 24;

    private final static Gson gson = new Gson();

    public void setExpireTime(String key, long expire) {
        initRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public void set(String key, Object value, long expire) {
        valueOperations.set(key, toJson(value));
        if (expire != NOT_EXPIRE) {
            initRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    public void setNotExpire(String key, Object value) {
        set(key, value, NOT_EXPIRE);
    }

    public void setIndex(String key, Object value) {
        set(key, value, INDEX_EXPIRE);
    }

    public void setCaptcha(String key, Object value) {
        set(key, value, CAPTCHA_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            initRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            initRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    /**
     * 可以选择库的获取key
     * @param key
     * @param expire
     * @param dbIndex
     * @return
     */
    public String getDbIndex(String key, long expire,Integer dbIndex) {
        MyRedisTemplate.REDIS_DB_INDEX.set(dbIndex);
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            initRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }


    public String getDbIndex(String key,Integer dbIndex) {
        return getDbIndex(key, NOT_EXPIRE,dbIndex);
    }

    public void delete(String key) {
        initRedisTemplate.delete(key);
    }

    public void deleteDbIndex(String key,Integer dbIndex) {
        MyRedisTemplate.REDIS_DB_INDEX.set(dbIndex);
        initRedisTemplate.delete(key);
    }

    /**
     * 存放hashSet
     *
     * @param key
     * @param value
     * @param label
     */
    public void setHashValue(String key, Object value, String label, Long expire) {
        hashOperations.put(key, label, value);
        if (expire != NOT_EXPIRE) {
            initRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void setHashValue(String key, Object value, String label) {
        hashOperations.put(key, label, value);
        initRedisTemplate.expire(key, DEFAULT_EXPIRE, TimeUnit.SECONDS);
    }


    public String getHashValue(String key, String label) {
        String resultJson = (String) hashOperations.get(key, label);
        return resultJson;
    }

    /**
     * remove(移除存储的数据缓存)
     *
     * @param key type:String 缓存中的键值
     * @return key type:String 移除的键值
     * @throws
     * @since 1.0.0
     */
    public String remove(String key) {
        try {
            String result = get(key);
            initRedisTemplate.delete(key);
            return result;
        } catch (Exception e) {
            LoggerUtil.error(this.getClass(), "异常在bad()中处理");
        } finally {
        }
        return null;
    }

    /**
     * remove(移除存储的Map数据缓存)
     *
     * @param label type:String 缓存中map的键值
     * @return key type:String 移除的键值
     * @throws
     * @since 1.0.0
     */
    public Object removeHashValue(String key, String label) {
        try {
            String resutl = getHashValue(key, label);
            hashOperations.delete(key, label);
            return resutl;
        } catch (Exception e) {
            LoggerUtil.error(this.getClass(), "异常在bad()中处理");
        } finally {

        }
        return null;

    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return gson.toJson(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }


    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return initRedisTemplate.hasKey(key);
    }


    /**
     * 此方法将ArrayList集合直接存储为一个字符串
     *
     * @param key  存储的名字
     * @param list 要存储的集合对象
     */
    public <T> List<T> setArrayList(String key, List<T> list) {
        if (!CollectionUtils.isEmpty(list) && key != null && key != "") {
            setNotExpire(key, JSON.toJSONString(list));
        }
        return null;
    }

    /**
     * 此方法将会把存在redis中的数据取出来，并封装成相应的Arraylist集合
     *
     * @param key   存储的名字
     * @param clazz 要封装成为的javaBean
     * @return List
     */
    public <T> List<T> getArrayList(String key, Class<T> clazz) {
        if (key != null && key != "" && clazz != null) {
            List<T> list = JSON.parseArray(key, clazz);
            return list;
        }
        return null;
    }


    /**
     * 此方法将ArrayList集合直接存储为一个字符串
     *
     * @param key  存储的名字
     * @param list 要存储的集合对象
     */
    public <T> List<T> setMenuTreeArrayList(String key, List<T> list) {
        if (!CollectionUtils.isEmpty(list) && key != null && key != "") {
            setNotExpire(key, JSON.toJSONString(list));
        }
        return null;
    }


    /**
     * 首页使用此方法将ArrayList集合直接存储为一个字符串
     *
     * @param key  存储的名字
     * @param list 要存储的集合对象
     */
    public <T> List<T> setIndexArrayList(String key, List<T> list) {
        if (!CollectionUtils.isEmpty(list) && key != null && key != "") {
            setIndex(key, JSON.toJSONString(list));
        }
        return null;
    }


       /** 
        * 首页Map使用
    * HashSet 并设置时间 
    * @param key 键 
    * @param map 对应多个键值 
    * @param time 时间(秒) 
    * @return true成功 false失败 
    */
        public boolean hmsetIndex(String key, Map<String,Object> map){
            try{
            initRedisTemplate.opsForHash().putAll(key,map);
            initRedisTemplate.expire(key,INDEX_EXPIRE,TimeUnit.SECONDS);
            return true;
            }catch (Exception e){
                return false;
            }
        }

    /**
     * 首页使用获取Map
     * @param key
     * @return
     */
    public Map<Object,Object> hmgetIndex(String key){
            return initRedisTemplate.opsForHash().entries(key);
    }
}
