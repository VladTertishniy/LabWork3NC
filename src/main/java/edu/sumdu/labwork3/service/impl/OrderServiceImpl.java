package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoOrder;
import edu.sumdu.labwork3.model.Order;
import edu.sumdu.labwork3.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final DaoOrder daoOrder;

    public OrderServiceImpl(DaoOrder daoOrder) {
        this.daoOrder = daoOrder;
    }

    @Override
    public void insert(Order order) {
        daoOrder.insert(order);
    }

    @Override
    public List<Order> getAll() {
        return daoOrder.findAll();
    }

    @Override
    public void update(Order order) {
        daoOrder.update(order);
    }

    @Override
    public void delete(Order order) {
        daoOrder.delete(order);
    }

    @Override
    public Order getById(int id) {
        return daoOrder.getById(id);
    }
}