package com.lantaiyuan.carpool.common.dao;

import com.lantaiyuan.carpool.common.domain.Bus;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 16:01$
 * @description:jpa接口
 */

public interface BusRepository extends CrudRepository<Bus, String> {
}
