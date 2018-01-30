package com.lantaiyuan.carpool.common.dao;

import com.lantaiyuan.carpool.common.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 16:03$
 * @description:
 */

public interface OrderRepository extends CrudRepository<Order, Long> {
}
