package com.allen.redis;

import cn.hutool.json.JSONUtil;
import com.allen.redis.entity.Food;
import com.allen.redis.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author allen
 * @date 2022/9/16 11:09
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    private static Food food1;
    private static Food food2;
    private static Food food3;

    static {
        //Food food1 = new Food(1L, "香蕉", "yellow");
        //Food food2 = new Food(2L, "苹果", "red");
        //Food food3 = new Food(3L, "橘子", "orange");
        food1 = Food.builder().id(1L).name("香蕉").color("yellow").build();
        food2 = Food.builder().id(2L).name("苹果").color("red").build();
        food3 = Food.builder().id(3L).name("橘子").color("orange").build();
    }

    @Test
    public void set() {
        // todo 暂时存储 str
        redisUtil.set("food:1", JSONUtil.toJsonStr(food1));
        redisUtil.set("food:2", JSONUtil.toJsonStr(food2));
        redisUtil.set("food:3", JSONUtil.toJsonStr(food3));
    }
}
