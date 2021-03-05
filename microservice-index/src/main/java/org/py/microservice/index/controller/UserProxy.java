package org.py.microservice.index.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author cqpythagoras
 */
@FeignClient("MICROSERVICE-USER")
public interface UserProxy {
    /**
     * 返回测试调用信息
     * @param id 用户ID
     * @return 用户信息
     * */
    @GetMapping({"/user/{id}"})
    String hello(@PathVariable(required = false, value = "id") Long id);

    /**
     * 用户订单调用
     * @return 用户订单信息
     * */
    @GetMapping({"/user/order"})
    public String order();
}
