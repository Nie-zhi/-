package com.huike.order.service;

import com.huike.order.mapper.OrderMapper;
import com.huike.order.pojo.Order;
import com.huike.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // TODO: 2.查询用户
        String url = "http://localhost:8083/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user信息
        order.setUser(user);
        // 4.返回
        return order;
    }
}
