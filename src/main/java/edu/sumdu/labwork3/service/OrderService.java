package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Order;

import java.util.List;

public interface OrderService {
    void insert(Order order);
    List<Order> getAll();
    void update(Order order);
    void delete(Order order);
    Order getById(int id);
}
