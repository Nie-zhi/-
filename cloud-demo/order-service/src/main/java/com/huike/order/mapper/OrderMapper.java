package com.huike.order.mapper;

import com.huike.order.pojo.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
