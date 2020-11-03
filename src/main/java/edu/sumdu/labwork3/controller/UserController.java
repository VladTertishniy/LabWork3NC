package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.IAuthenticationFacade;
import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final IAuthenticationFacade authenticationFacade;
    private final UserService userService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public UserController(IAuthenticationFacade authenticationFacade, UserService userService) {
        this.authenticationFacade = authenticationFacade;
        this.userService = userService;
    }

    @RequestMapping()
    public ModelAndView getAll() {
        logger.info("Request to receive all users by " + authenticationFacade.getAuthentication().getName());
        List<User> usersList = userService.getAll();
        return new ModelAndView("usersPages/users", "usersList", usersList);
    }

    @RequestMapping(value="/editUser/{user_id}", method = RequestMethod.GET)
    public String edit(@PathVariable int user_id, Model model){
        logger.info("Request to edit user with id: " + user_id + " by " + authenticationFacade.getAuthentication().getName());
        User user = userService.getById(user_id);
        model.addAttribute("command", user);
        return "usersPages/editUser";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") User user){
        logger.info("Request to save altered user: " + user.toString() + " by " + authenticationFacade.getAuthentication().getName());
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        userService.update(user);
        return "redirect:/users";
    }

    @RequestMapping(value="/deleteUser/{user_id}",method = RequestMethod.GET)
    public String delete(@PathVariable int user_id){
        logger.info("Request to delete user with id: " + user_id + " by " + authenticationFacade.getAuthentication().getName());
        userService.delete(user_id);
        return "redirect:/users";
    }

    @GetMapping(value = "addUser")
    public String addUser(Model model) {
        logger.info("Request to create new user by " + authenticationFacade.getAuthentication().getName());
        model.addAttribute("command", new User());
        return "usersPages/addUser";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String insert(@ModelAttribute("command") User user) {
        logger.info("Request to save created user: " + user.toString() + " by " + authenticationFacade.getAuthentication().getName());
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        userService.insert(user);
        return "redirect:/users";
    }
}
