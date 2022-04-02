package com.example;

import java.math.BigDecimal;

/**
 * @Description：抽象策略类：水果功能公共接口
 * @Author：James Loo
 * @Date：2022/3/27 22:08
 */
public interface FruitFunction {
    /**
     * 获取购买某种水果的金额
     * @return 金额
     */
    public BigDecimal getAmount(); // 每种水果可以有不同的计价方法
}
