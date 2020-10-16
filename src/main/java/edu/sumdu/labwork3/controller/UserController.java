package edu.sumdu.labwork3.controller;

import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    final static Logger logger = Logger.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping()
    public String showAllUsers() {
        userService.getAll();
        return "users";
    }
    @RequestMapping("/create")
    public String createUser() {
//        User user = new User();
//        user.setUser_id(2);
//        user.setUsername("4444");
//        user.setPassword("4444");
        userService.getAll();
        User user2 = userService.getById(1);
//        userService.delete(user);
        logger.info(user2.toString());
        userService.delete(user2);
        return "users";
    }
}