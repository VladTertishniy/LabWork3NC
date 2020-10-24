package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.User;

import java.util.List;

public interface UserService {
    User insert(User user);
    List<User> getAll();
    User update(User user);
    void delete(int id);
    User getById(int id);
    User getByUsername(String username);
}
