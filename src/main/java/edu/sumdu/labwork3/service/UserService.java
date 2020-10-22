package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.User;

import java.util.List;

public interface UserService {
    void insert(User user);
    List<User> getAll();
    void update(User user);
    void delete(User user);
    User getById(int id);
    User getByUsername(String username);
}
