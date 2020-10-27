package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoUserRole;
import edu.sumdu.labwork3.mapper.UserRoleMapper;
import edu.sumdu.labwork3.model.UserRole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DaoUserRoleImpl implements DaoUserRole {

    private final JdbcTemplate jdbcTemplate;

    public DaoUserRoleImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserRole getById(int id) {
        String query =
                "select\n" +
                "       ur.id,\n" +
                "       u.id userId,\n" +
                "       u.username username,\n" +
                "       u.password \"password\",\n" +
                "       r.id roleId,\n" +
                "       r.name roleName\n" +
                "from user_role ur\n" +
                "left join \"user\" u on ur.user_id = \"u\".id\n" +
                "left join \"role\" r on ur.role_id = r.id\n" +
                "WHERE ur.id = ?";
        List<UserRole> userRoleList = jdbcTemplate.query(query, new UserRoleMapper(), id);
        List<UserRole> userRoles = new ArrayList<>(userRoleList);
        return userRoles.get(0);
    }

    @Override
    public List<UserRole> getByUserId(int id) {
        String query =
                "select\n" +
                "       ur.id,\n" +
                "       u.id userId,\n" +
                "       u.username username,\n" +
                "       u.password \"password\",\n" +
                "       r.id roleId,\n" +
                "       r.name roleName\n" +
                "from user_role ur\n" +
                "left join \"user\" u on ur.user_id = \"u\".id\n" +
                "left join \"role\" r on ur.role_id = r.id\n" +
                "WHERE u.id = ?";
        List<UserRole> userRoleList = jdbcTemplate.query(query, new UserRoleMapper(), id);
        return new ArrayList<>(userRoleList);
    }

    @Override
    public List<UserRole> getByUsername(String username) {
        String query =
                "select\n" +
                "       ur.id,\n" +
                "       u.id userId,\n" +
                "       u.username username,\n" +
                "       u.password \"password\",\n" +
                "       r.id roleId,\n" +
                "       r.name roleName\n" +
                "from user_role ur\n" +
                "left join \"user\" u on ur.user_id = \"u\".id\n" +
                "left join \"role\" r on ur.role_id = r.id\n" +
                "WHERE u.username = ?";
        List<UserRole> userRoleList = jdbcTemplate.query(query, new UserRoleMapper(), username);
        return new ArrayList<>(userRoleList);
    }

    @Override
    public List<UserRole> getByRoleId(int id) {
        String query =
                "select\n" +
                "       ur.id,\n" +
                "       u.id userId,\n" +
                "       u.username username,\n" +
                "       u.password \"password\",\n" +
                "       r.id roleId,\n" +
                "       r.name roleName\n" +
                "from user_role ur\n" +
                "left join \"user\" u on ur.user_id = \"u\".id\n" +
                "left join \"role\" r on ur.role_id = r.id\n" +
                "WHERE r.id = ?";
        List<UserRole> userRoleList = jdbcTemplate.query(query, new UserRoleMapper(), id);
        return new ArrayList<>(userRoleList);
    }

    @Override
    public List<UserRole> getByRoleName(String roleName) {
        String query =
                "select\n" +
                        "       ur.id,\n" +
                        "       u.id userId,\n" +
                        "       u.username username,\n" +
                        "       u.password \"password\",\n" +
                        "       r.id roleId,\n" +
                        "       r.name roleName\n" +
                        "from user_role ur\n" +
                        "left join \"user\" u on ur.user_id = \"u\".id\n" +
                        "left join \"role\" r on ur.role_id = r.id\n" +
                        "WHERE r.name = ?";
        List<UserRole> userRoleList = jdbcTemplate.query(query, new UserRoleMapper(), roleName);
        return new ArrayList<>(userRoleList);
    }

    @Override
    public UserRole insert(UserRole userRole) {
        String query = "INSERT INTO user_role (user_id, role_id) VALUES (?, ?)";
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                query,
                Types.INTEGER, Types.INTEGER
        );
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc =
                preparedStatementCreatorFactory.newPreparedStatementCreator(
                        Arrays.asList(
                                userRole.getUser().getUser_id(),
                                userRole.getRole().getId()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                psc,
                keyHolder
        );
        userRole.setId((int) keyHolder.getKeys().get("id"));
        return userRole;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM user_role WHERE id = ? ";
        jdbcTemplate.update(query, id);
    }

    @Override
    public UserRole update(UserRole userRole) {
        String query = "UPDATE user_role SET role_id = ?, user_id = ? WHERE id = ?";
        jdbcTemplate.update(query, userRole.getRole().getId(), userRole.getUser().getUser_id(), userRole.getId());
        return userRole;
    }

    @Override
    public List<UserRole> getAll() {
        String query =
                "select\n" +
                        "       ur.id,\n" +
                        "       u.id userId,\n" +
                        "       u.username username,\n" +
                        "       u.password \"password\",\n" +
                        "       r.id roleId,\n" +
                        "       r.name roleName\n" +
                        "from user_role ur\n" +
                        "left join \"user\" u on ur.user_id = \"u\".id\n" +
                        "left join \"role\" r on ur.role_id = r.id\n";
        List<UserRole> userRoleList = jdbcTemplate.query(query, new UserRoleMapper());
        return new ArrayList<>(userRoleList);
    }
}
