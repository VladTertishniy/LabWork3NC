package edu.sumdu.labwork3.restApi;

import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestApiController {
    private final UserService userService;
    final static Logger logger = Logger.getLogger(UserRestApiController.class);

    public UserRestApiController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/getByUsername/{username}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public User getByUserName(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public User createUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
