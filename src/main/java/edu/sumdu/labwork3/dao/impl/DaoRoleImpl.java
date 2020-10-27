package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoRole;
import edu.sumdu.labwork3.mapper.RoleMapper;
import edu.sumdu.labwork3.model.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class DaoRoleImpl implements DaoRole {

    private final JdbcTemplate jdbcTemplate;

    public DaoRoleImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role getById(int id) {
        String query = "SELECT * FROM role WHERE id = ?";
        List<Role> roleList = jdbcTemplate.query(query, new RoleMapper(), id);
        List<Role> roles = new ArrayList<>(roleList);
        return roles.get(0);
    }

    @Override
    public Role insert(Role role) {
        String query = "INSERT INTO role (name) VALUES (?)";
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                query,
                Types.VARCHAR
        );
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc =
                preparedStatementCreatorFactory.newPreparedStatementCreator(
                        Collections.singletonList(
                                role.getName()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                psc,
                keyHolder
        );
        role.setId((int) keyHolder.getKeys().get("id"));
        return role;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM role WHERE id = ? ";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Role update(Role role) {
        String query = "UPDATE role SET name = ? WHERE id = ?";
        jdbcTemplate.update(query, role.getName(), role.getId());
        return role;
    }

    @Override
    public List<Role> getAll() {
        String query = "SELECT * FROM role";
        List<Role> roleList = jdbcTemplate.query(query, new RoleMapper());
        return new ArrayList<>(roleList);
    }
}
