package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoSupplier;
import edu.sumdu.labwork3.mapper.SupplierMapper;
import edu.sumdu.labwork3.model.Supplier;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoSupplierImpl implements DaoSupplier {

    private final JdbcTemplate jdbcTemplate;
    final static Logger logger = Logger.getLogger(DaoSupplierImpl.class);

    public DaoSupplierImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Supplier insert(Supplier supplier) {
        String query = "INSERT INTO supplier (user_id, firstname, lastname, phonenumber, email, organization) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                query,
                supplier.getUser().getUser_id(),
                supplier.getFirstname(),
                supplier.getLastname(),
                supplier.getPhoneNumber(),
                supplier.getEmail(),
                supplier.getOrganization());
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        String query = "UPDATE supplier SET firstname = ?, lastname = ?, phonenumber = ?, email = ?, organization = ? WHERE user_id = ?";
        jdbcTemplate.update(
                query,
                supplier.getFirstname(),
                supplier.getLastname(),
                supplier.getPhoneNumber(),
                supplier.getEmail(),
                supplier.getOrganization(),
                supplier.getUser().getUser_id());
        return supplier;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM supplier WHERE user_id = ? ";
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<Supplier> findAll() {
        String query =
                "select\n" +
                "       u.id user_id,\n" +
                "       u.username user_name,\n" +
                "       u.password user_password,\n" +
                "       s.organization,\n" +
                "       s.email,\n" +
                "       s.lastname,\n" +
                "       s.firstname,\n" +
                "       s.phoneNumber\n" +
                "from supplier s\n" +
                "    left join \"user\" u on s.user_id = u.id;";
        List<Supplier> supplierList = jdbcTemplate.query(query, new SupplierMapper());
        return new ArrayList<>(supplierList);
    }

    @Override
    public Supplier getById(int id) {
        String query =
                "select\n" +
                        "       u.id user_id,\n" +
                        "       u.username user_name,\n" +
                        "       u.password user_password,\n" +
                        "       s.organization,\n" +
                        "       s.email,\n" +
                        "       s.lastname,\n" +
                        "       s.firstname,\n" +
                        "       s.phoneNumber\n" +
                        "from supplier s\n" +
                        "    left join \"user\" u on s.user_id = u.id where s.user_id = ?;";
        List<Supplier> supplierList = jdbcTemplate.query(query, new SupplierMapper(), id);
        List<Supplier> suppliers = new ArrayList<>(supplierList);
        return suppliers.get(0);
    }
}
