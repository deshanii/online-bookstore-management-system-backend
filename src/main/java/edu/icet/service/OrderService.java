package edu.icet.service;

import edu.icet.dto.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAll();
    void addOrder(Orders order);
    void deleteOrderById(Integer id);
    Orders searchOrderById(Integer id);
    void updateOrderById(Orders order);

}
