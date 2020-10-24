package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.User;

import java.util.List;

public interface DaoUser {
    User insert(User user);
    User update(User user);
    void delete(int id);
    List<User> findAll();
    User getById(int id);
    User getByUserName(String username);
}
