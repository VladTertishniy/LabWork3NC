package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoUserRole;
import edu.sumdu.labwork3.model.UserRole;
import edu.sumdu.labwork3.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final DaoUserRole daoUserRole;

    public UserRoleServiceImpl(DaoUserRole daoUserRole) {
        this.daoUserRole = daoUserRole;
    }

    @Override
    public UserRole getById(int id) {
        return daoUserRole.getById(id);
    }

    @Override
    public List<UserRole> getByUserId(int id) {
        return daoUserRole.getByUserId(id);
    }

    @Override
    public List<UserRole> getByUsername(String username) {
        return daoUserRole.getByUsername(username);
    }

    @Override
    public List<UserRole> getByRoleId(int id) {
        return daoUserRole.getByRoleId(id);
    }

    @Override
    public List<UserRole> getByRoleName(String roleName) {
        return daoUserRole.getByRoleName(roleName);
    }

    @Override
    public UserRole insert(UserRole userRole) {
        return daoUserRole.insert(userRole);
    }

    @Override
    public void delete(int id) {
        daoUserRole.delete(id);
    }

    @Override
    public UserRole update(UserRole userRole) {
        return daoUserRole.update(userRole);
    }

    @Override
    public List<UserRole> getAll() {
        return daoUserRole.getAll();
    }
}
