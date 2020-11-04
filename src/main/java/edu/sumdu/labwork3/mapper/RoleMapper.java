package edu.sumdu.labwork3.mapper;

import edu.sumdu.labwork3.model.Role;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {

    final static Logger logger = Logger.getLogger(OrderMapper.class);

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setName(rs.getString("name"));
        logger.info("Successfully converting resultSet to basketOfGoods: " + role.toString());
        return role;
    }
}
