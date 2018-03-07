package com.lantaiyuan.carpool.common.constant;

import lombok.Data;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/2$ 10:48$
 * @description: redis缓存池的hash操作绑定的字符串
 */
public class RedisPoolKey {
    /**
     * redis线路信息缓存池的hash操作绑定的字符串
     */
    public final static String linePoolKey="car_pool_line";
    /**
     * redis用户信息缓存池的hash操作绑定的字符串
     */
    public final static String userPoolKey="car_pool_user";
    /**
     * redis行程信息缓存池的hash操作绑定的字符串
     */
    public final static String tourPoolKey="car_pool_tour";
    /**
     * redis订单信息缓存池的hash操作绑定的字符串
     */
    public final static String orderPoolKey="car_pool_order";
}
