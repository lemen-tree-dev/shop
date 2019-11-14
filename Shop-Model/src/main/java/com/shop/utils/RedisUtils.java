package com.shop.utils;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author HeXiaoH
 * @date 2019/10/11 17:48
 */
@Component
public class RedisUtils {
    @Resource
    private RedisTemplate redisTemplate;

    //添加 获取

    /**
     * 获取普通缓存
     * @param key
     * @return
     */
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object obj){
        try {
            redisTemplate.opsForValue().set(key, obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加普通缓存
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key, Object value, long time){
        try {
            if(time > 0){
                redisTemplate.opsForValue().set(key, value, time);
                return true;
            } else {
                redisTemplate.opsForValue().set(key, value);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * hset
     * @param key
     * @param filed
     * @param value
     * @return
     */
    public boolean hset(String key, String filed,Object value){
        try {
            redisTemplate.opsForHash().put(key,filed,value);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 获取全部hget
     * @param key
     * @return
     */
    public Map hgetAll(String key){
        try {
            Map entries = redisTemplate.opsForHash().entries(key);
            return entries;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * hmget  [value1, value2] // 获取对于的键  值 没有就返回空
     * @param key
     * @param field
     * @return
     */
    public List hget(String key,List field){
        try {
            List list = redisTemplate.opsForHash().multiGet(key, field);
            return list;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取某个list中所有的值
     * @param key
     * @return
     */
    public List<Object> getList(String key){
        try {
            return redisTemplate.opsForList().range(key, 0, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 存一个list
     * @param key 键
     * @param value 值
     * @return false失败
     */
    public boolean setList(String key, Object value){
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 设置过期时间
     * @param key
     * @param seconds
     * @return
     */
    public boolean expire(String key,int seconds){
        Boolean expire = redisTemplate.expire(key, seconds, TimeUnit.MILLISECONDS);
        return expire;
    }
}
