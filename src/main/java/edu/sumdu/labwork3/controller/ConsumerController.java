package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.model.Consumer;
import edu.sumdu.labwork3.service.ConsumerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consumers")
public class ConsumerController {

    private final ConsumerService consumerService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @RequestMapping()
    public String showAllConsumers() {
        logger.info(consumerService.getAll().toString());
        Consumer consumer = consumerService.getById(4);
        logger.info(consumerService.getById(4).toString());
        consumer.setPhoneNumber("678594");
        consumerService.update(consumer);
        return "consumers";
    }
}
