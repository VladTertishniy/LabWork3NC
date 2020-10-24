package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.Order;

import java.util.List;

public interface DaoOrder {

    Order insert(Order order);
    Order update(Order order);
    void delete(int id);
    List<Order> findAll();
    Order getById(int id);

}
