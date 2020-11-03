package edu.sumdu.labwork3.controller;


import edu.sumdu.labwork3.IAuthenticationFacade;
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

    private final IAuthenticationFacade authenticationFacade;
    private final OrderService orderService;
    final static Logger logger = Logger.getLogger(OrderController.class);

    public OrderController(IAuthenticationFacade authenticationFacade, OrderService orderService) {
        this.authenticationFacade = authenticationFacade;
        this.orderService = orderService;
    }

    @RequestMapping()
    public ModelAndView getAll() {
        logger.info("Request to receive all orders by " + authenticationFacade.getAuthentication().getName());
        List<Order> ordersList = orderService.getAll();
        return new ModelAndView("orderPages/orders", "ordersList", ordersList);
    }

    @RequestMapping(value="/deleteOrder/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        logger.info("Request to delete order with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        orderService.delete(id);
        return "redirect:/orders";
    }

    @GetMapping(value = "addOrder")
    public String addOrder(Model model) {
        logger.info("Request to create new order by " + authenticationFacade.getAuthentication().getName());
        model.addAttribute("command", orderService.preparedOrder());
        return "orderPages/addOrder";
    }

    @GetMapping(value = "redirect")
    public String redirect() {
        logger.info("Redirecting into orders page after adding new order by " + authenticationFacade.getAuthentication().getName());
        return "redirect:/orders";
    }
}
