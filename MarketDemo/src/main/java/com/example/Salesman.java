package com.example;

import com.example.impl.Fruit;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Description：售货员，应用场景类
 * @Author：James Loo
 * @Date：2022/3/27 23:06
 */
public class Salesman {

    private Fruit fruit; // 顾客待计算价钱的水果

    public Salesman(Fruit fruit) {
        super();
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    /**
     * 计算顾客购买某种水果的所需金额
     * @return 金额
     */
    public BigDecimal getAmount() {
        return fruit.getAmount();
    }

    /**
     * 判断促销活动是否已过期
     * @param datetime 促销活动截止日期
     * @return true or false
     */
    public static boolean isOverdue(String datetime) {
        Instant nowTimestamp = Instant.now();  // 获取当前时间戳，统一使用世界标准时间（即0时区时间）进行处理
        LocalDateTime endDateTime = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 促销活动截止时间，为本时区的时间，需要转换
        Instant endTimestamp = endDateTime.toInstant(ZoneOffset.of("+08:00")); // 在把LocalDateTime转换为Instant时，需要明确指定当前这个时间指的是哪个时区的时间
        if (nowTimestamp.compareTo(endTimestamp) > -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算购买水果的总价
     * @param origAmount 购买水果的原始合计金额
     * @param datetime 促销活动截止日期
     * @return 总计金额
     */
    public static BigDecimal getTotalAmount(BigDecimal origAmount, String datetime) {
        BigDecimal amount = origAmount;
        // 限时满减，需判断促销活动是否过期
        if (!Salesman.isOverdue(datetime)) {
            System.out.println("促销活动进行中，购物满 50 可以减 5 块，满 100 可以减 10 块，满 200 可以减 30 块哦！");
            amount = origAmount.compareTo(new BigDecimal("50")) > -1 ? origAmount.subtract(new BigDecimal("5")) : amount; // 购物满50减5块
            amount = origAmount.compareTo(new BigDecimal("100")) > -1 ? origAmount.subtract(new BigDecimal("10")) : amount; // 购物满100减10块
            amount = origAmount.compareTo(new BigDecimal("200")) > -1 ? origAmount.subtract(new BigDecimal("30")) : amount; // 购物满200减30块
        }
        System.out.println("购买所有商品的总价为：" + amount + "元");
        return amount;
    }

}
