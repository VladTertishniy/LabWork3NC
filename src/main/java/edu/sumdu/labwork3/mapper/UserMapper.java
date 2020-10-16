package edu.sumdu.labwork3.mapper;

import edu.sumdu.labwork3.model.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserMapper implements RowMapper<User> {

    public static final String USER_ID_ROW_NAME = "id";
    public static final String PASSWORD_ROW_NAME = "username";
    public static final String USERNAME_NAME = "password";
    final static Logger logger = Logger.getLogger(UserMapper.class);

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        boolean isResultSetValid = validateResultSet(rs);
        if(!isResultSetValid) {
            throw new IllegalArgumentException();
        }
        User user = new User();
        user.setUser_id(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    /**
     * This method checks input {@link ResultSet} for its validity.
     * <p>
     * A {@code resultSet} considers to be valid in case if it satisfy the requirements below:
     * <ul>
     * <li>It is not empty</li>
     * <li>It must contain {@link #USER_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #PASSWORD_ROW_NAME} row</li>
     * <li>It must contain {@link #USERNAME_NAME} row</li>
     * </ul>
     * */
    private boolean validateResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Set<String> columnNames = new HashSet<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i));
        }
        return columnNames.containsAll(Arrays.asList(
                USER_ID_ROW_NAME,
                PASSWORD_ROW_NAME,
                USERNAME_NAME));
    }
}
