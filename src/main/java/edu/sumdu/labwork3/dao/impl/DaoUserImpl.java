package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoUser;
import edu.sumdu.labwork3.mapper.UserMapper;
import edu.sumdu.labwork3.model.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoUserImpl implements DaoUser {

    private final JdbcTemplate jdbcTemplate;
    final static Logger logger = Logger.getLogger(DaoUserImpl.class);

    public DaoUserImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(User user) {
        String query = "INSERT INTO \"user\" (username, password) VALUES (?, ?)";
        jdbcTemplate.update(query, user.getUsername(), user.getPassword());
    }

    @Override
    public void update(User user) {
        String query = "UPDATE \"user\" SET username = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getUsername(), user.getPassword(), user.getUser_id());
    }

    @Override
    public void delete(User user) {
        String query = "DELETE FROM \"user\" WHERE id = ? ";
        jdbcTemplate.update(query, user.getUser_id());
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM \"user\"";
        List<User> userList = jdbcTemplate.query(query, new UserMapper());
        return new ArrayList<>(userList);
    }

    @Override
    public User getById(int id) {
        String query = "SELECT * FROM \"user\" WHERE id = ?";
        List<User> userList = jdbcTemplate.query(query, new UserMapper(), id);
        List<User> users = new ArrayList<>(userList);
        return users.get(0);
    }
}
