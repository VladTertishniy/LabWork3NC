package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.User;

import java.util.List;

public interface UserService {
    User insert(User user);
    List<User> getAll();
    User update(User user);
    User delete(User user);
    User getById(int id);
    User getByUsername(String username);
}
