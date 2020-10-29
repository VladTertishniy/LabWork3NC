package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.controller.OrderController;
import edu.sumdu.labwork3.dao.DaoOrder;
import edu.sumdu.labwork3.details.UserDetailsImpl;
import edu.sumdu.labwork3.model.*;
import edu.sumdu.labwork3.service.ConsumerService;
import edu.sumdu.labwork3.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderServiceImpl implements OrderService {

    private final DaoOrder daoOrder;
    private final ConsumerService consumerService;
    final static Logger logger = Logger.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl(DaoOrder daoOrder, ConsumerService consumerService) {
        this.daoOrder = daoOrder;
        this.consumerService = consumerService;
    }

    @Override
    public Order insert(Order order) {
        return daoOrder.insert(order);
    }

    @Override
    public List<Order> getAll() {
        return daoOrder.findAll();
    }

    @Override
    public Order update(Order order) {
        return daoOrder.update(order);
    }

    @Override
    public void delete(int id) {
        daoOrder.delete(id);
    }

    @Override
    public Order getById(int id) {
        return daoOrder.getById(id);
    }

    @Override
    public Order preparedOrder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        User user = userDetails.getUser();
        Consumer consumer = consumerService.getById(user.getUser_id());
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setConsumer(consumer);
        int randomNum = ThreadLocalRandom.current().nextInt(1234, 99999);
        order.setNumber(randomNum);
        return insert(order);
    }
}
