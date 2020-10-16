package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.service.SupplierService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping()
    public String showAllSuppliers() {
        supplierService.getAll();
        return "suppliers";
    }
}
