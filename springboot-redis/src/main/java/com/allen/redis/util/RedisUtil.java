package com.allen.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author allen
 * @date 2022/9/16 10:32
 */
@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 设置过期时间（时间单位默认为 秒s）
     *
     * @param k key
     * @param t time
     * @return Boolean
     */
    public Boolean expire(String k, long t) {
        return redisTemplate.expire(k, t, TimeUnit.SECONDS);
    }

    /**
     * 设置过期时间（时间单位可选择）
     *
     * @param k key
     * @param t time
     * @param u timeUnit
     * @return Boolean
     */
    public Boolean expire(String k, long t, TimeUnit u) {
        return redisTemplate.expire(k, t, u);
    }

    /**
     * 指定 key，获取过期时间
     *
     * @param k k
     * @return long
     */
    public long getExpireTime(String k) {
        return k == null ? 0 : redisTemplate.getExpire(k, TimeUnit.SECONDS);
    }

    public <K, V> void set(K k, V v) {
        try {
            if (v != null) {
                redisTemplate.opsForValue().set(k, v);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public <K, V> void set(K k, V v, long t, TimeUnit unit) {
        try {
            if (v != null) {
                redisTemplate.opsForValue().set(k, v, t, unit);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public <K, V> V get(K k) {
        try {
            return k == null ? null :
                    (V) redisTemplate.opsForValue().get(k);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public void del(String... k) {
        if (k != null && k.length > 0) {
            if (k.length == 1) {
                redisTemplate.delete(k[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(k));
            }
        }

    }
}
