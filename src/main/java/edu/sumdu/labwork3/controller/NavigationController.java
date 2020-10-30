package edu.sumdu.labwork3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "")
public class NavigationController {

    @RequestMapping(value = "/navigate/admin")
    public String navigateAdmin() {
        return "navigationPages/adminNavigate";
    }

    @RequestMapping(value = "/navigate/supplier")
    public String navigateSupplier() {
        return "navigationPages/supplierNavigate";
    }

    @RequestMapping(value = "/navigate/consumer")
    public String navigateConsumer() {
        return "navigationPages/consumerNavigate";
    }
}