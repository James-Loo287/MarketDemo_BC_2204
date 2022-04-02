package com.example;

import com.example.impl.*;

import java.math.BigDecimal;

/**
 * @Description：水果工厂
 * @Author：James Loo
 * @Date：2022/3/27 22:30
 */
public class FruitFactory {
    private FruitFactory() {}

    public static Fruit get(String name) {
        Fruit fruit = null;
        if (name.equals("苹果")) {
            fruit =  new Fruit(name, new BigDecimal("8.00"));
        } else if (name.equals("草莓")) {
            fruit =  new Fruit(name, new BigDecimal("13.00"));
        } else if (name.equals("芒果")) {
            fruit =  new Fruit(name, new BigDecimal("20.00"));
        } else if (name.equals("香蕉")) {
            fruit =  new Fruit(name, new BigDecimal("5.00"));
        } else if (name.equals("橘子")) {
            fruit =  new Fruit(name, new BigDecimal("2.00"));
        }
        return fruit;
    }

}
