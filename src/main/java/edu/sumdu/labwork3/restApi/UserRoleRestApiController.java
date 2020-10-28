package edu.sumdu.labwork3.restApi;

import edu.sumdu.labwork3.model.UserRole;
import edu.sumdu.labwork3.service.UserRoleService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleRestApiController {

    private final UserRoleService userRoleService;
    final static Logger logger = Logger.getLogger(UserRestApiController.class);

    public UserRoleRestApiController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public UserRole update(@RequestBody UserRole userRole) {
        return userRoleService.update(userRole);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        userRoleService.delete(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public UserRole createUser(@RequestBody UserRole userRole) {
        return userRoleService.insert(userRole);
    }

    @RequestMapping(value = "/getByUsername/{username}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<UserRole> getByUserName(@PathVariable String username) {
        return userRoleService.getByUsername(username);
    }

    @RequestMapping(value = "/getByRoleName/{roleName}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<UserRole> getByRoleName(@PathVariable String roleName) {
        return userRoleService.getByRoleName(roleName);
    }

    @RequestMapping(value = "/getByUserId/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<UserRole> getByUserId(@PathVariable int userId) {
        return userRoleService.getByUserId(userId);
    }

    @RequestMapping(value = "/getByRoleId/{roleId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<UserRole> getByRoleId(@PathVariable int roleId) {
        return userRoleService.getByRoleId(roleId);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public UserRole getById(@PathVariable int id) {
        return userRoleService.getById(id);
    }
}
