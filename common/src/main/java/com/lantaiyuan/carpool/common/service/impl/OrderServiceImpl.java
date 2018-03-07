package com.lantaiyuan.carpool.common.service.impl;

import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.service.IOrderService;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/5$ 10:20$
 * @description: 订单相关服务
 */
@Service
public class OrderServiceImpl implements IOrderService {
    /**
     * 求两个订单的相似度
     * @param order0
     * @param order1
     * @return 相似度的值
     */
    @Override
    public double similarity(Order order0, Order order1) {
        /**
         * 从订单中提取起始点，终点
         */
        Point startPoint0=new Point(order0.getStartLongitude(),order0.getStartLatitude());
        Point endPoint0=new Point(order0.getEndLongitude(),order0.getEndLatitude());
        Point startPoint1=new Point(order1.getStartLongitude(),order1.getStartLatitude());
        Point endPoint1=new Point(order1.getEndLongitude(),order1.getEndLatitude());
        //求订单0的斜率
        double slope0 = getSlope(startPoint0,endPoint0);
        //求订单1的斜率
        double slope1=getSlope(startPoint1,endPoint1);
        //求弧度tan值，正负无穷
        double tanA=(slope1-slope0)/(1+slope1*slope0);
        //求弧度值,0到pi*100 TODO相似度计算不完整
        return Math.atan(tanA)*100;
    }

    /**
     * 求直线斜率
     * @param point0
     * @param point1
     * @return 斜率值
     */
     double getSlope(Point point0,Point point1){
        if(point1.getX()==point0.getX()){
            return Double.MAX_VALUE;
        }else {
            return (point1.getY()-point0.getY())/(point1.getX()-point0.getX());
        }
    }
}
