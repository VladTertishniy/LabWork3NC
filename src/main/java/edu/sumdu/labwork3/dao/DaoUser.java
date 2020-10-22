package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.User;

import java.util.List;

public interface DaoUser {
    void insert(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    User getById(int id);
    User getByUserName(String username);
}
