package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoUser;
import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final DaoUser daoUser;

    public UserServiceImpl(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    public void insert(User user) {
        daoUser.insert(user);
    }

    @Override
    public List<User> getAll() {
        return daoUser.findAll();
    }

    @Override
    public void update(User user) {
        daoUser.update(user);
    }

    @Override
    public void delete(User user) {
        daoUser.delete(user);
    }

    @Override
    public User getById(int id) {
        return daoUser.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return daoUser.getByUserName(username);
    }
}
