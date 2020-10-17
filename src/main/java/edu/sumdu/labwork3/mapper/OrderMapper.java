package edu.sumdu.labwork3.mapper;

import edu.sumdu.labwork3.model.Consumer;
import edu.sumdu.labwork3.model.Order;
import edu.sumdu.labwork3.model.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OrderMapper implements RowMapper<Order> {

    public static final String ORDER_ID_ROW_NAME = "order_id";
    public static final String ORDER_NUMBER_ROW_NAME = "order_number";
    public static final String ORDER_DATE_ROW_NAME = "order_date";
    public static final String USER_ID_ROW_NAME = "user_id";
    public static final String USERNAME_ROW_NAME = "username";
    public static final String PASSWORD_ROW_NAME = "password";
    public static final String CONSUMER_EMAIL_ROW_NAME = "consumer_email";
    public static final String CONSUMER_LASTNAME_ROW_NAME = "consumer_lastname";
    public static final String CONSUMER_FIRSTNAME_ROW_NAME = "consumer_firstname";
    public static final String CONSUMER_PHONE_NUMBER_ROW_NAME = "consumer_phoneNumber";
    public static final String CONSUMER_COUNTER_PARTY_TYPE_ROW_NAME = "consumer_counterpartyType";
    final static Logger logger = Logger.getLogger(OrderMapper.class);

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        boolean isResultSetValid = validateResultSet(rs);
        if(!isResultSetValid) {
            throw new IllegalArgumentException();
        }
        User user = new User();
        user.setUser_id(rs.getInt(USER_ID_ROW_NAME));
        user.setUsername(rs.getString(USERNAME_ROW_NAME));
        user.setPassword(rs.getString(PASSWORD_ROW_NAME));
        Consumer consumer = new Consumer();
        consumer.setUser(user);
        consumer.setPhoneNumber(rs.getString(CONSUMER_PHONE_NUMBER_ROW_NAME));
        consumer.setCounterpartyType(rs.getString(CONSUMER_COUNTER_PARTY_TYPE_ROW_NAME));
        consumer.setEmail(rs.getString(CONSUMER_EMAIL_ROW_NAME));
        consumer.setFirstname(rs.getString(CONSUMER_FIRSTNAME_ROW_NAME));
        consumer.setLastname(rs.getString(CONSUMER_LASTNAME_ROW_NAME));
        Order order = new Order();
        order.setConsumer(consumer);
        order.setId(rs.getInt(ORDER_ID_ROW_NAME));
        order.setNumber(rs.getInt(ORDER_NUMBER_ROW_NAME));
        order.setOrderDate(rs.getTimestamp(ORDER_DATE_ROW_NAME).toLocalDateTime());
        return null;
    }

    /**
     * This method checks input {@link ResultSet} for its validity.
     * <p>
     * A {@code resultSet} considers to be valid in case if it satisfy the requirements below:
     * <ul>
     * <li>It is not empty</li>
     * <li>It must contain {@link #ORDER_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #ORDER_NUMBER_ROW_NAME} row</li>
     * <li>It must contain {@link #ORDER_DATE_ROW_NAME} row</li>
     * <li>It must contain {@link #USER_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #USERNAME_ROW_NAME} row</li>
     * <li>It must contain {@link #PASSWORD_ROW_NAME} row</li>
     * <li>It must contain {@link #CONSUMER_EMAIL_ROW_NAME} row</li>
     * <li>It must contain {@link #CONSUMER_LASTNAME_ROW_NAME} row</li>
     * <li>It must contain {@link #CONSUMER_FIRSTNAME_ROW_NAME} row</li>
     * <li>It must contain {@link #CONSUMER_PHONE_NUMBER_ROW_NAME} row</li>
     * <li>It must contain {@link #CONSUMER_COUNTER_PARTY_TYPE_ROW_NAME} row</li>
     * </ul>
     * */
    private boolean validateResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Set<String> columnNames = new HashSet<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i));
        }
        return columnNames.containsAll(Arrays.asList(
                ORDER_ID_ROW_NAME,
                ORDER_NUMBER_ROW_NAME,
                ORDER_DATE_ROW_NAME,
                USER_ID_ROW_NAME,
                USERNAME_ROW_NAME,
                PASSWORD_ROW_NAME,
                CONSUMER_EMAIL_ROW_NAME,
                CONSUMER_LASTNAME_ROW_NAME,
                CONSUMER_FIRSTNAME_ROW_NAME,
                CONSUMER_PHONE_NUMBER_ROW_NAME,
                CONSUMER_COUNTER_PARTY_TYPE_ROW_NAME
        ));
    }
}
