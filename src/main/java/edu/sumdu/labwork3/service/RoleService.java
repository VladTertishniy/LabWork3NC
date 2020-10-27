package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Role;

import java.util.List;

public interface RoleService {
    Role getById(int id);
    Role insert(Role role);
    void delete(int id);
    Role update(Role role);
    List<Role> getAll();
}
