package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DAO;
import edu.sumdu.labwork3.dao.DaoGoodsType;
import edu.sumdu.labwork3.model.GoodsType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DaoGoodsTypeIml implements DaoGoodsType {
    private final JdbcTemplate jdbcTemplate;
    List<GoodsType> goodsTypes;

    public DaoGoodsTypeIml(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insert(GoodsType goodsType) {
        String query = "INSERT INTO goodsType (title, parent) VALUES (?, ?)";
        Optional<GoodsType> parent = Optional.ofNullable(goodsType.getParentGoodsType());
        jdbcTemplate.update(query, goodsType.getName(), parent.isPresent() ? parent.get().getId() : null);
    }

    @Override
    public void update(GoodsType goodsType) {
        String query = "UPDATE goodsType SET title = ?, parent = ? WHERE id = ?";
        Optional<GoodsType> parent = Optional.ofNullable(goodsType.getParentGoodsType());
        jdbcTemplate.update(query, goodsType.getName(), parent.isPresent() ? parent.get().getId() : null, goodsType.getId());
    }

    @Override
    public void delete(GoodsType goodsType) {
        String query = "DELETE FROM goodsType WHERE id = ? ";
        jdbcTemplate.update(query, goodsType.getId());
    }

    @Override
    public List<GoodsType> findAll() {
        goodsTypes = new ArrayList<>();
        String query = "SELECT * FROM goodsType";
        return goodsTypes;
    }

}
