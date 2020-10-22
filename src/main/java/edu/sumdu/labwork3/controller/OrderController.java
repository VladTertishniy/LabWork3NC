package edu.sumdu.labwork3.controller;


import edu.sumdu.labwork3.model.Consumer;
import edu.sumdu.labwork3.model.Order;
import edu.sumdu.labwork3.service.ConsumerService;
import edu.sumdu.labwork3.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ConsumerService consumerService;
    final static Logger logger = Logger.getLogger(OrderController.class);

    public OrderController(OrderService orderService, ConsumerService consumerService) {
        this.orderService = orderService;
        this.consumerService = consumerService;
    }

    @RequestMapping()
    public String showAllOrders() {
        orderService.getAll();
        return "orders";
    }

    @RequestMapping("/create")
    public String createOrder() {
        Consumer consumer = consumerService.getById(4);
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setNumber(2);
        order.setConsumer(consumer);
        orderService.insert(order);
        return "orders";
    }
}
