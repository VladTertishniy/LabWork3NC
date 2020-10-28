package edu.sumdu.labwork3.controller;

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

    private final SupplierService supplierService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllSuppliers() {
        List<Supplier> suppliersList = supplierService.getAll();
        return new ModelAndView("suppliersPages/suppliers", "suppliersList", suppliersList);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSupplier(@ModelAttribute("command") Supplier supplier) {
        supplierService.insert(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping(value = "addSupplier")
    public String addSupplier(Model model) {
        model.addAttribute("command", new Supplier());
        return "suppliersPages/addSupplier";
    }

    @RequestMapping(value="/deleteSupplier/{user_id}",method = RequestMethod.GET)
    public String delete(@PathVariable int user_id){
        supplierService.delete(user_id);
        return "redirect:/suppliers";
    }

    @RequestMapping(value="/editSupplier/{user_id}", method = RequestMethod.GET)
    public String editGoodsType(@PathVariable int user_id, Model model){
        Supplier supplier = supplierService.getById(user_id);
        model.addAttribute("command", supplier);
        return "suppliersPages/editSupplier";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") Supplier supplier){
        supplierService.update(supplier);
        return "redirect:/suppliers";
    }
}
