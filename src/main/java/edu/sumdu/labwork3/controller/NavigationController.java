package edu.sumdu.labwork3.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "")
public class NavigationController {

    final static Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/navigate/admin")
    public String navigateAdmin() {
        logger.info("Request to get admin navigation pages");
        return "navigationPages/adminNavigate";
    }

    @RequestMapping(value = "/navigate/supplier")
    public String navigateSupplier() {
        logger.info("Request to get supplier navigation pages");
        return "navigationPages/supplierNavigate";
    }

    @RequestMapping(value = "/navigate/consumer")
    public String navigateConsumer() {
        logger.info("Request to get consumer navigation pages");
        return "navigationPages/consumerNavigate";
    }
}
