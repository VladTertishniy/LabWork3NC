package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoConsumer;
import edu.sumdu.labwork3.mapper.ConsumerMapper;
import edu.sumdu.labwork3.model.Consumer;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoConsumerImpl implements DaoConsumer {

    private final JdbcTemplate jdbcTemplate;
    final static Logger logger = Logger.getLogger(DaoConsumerImpl.class);

    public DaoConsumerImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Consumer consumer) {
        String query = "INSERT INTO consumer (user_id, firstname, lastname, phonenumber, email, counterpartytype) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                query,
                consumer.getUser().getUser_id(),
                consumer.getFirstname(),
                consumer.getLastname(),
                consumer.getPhoneNumber(),
                consumer.getEmail(),
                consumer.getCounterpartyType());
    }

    @Override
    public void update(Consumer consumer) {
        String query = "UPDATE consumer SET firstname = ?, lastname = ?, phonenumber = ?, email = ?, counterpartytype = ? WHERE user_id = ?";
        jdbcTemplate.update(
                query,
                consumer.getFirstname(),
                consumer.getLastname(),
                consumer.getPhoneNumber(),
                consumer.getEmail(),
                consumer.getCounterpartyType(),
                consumer.getUser().getUser_id());
    }

    @Override
    public void delete(Consumer consumer) {
        String query = "DELETE FROM consumer WHERE user_id = ? ";
        jdbcTemplate.update(query, consumer.getUser().getUser_id());
    }

    @Override
    public List<Consumer> findAll() {
        String query =
                "select\n" +
                "       u.id User_id,\n" +
                "       u.username user_name,\n" +
                "       u.password user_password,\n" +
                "       c.phoneNumber phonenumber,\n" +
                "       c.firstname firstname,\n" +
                "       c.lastname lastname,\n" +
                "       c.email email,\n" +
                "       c.counterpartytype counterpartytype\n" +
                "from consumer c left join \"user\" u on c.user_id = u.id;";
        List<Consumer> consumerList = jdbcTemplate.query(query, new ConsumerMapper());
        return new ArrayList<>(consumerList);
    }

    @Override
    public Consumer getById(int id) {
        String query =
                "select\n" +
                        "       u.id User_id,\n" +
                        "       u.username user_name,\n" +
                        "       u.password user_password,\n" +
                        "       c.phoneNumber phonenumber,\n" +
                        "       c.firstname firstname,\n" +
                        "       c.lastname lastname,\n" +
                        "       c.email email,\n" +
                        "       c.counterpartytype counterpartytype\n" +
                        "from consumer c left join \"user\" u on c.user_id = u.id where c.user_id = ?;";
        List<Consumer> consumerList = jdbcTemplate.query(query, new ConsumerMapper(), id);
        List<Consumer> consumers = new ArrayList<>(consumerList);
        return consumers.get(0);
    }
}
