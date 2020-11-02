package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.model.Role;
import edu.sumdu.labwork3.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping()
    public ModelAndView showAllRoles() {
        List<Role> rolesList = roleService.getAll();
        return new ModelAndView("rolesPages/roles", "rolesList", rolesList);
    }

    @RequestMapping(value="/editRole/{id}", method = RequestMethod.GET)
    public String editRole(@PathVariable int id, Model model){
        Role role = roleService.getById(id);
        model.addAttribute("command", role);
        return "rolesPages/editRole";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") Role role){
        roleService.update(role);
        return "redirect:/roles";
    }

    @RequestMapping(value="/deleteRole/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        roleService.delete(id);
        return "redirect:/roles";
    }

    @GetMapping(value = "addRole")
    public String addRole(Model model) {
        model.addAttribute("command", new Role());
        return "rolesPages/addRole";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createRole(@ModelAttribute("command") Role role) {
        roleService.insert(role);
        return "redirect:/roles";
    }
}
