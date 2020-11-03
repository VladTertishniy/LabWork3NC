package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.IAuthenticationFacade;
import edu.sumdu.labwork3.model.Supplier;
import edu.sumdu.labwork3.service.SupplierService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private final IAuthenticationFacade authenticationFacade;
    private final SupplierService supplierService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public SupplierController(IAuthenticationFacade authenticationFacade, SupplierService supplierService) {
        this.authenticationFacade = authenticationFacade;
        this.supplierService = supplierService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllSuppliers() {
        logger.info("Request to receive all suppliers by " + authenticationFacade.getAuthentication().getName());
        List<Supplier> suppliersList = supplierService.getAll();
        return new ModelAndView("suppliersPages/suppliers", "suppliersList", suppliersList);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSupplier(@ModelAttribute("command") Supplier supplier) {
        logger.info("Request to save created supplier: " + supplier.toString() + " by " + authenticationFacade.getAuthentication().getName());
        supplierService.insert(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping(value = "addSupplier")
    public String addSupplier(Model model) {
        logger.info("Request to create new supplier by " + authenticationFacade.getAuthentication().getName());
        model.addAttribute("command", new Supplier());
        return "suppliersPages/addSupplier";
    }

    @RequestMapping(value="/deleteSupplier/{user_id}",method = RequestMethod.GET)
    public String delete(@PathVariable int user_id){
        logger.info("Request to delete supplier with userId: " + user_id + " by " + authenticationFacade.getAuthentication().getName());
        supplierService.delete(user_id);
        return "redirect:/suppliers";
    }

    @RequestMapping(value="/editSupplier/{user_id}", method = RequestMethod.GET)
    public String editSupplier(@PathVariable int user_id, Model model){
        logger.info("Request to edit supplier with userId: " + user_id + " by " + authenticationFacade.getAuthentication().getName());
        Supplier supplier = supplierService.getById(user_id);
        model.addAttribute("command", supplier);
        return "suppliersPages/editSupplier";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") Supplier supplier){
        logger.info("Request to save altered supplier: " + supplier.toString() + " by " + authenticationFacade.getAuthentication().getName());
        supplierService.update(supplier);
        return "redirect:/suppliers";
    }
}
