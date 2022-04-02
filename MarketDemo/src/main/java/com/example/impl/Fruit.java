package com.example.impl;

import com.example.FruitFunction;
import com.example.Salesman;

import java.math.BigDecimal;

/**
 * @Description：具体策略父类：水果
 * @Author：James Loo
 * @Date：2022/3/27 22:11
 */
public class Fruit implements FruitFunction {
    private String name; // 名称
    private BigDecimal price; // 单价
    private BigDecimal quantity; // 购买数量
    private BigDecimal discount; // 打折折扣
    private String endDateTime; // 促销活动截止日期

    public Fruit(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * 获取购买某种水果的金额
     * @return 金额
     */
    @Override
    public BigDecimal getAmount() {
        BigDecimal amount;
        if (null != discount) {
            // 限时打折，需判断促销活动是否过期
            if (Salesman.isOverdue(endDateTime)) {
                discount = new BigDecimal("1");
                System.out.println("促销活动已结束，" + name + "已恢复原价");
            } else {
                System.out.println("促销活动进行中，" + name + "限时打" + discount.multiply(new BigDecimal("10")) + "折");
            }
            amount = price.multiply(quantity).multiply(discount);
        } else {
            amount = price.multiply(quantity);
        }
        System.out.println("购买" + name + "需要：" + amount + "元");
        return amount;
    }

}
