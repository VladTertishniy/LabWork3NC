package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.Order;

import java.util.List;

public interface DaoOrder {

    void insert(Order order);
    void update(Order order);
    void delete(Order order);
    List<Order> findAll();
    Order getById(int id);

}
