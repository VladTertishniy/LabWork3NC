package edu.sumdu.labwork3.controller;


import edu.sumdu.labwork3.model.Order;
import edu.sumdu.labwork3.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    final static Logger logger = Logger.getLogger(OrderController.class);

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping()
    public ModelAndView getAll() {
        List<Order> ordersList = orderService.getAll();
        return new ModelAndView("orderPages/orders", "ordersList", ordersList);
    }

    @RequestMapping(value="/deleteOrder/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        orderService.delete(id);
        return "redirect:/orders";
    }

    @GetMapping(value = "addOrder")
    public String addOrder(Model model) {
        model.addAttribute("command", orderService.preparedOrder());
        return "orderPages/addOrder";
    }

    @GetMapping(value = "redirect")
    public String redirect() {
        return "redirect:/orders";
    }

}
