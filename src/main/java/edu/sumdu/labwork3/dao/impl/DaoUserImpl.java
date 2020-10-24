package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoUser;
import edu.sumdu.labwork3.mapper.UserMapper;
import edu.sumdu.labwork3.model.User;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@Repository
public class DaoUserImpl implements DaoUser {

    private final JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    final static Logger logger = Logger.getLogger(DaoUserImpl.class);

    public DaoUserImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User insert(User user) {
        String query = "INSERT INTO \"user\" (username, password) VALUES (?, ?)";


        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                query,
                Types.VARCHAR, Types.VARCHAR
        );

// By default, returnGeneratedKeys = false so change it to true
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc =
                preparedStatementCreatorFactory.newPreparedStatementCreator(
                        Arrays.asList(
                                user.getUsername(),
                                user.getPassword()));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                psc,
                keyHolder
        );
        user.setUser_id((int) keyHolder.getKeys().get("id"));
        return user;
    }

    @Override
    public User update(User user) {
        String query = "UPDATE \"user\" SET username = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getUsername(), user.getPassword(), user.getUser_id());
        return user;
    }

    @Override
    public User delete(User user) {
        String query = "DELETE FROM \"user\" WHERE id = ? ";
        jdbcTemplate.update(query, user.getUser_id());
        return user;
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

    @Override
    public User getByUserName(String username) {
        String query = "SELECT * FROM \"user\" WHERE username = ?";
        List<User> userList = jdbcTemplate.query(query, new UserMapper(), username);
        List<User> users = new ArrayList<>(userList);
        return users.get(0);
    }
}
