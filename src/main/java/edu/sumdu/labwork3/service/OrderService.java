package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Order;

import java.util.List;

public interface OrderService {
    Order insert(Order order);
    List<Order> getAll();
    Order update(Order order);
    void delete(int id);
    Order getById(int id);
}
