package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.UserRole;

import java.util.List;

public interface DaoUserRole {
    UserRole getById(int id);
    List<UserRole> getByUserId(int id);
    List<UserRole> getByUsername(String username);
    List<UserRole> getByRoleId(int id);
    List<UserRole> getByRoleName(String roleName);
    UserRole insert(UserRole userRole);
    void delete(int id);
    UserRole update(UserRole userRole);
    List<UserRole> getAll();
}
