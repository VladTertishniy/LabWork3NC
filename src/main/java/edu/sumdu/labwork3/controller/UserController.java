package edu.sumdu.labwork3.controller;

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

    private final UserService userService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping()
    public ModelAndView getAll() {
        List<User> usersList = userService.getAll();
        return new ModelAndView("usersPages/users", "usersList", usersList);
    }

    @RequestMapping(value="/editUser/{user_id}", method = RequestMethod.GET)
    public String edit(@PathVariable int user_id, Model model){
        User user = userService.getById(user_id);
        model.addAttribute("command", user);
        return "usersPages/editUser";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("command") User user){
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        userService.update(user);
        return "redirect:/users";
    }

    @RequestMapping(value="/deleteUser/{user_id}",method = RequestMethod.GET)
    public String delete(@PathVariable int user_id){
        userService.delete(user_id);
        return "redirect:/users";
    }

    @GetMapping(value = "addUser")
    public String addUser(Model model) {
        model.addAttribute("command", new User());
        return "usersPages/addUser";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String insert(@ModelAttribute("command") User user) {
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        userService.insert(user);
        return "redirect:/users";
    }
}
