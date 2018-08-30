/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author fuyang
 * @version $Id: RedisService.java, v 0.1 2018年08月30日 下午6:04 fuyang Exp $
 */
public class RedisService {

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Expire.
     *
     * @param key  the key
     * @param time the time
     */
    public void expire(String key, long time) {
        if (time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * Gets get expire.
     *
     * @param key the key
     * @return the get expire
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * Has key boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * Delete.
     *
     * @param key the key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Get object.
     *
     * @param key the key
     * @return the object
     */
    public Object get(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * Set.
     *
     * @param key   the key
     * @param value the value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * Incr long.
     *
     * @param key  the key
     * @param step the step
     * @return the long
     */
    public long incr(String key, long step) {
        if (step < 0) {
            return 0;
        }
        return redisTemplate.opsForValue().increment(key, step);
    }

    /**
     * Hget object.
     *
     * @param key  the key
     * @param item the item
     * @return the object
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * Hmget map.
     *
     * @param key the key
     * @return the map
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * Hset.
     *
     * @param key   the key
     * @param item  the item
     * @param value the value
     */
    public void hset(String key, String item, Object value) {
        redisTemplate.opsForHash().put(key, item, value);
    }

    /**
     * Hmset.
     *
     * @param key the key
     * @param map the map
     */
    public void hmset(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * Hdel.
     *
     * @param key  the key
     * @param item the item
     */
    public void hdel(String key, String item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * H has key boolean.
     *
     * @param key  the key
     * @param item the item
     * @return the boolean
     */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * Hincr long.
     *
     * @param key  the key
     * @param item the item
     * @param step the step
     * @return the long
     */
    public long hincr(String key, String item, long step) {
        return redisTemplate.opsForHash().increment(key, item, step);
    }

    /**
     * Hlen long.
     *
     * @param key the key
     * @return the long
     */
    public long hlen(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * S get set.
     *
     * @param key the key
     * @return the set
     */
    public Set<Object> sGet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * S has key boolean.
     *
     * @param key  the key
     * @param item the item
     * @return the boolean
     */
    public boolean sHasKey(String key, String item) {
        return redisTemplate.opsForSet().isMember(key, item);
    }

    /**
     * S set.
     *
     * @param key    the key
     * @param values the values
     */
    public void sSet(String key, Object... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    /**
     * S delete.
     *
     * @param key    the key
     * @param values the values
     */
    public void sDelete(String key, Object... values) {
        redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * S size long.
     *
     * @param key the key
     * @return the long
     */
    public long sSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * L get list.
     *
     * @param key the key
     * @return the list
     */
    public List<Object> lGet(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * Lsize long.
     *
     * @param key the key
     * @return the long
     */
    public long lsize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * L get index object.
     *
     * @param key   the key
     * @param index the index
     * @return the object
     */
    public Object lGetIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * L set.
     *
     * @param key   the key
     * @param value the value
     */
    public void lSet(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * L set.
     *
     * @param key    the key
     * @param values the values
     */
    public void lSet(String key, List<String> values) {
        redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * L set index.
     *
     * @param key   the key
     * @param index the index
     * @param value the value
     */
    public void lSetIndex(String key, long index, Object value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * Ldelete.
     *
     * @param key   the key
     * @param count the count
     * @param value the value
     */
    public void ldelete(String key, long count, Object value) {
        redisTemplate.opsForList().remove(key, count, value);
    }

    /**
     * L trim.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     */
    public void lTrim(String key, long start, long end) {
        redisTemplate.opsForList().trim(key, start, end);
    }

    /**
     * L poll object.
     *
     * @param key the key
     * @return the object
     */
    public Object lPoll(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     * Z add.
     *
     * @param key   the key
     * @param item  the item
     * @param score the score
     */
    public void zAdd(String key, Object item, double score) {
        redisTemplate.opsForZSet().add(key, item, score);
    }

    /**
     * Z size long.
     *
     * @param key the key
     * @return the long
     */
    public long zSize(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    /**
     * Z delete.
     *
     * @param key  the key
     * @param item the item
     */
    public void zDelete(String key, String item) {
        redisTemplate.opsForZSet().remove(key, item);
    }

    /**
     * Z index long.
     *
     * @param key  the key
     * @param item the item
     * @return the long
     */
    public long zIndex(String key, String item) {
        return redisTemplate.opsForZSet().rank(key, item);
    }

    /**
     * Z score double.
     *
     * @param key  the key
     * @param item the item
     * @return the double
     */
    public double zScore(String key, String item) {
        return redisTemplate.opsForZSet().score(key, item);
    }

    /**
     * Zcount long.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    public long zcount(String key, double min, double max) {
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    /**
     * Z range set.
     *
     * @param key   the key
     * @param begin the begin
     * @param end   the end
     * @return the set
     */
    public Set<Object> zRange(String key, long begin, long end) {
        return redisTemplate.opsForZSet().range(key, begin, end);
    }

    /**
     * Z range with score set.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the set
     */
    public Set<Object> zRangeWithScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * Setter method for property <tt>redisTemplate</tt>.
     *
     * @param redisTemplate value to be assigned to property redisTemplate
     */
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}