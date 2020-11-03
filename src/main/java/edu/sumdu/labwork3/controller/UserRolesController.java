package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.IAuthenticationFacade;
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

    private final IAuthenticationFacade authenticationFacade;
    private final UserRoleService userRoleService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public UserRolesController(IAuthenticationFacade authenticationFacade, UserRoleService userRoleService) {
        this.authenticationFacade = authenticationFacade;
        this.userRoleService = userRoleService;
    }

    @RequestMapping()
    public ModelAndView getAll() {
        logger.info("Request to receive all user roles by " + authenticationFacade.getAuthentication().getName());
        List<UserRole> userRoleList = userRoleService.getAll();
        return new ModelAndView("userRolesPages/userRoles", "userRoleList", userRoleList);
    }

    @RequestMapping(value="/editUserRoles/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model){
        logger.info("Request to edit user role with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        UserRole userRole = userRoleService.getById(id);
        model.addAttribute("command", userRole);
        return "userRolesPages/editUserRoles";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") UserRole userRole){
        logger.info("Request to save altered user role: " + userRole.toString() + " by " + authenticationFacade.getAuthentication().getName());
        userRoleService.update(userRole);
        return "redirect:/userRoles";
    }

    @RequestMapping(value="/deleteUserRoles/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        logger.info("Request to delete user role with id: " + id + " by " + authenticationFacade.getAuthentication().getName());
        userRoleService.delete(id);
        return "redirect:/userRoles";
    }

    @GetMapping(value = "addUserRoles")
    public String addUserRoles(Model model) {
        logger.info("Request to create new user role by " + authenticationFacade.getAuthentication().getName());
        model.addAttribute("command", new UserRole());
        return "userRolesPages/addUserRoles";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String insert(@ModelAttribute("command") UserRole userRole) {
        logger.info("Request to save created user role: " + userRole.toString() + " by " + authenticationFacade.getAuthentication().getName());
        userRoleService.insert(userRole);
        return "redirect:/userRoles";
    }
}
