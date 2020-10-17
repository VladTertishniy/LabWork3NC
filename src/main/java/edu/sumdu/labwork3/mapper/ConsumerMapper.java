package edu.sumdu.labwork3.mapper;

import edu.sumdu.labwork3.model.Consumer;
import edu.sumdu.labwork3.model.Supplier;
import edu.sumdu.labwork3.model.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConsumerMapper implements RowMapper<Consumer> {

    public static final String USER_ID_ROW_NAME = "user_id";
    public static final String USER_NAME_ROW_NAME = "user_name";
    public static final String USER_PASSWORD_ROW_NAME = "user_password";
    public static final String PHONE_NUMBER_ROW_NAME = "phonenumber";
    public static final String FIRSTNAME_ROW_NAME = "firstname";
    public static final String LASTNAME_ROW_NAME = "lastname";
    public static final String EMAIL_ROW_NAME = "email";
    public static final String COUNTERPARTYTYPE_ROW_NAME = "counterpartytype";
    final static Logger logger = Logger.getLogger(ConsumerMapper.class);

    @Override
    public Consumer mapRow(ResultSet rs, int rowNum) throws SQLException {
        boolean isResultSetValid = validateResultSet(rs);
        if(!isResultSetValid) {
            throw new IllegalArgumentException();
        }
        User user = new User();
        user.setUser_id(rs.getInt(USER_ID_ROW_NAME));
        user.setUsername(rs.getString(USER_NAME_ROW_NAME));
        user.setPassword(rs.getString(USER_PASSWORD_ROW_NAME));
        Consumer consumer = new Consumer();
        consumer.setLastname(rs.getString(LASTNAME_ROW_NAME));
        consumer.setFirstname(rs.getString(FIRSTNAME_ROW_NAME));
        consumer.setEmail(rs.getString(EMAIL_ROW_NAME));
        consumer.setCounterpartyType(rs.getString(COUNTERPARTYTYPE_ROW_NAME));
        consumer.setPhoneNumber(rs.getString(PHONE_NUMBER_ROW_NAME));
        consumer.setUser(user);
        return consumer;
    }

    /**
     * This method checks input {@link ResultSet} for its validity.
     * <p>
     * A {@code resultSet} considers to be valid in case if it satisfy the requirements below:
     * <ul>
     * <li>It is not empty</li>
     * <li>It must contain {@link #USER_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #USER_NAME_ROW_NAME} row</li>
     * <li>It must contain {@link #USER_PASSWORD_ROW_NAME} row</li>
     * <li>It must contain {@link #COUNTERPARTYTYPE_ROW_NAME} row</li>
     * <li>It must contain {@link #EMAIL_ROW_NAME} row</li>
     * <li>It must contain {@link #LASTNAME_ROW_NAME} row</li>
     * <li>It must contain {@link #FIRSTNAME_ROW_NAME} row</li>
     * <li>It must contain {@link #PHONE_NUMBER_ROW_NAME} row</li>
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
                USER_NAME_ROW_NAME,
                USER_PASSWORD_ROW_NAME,
                COUNTERPARTYTYPE_ROW_NAME,
                EMAIL_ROW_NAME,
                LASTNAME_ROW_NAME,
                FIRSTNAME_ROW_NAME,
                PHONE_NUMBER_ROW_NAME
        ));
    }
}
