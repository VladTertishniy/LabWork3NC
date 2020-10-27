package edu.sumdu.labwork3.mapper;

import edu.sumdu.labwork3.model.Role;
import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.model.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleMapper implements RowMapper<UserRole> {

    @Override
    public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("userId"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        Role role = new Role();
        role.setId(rs.getInt("roleId"));
        role.setName(rs.getString("roleName"));
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRole.setId(rs.getInt("id"));
        return userRole;
    }
}
