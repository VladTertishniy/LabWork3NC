package edu.sumdu.labwork3.restApi;

import edu.sumdu.labwork3.model.Goods;
import edu.sumdu.labwork3.model.Order;
import edu.sumdu.labwork3.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Order")
public class OrderRestApiController {
    private final OrderService orderService;
    final static Logger logger = Logger.getLogger(OrderRestApiController.class);

    public OrderRestApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Order getByOrderId(@PathVariable int id) {
        return orderService.getById(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Order createOrder(@RequestBody Order order) {
        return orderService.insert(order);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void removeOrder(@PathVariable int id) {
        orderService.delete(id);
    }
}
