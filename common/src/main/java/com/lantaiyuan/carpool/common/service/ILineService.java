package com.lantaiyuan.carpool.common.service;

import com.lantaiyuan.carpool.common.domain.response.Line4User;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/5$ 16:45$
 * @description:
 */
public interface ILineService {
    Line4User lineId2Line4User(Long lineId);
}
