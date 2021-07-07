package top.mca.eurekaconsumerproduct.service;

import top.mca.eurekaconsumerproduct.pojo.Order;

public interface OrderService {

    Order selectOrderById(Integer id);
}
