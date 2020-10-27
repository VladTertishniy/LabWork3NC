package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoRole;
import edu.sumdu.labwork3.model.Role;
import edu.sumdu.labwork3.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final DaoRole daoRole;

    public RoleServiceImpl(DaoRole daoRole) {
        this.daoRole = daoRole;
    }

    @Override
    public Role getById(int id) {
        return daoRole.getById(id);
    }

    @Override
    public Role insert(Role role) {
        return daoRole.insert(role);
    }

    @Override
    public void delete(int id) {
        daoRole.delete(id);
    }

    @Override
    public Role update(Role role) {
        return daoRole.update(role);
    }

    @Override
    public List<Role> getAll() {
        return daoRole.getAll();
    }
}
