package com.lantaiyuan.carpool.common.common.dao;


import com.lantaiyuan.carpool.common.common.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/8$ 10:33$
 * @description:
 */

public interface UserRepository extends CrudRepository<User, String> {

}
