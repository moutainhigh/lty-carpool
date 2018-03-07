package com.lantaiyuan.carpool.common.service;

import com.lantaiyuan.carpool.common.domain.response.Line4User;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/5$ 16:45$
 * @description:
 */
public interface ILineService {
    /**
     * 根据订单id返回客户端所需线路信息
     * @param lineId
     * @return 客户端所需线路信息
     */
    Line4User lineId2Line4User(long lineId);
}
