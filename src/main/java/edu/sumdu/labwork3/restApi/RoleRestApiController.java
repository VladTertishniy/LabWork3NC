package edu.sumdu.labwork3.restApi;

import edu.sumdu.labwork3.model.Role;
import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestApiController {

    private final RoleService roleService;
    final static Logger logger = Logger.getLogger(UserRestApiController.class);

    public RoleRestApiController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Role update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        roleService.delete(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Role insert(@RequestBody Role role) {
        return roleService.insert(role);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Role getById(@PathVariable int id) {
        return roleService.getById(id);
    }
}
