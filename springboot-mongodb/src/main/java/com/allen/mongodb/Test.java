package com.allen.mongodb;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;

/**
 * @author allen
 * @date 2022/9/14 15:19
 */
public class Test {

    public static void main(String[] args) {
        // 当前时间
        DateTime date = DateUtil.date();
        // 当前使劲按
        DateTime date1 = DateUtil.date(Calendar.getInstance());
        // 当前时间
        DateTime date2 = DateUtil.date(System.currentTimeMillis());
        // 当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        // 当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();

        System.out.println("date: " + date);
        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
        System.out.println("now: " + now);
        System.out.println("today: " + today);


    }
}
