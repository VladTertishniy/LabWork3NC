package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.model.UserRole;
import edu.sumdu.labwork3.service.UserRoleService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/userRoles")
public class UserRolesController {

    private final UserRoleService userRoleService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public UserRolesController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @RequestMapping()
    public ModelAndView getAll() {
        List<UserRole> userRoleList = userRoleService.getAll();
        return new ModelAndView("userRolesPages/userRoles", "userRoleList", userRoleList);
    }

    @RequestMapping(value="/editUserRoles/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model){
        UserRole userRole = userRoleService.getById(id);
        model.addAttribute("command", userRole);
        return "userRolesPages/editUserRoles";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") UserRole userRole){
        userRoleService.update(userRole);
        return "redirect:/userRoles";
    }

    @RequestMapping(value="/deleteUserRoles/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        userRoleService.delete(id);
        return "redirect:/userRoles";
    }

    @GetMapping(value = "addUserRoles")
    public String addUserRoles(Model model) {
        model.addAttribute("command", new UserRole());
        return "userRolesPages/addUserRoles";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String insert(@ModelAttribute("command") UserRole userRole) {
        userRoleService.insert(userRole);
        return "redirect:/userRoles";
    }
}
