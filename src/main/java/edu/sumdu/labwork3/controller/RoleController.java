package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.IAuthenticationFacade;
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

    private final IAuthenticationFacade authenticationFacade;
    private final RoleService roleService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public RoleController(IAuthenticationFacade authenticationFacade, RoleService roleService) {
        this.authenticationFacade = authenticationFacade;
        this.roleService = roleService;
    }

    @RequestMapping()
    public ModelAndView showAllRoles() {
        logger.info("Request to receive all roles by " + authenticationFacade.getAuthentication().getName());
        List<Role> rolesList = roleService.getAll();
        return new ModelAndView("rolesPages/roles", "rolesList", rolesList);
    }

    @RequestMapping(value="/editRole/{id}", method = RequestMethod.GET)
    public String editRole(@PathVariable int id, Model model){
        logger.info("Request to edit role with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        Role role = roleService.getById(id);
        model.addAttribute("command", role);
        return "rolesPages/editRole";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") Role role){
        logger.info("Request to save altered role: " + role.toString() + " by " + authenticationFacade.getAuthentication().getName());
        roleService.update(role);
        return "redirect:/roles";
    }

    @RequestMapping(value="/deleteRole/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        logger.info("Request to delete role with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        roleService.delete(id);
        return "redirect:/roles";
    }

    @GetMapping(value = "addRole")
    public String addRole(Model model) {
        logger.info("Request to create new role by " + authenticationFacade.getAuthentication().getName());
        model.addAttribute("command", new Role());
        return "rolesPages/addRole";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createRole(@ModelAttribute("command") Role role) {
        logger.info("Request to save created role: " + role.toString() + " by " + authenticationFacade.getAuthentication().getName());
        roleService.insert(role);
        return "redirect:/roles";
    }
}
