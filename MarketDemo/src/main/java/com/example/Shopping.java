package com.example;

import com.example.impl.Fruit;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description：计算顾客购买商品的总价
 * @Author：James Loo
 * @Date：2022/3/27 23:30
 */
public class Shopping {

    public static void main(String[] args) throws IOException {
        BigDecimal appleAmount = new BigDecimal("0");
        BigDecimal strawberryAmount = new BigDecimal("0");
        BigDecimal mongoAmount = new BigDecimal("0");
        BigDecimal bananaAmount = new BigDecimal("0");
        BigDecimal orangeAmount = new BigDecimal("0");
        BigDecimal amount;
        String endDateTime = "2022-04-27 08:25:12"; // 促销活动截止日期

        //顾客购买的水果
        Fruit apple = FruitFactory.get("苹果");
        Fruit strawberry = FruitFactory.get("草莓");
        Fruit mongo = FruitFactory.get("芒果");
        Fruit banana = FruitFactory.get("香蕉");
        Fruit orange = FruitFactory.get("橘子");

        // 顾客购买的水果斤数，可自行确定
        apple.setQuantity(new BigDecimal("1"));
        strawberry.setQuantity(new BigDecimal("2"));
        strawberry.setDiscount(new BigDecimal("0.8"));
        strawberry.setEndDateTime(endDateTime);
        mongo.setQuantity(new BigDecimal("3"));
        banana.setQuantity(new BigDecimal("4"));
        orange.setQuantity(new BigDecimal("5"));

        Salesman salesman = new Salesman(apple); // 使用构造函数默认顾客选择购买苹果
        appleAmount = salesman.getAmount();

        salesman.setFruit(strawberry); // 使用set方法切换到购买草莓
        strawberryAmount = salesman.getAmount();

        salesman.setFruit(mongo); // 使用set方法切换到购买芒果
        mongoAmount = salesman.getAmount();

        salesman.setFruit(banana); // 使用set方法切换到购买香蕉
        bananaAmount = salesman.getAmount();

        salesman.setFruit(orange); // 使用set方法切换到购买橘子
        orangeAmount = salesman.getAmount();

        amount = appleAmount.add(strawberryAmount).add(mongoAmount).add(bananaAmount).add(orangeAmount);

        // 计算总价
        salesman.getTotalAmount(amount, endDateTime);
    }

}
