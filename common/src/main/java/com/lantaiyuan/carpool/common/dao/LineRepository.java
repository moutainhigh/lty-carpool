package com.lantaiyuan.carpool.common.dao;


import com.lantaiyuan.carpool.common.domain.Line;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 16:02$
 * @description:jpa接口
 */

public interface LineRepository extends CrudRepository<Line, Long> {
}
