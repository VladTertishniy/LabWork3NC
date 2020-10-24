package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoOrder;
import edu.sumdu.labwork3.mapper.OrderMapper;
import edu.sumdu.labwork3.model.Order;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoOrderImpl implements DaoOrder {

    private final JdbcTemplate jdbcTemplate;
    final static Logger logger = Logger.getLogger(DaoOrderImpl.class);

    public DaoOrderImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order insert(Order order) {
        String query = "insert into \"order\"(number, user_id, orderDate) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, order.getNumber(), order.getConsumer().getUser().getUser_id(), Timestamp.valueOf(order.getOrderDate()));
        return order;
    }

    @Override
    public Order update(Order order) {
        String query = "UPDATE \"order\" SET number = ?, user_id = ?, orderDate = ? WHERE id = ?";
        jdbcTemplate.update(query, order.getNumber(), order.getConsumer().getUser().getUser_id(), Timestamp.valueOf(order.getOrderDate()));
        return order;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM \"order\" WHERE id = ? ";
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<Order> findAll() {
        String query = "select\n" +
                "       o.id order_id,\n" +
                "       o.number order_number,\n" +
                "       o.orderDate order_date,\n" +
                "       u.id user_id,\n" +
                "       u.username,\n" +
                "       u.password,\n" +
                "       c.email consumer_email,\n" +
                "       c.lastname consumer_lastname,\n" +
                "       c.firstname consumer_firstname,\n" +
                "       c.phoneNumber consumer_phoneNumber,\n" +
                "       c.counterpartyType consumer_counterpartyType\n" +
                "from \"order\" o left join \"user\" u on o.user_id = u.id left join consumer c on u.id = c.user_id";
        List<Order> orderList = jdbcTemplate.query(query, new OrderMapper());
        return new ArrayList<>(orderList);
    }

    @Override
    public Order getById(int id) {
        String query = "select\n" +
                "       o.id order_id,\n" +
                "       o.number order_number,\n" +
                "       o.orderDate order_date,\n" +
                "       u.id user_id,\n" +
                "       u.username,\n" +
                "       u.password,\n" +
                "       c.email consumer_email,\n" +
                "       c.lastname consumer_lastname,\n" +
                "       c.firstname consumer_firstname,\n" +
                "       c.phoneNumber consumer_phoneNumber,\n" +
                "       c.counterpartyType consumer_counterpartyType\n" +
                "from \"order\" o left join \"user\" u on o.user_id = u.id left join consumer c on u.id = c.user_id";
        List<Order> orderList = jdbcTemplate.query(query, new OrderMapper(), id);
        List<Order> orders = new ArrayList<>(orderList);
        return orders.get(0);
    }
}
