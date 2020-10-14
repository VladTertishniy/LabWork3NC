package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoGoodsType;
import edu.sumdu.labwork3.model.GoodsType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        String query = "INSERT INTO goods_Type (name, parent_id, vendorCode) VALUES (?, ?, ?)";
        Optional<Integer> parent_id = Optional.ofNullable(goodsType.getParent_id());
        jdbcTemplate.update(query, goodsType.getName(), parent_id.isPresent() ? parent_id : null, goodsType.getVendorCode());
    }

    @Override
    public void update(GoodsType goodsType) {
        String query = "UPDATE goods_Type SET name = ?, parent_id = ?, vendorCode = ? WHERE id = ?";
        Optional<Integer> parent_id = Optional.ofNullable(goodsType.getParent_id());
        jdbcTemplate.update(query, goodsType.getName(), parent_id.isPresent() ? parent_id : null, goodsType.getVendorCode(), goodsType.getId());
    }

    @Override
    public void delete(GoodsType goodsType) {
        String query = "DELETE FROM goods_Type WHERE id = ? ";
        jdbcTemplate.update(query, goodsType.getId());
    }

    @Override
    public List<GoodsType> findAll() {
        goodsTypes = new ArrayList<>();
        String query = "SELECT * FROM goods_Type";
        //todo
        return goodsTypes;
    }

    @Override
    public GoodsType findById(int id) {
        //todo
        return null;
    }

}
