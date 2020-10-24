package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoGoodsType;
import edu.sumdu.labwork3.model.GoodsType;
import edu.sumdu.labwork3.mapper.GoodsTypeMapper;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class DaoGoodsTypeIml implements DaoGoodsType {
    private final JdbcTemplate jdbcTemplate;
    final static Logger logger = Logger.getLogger(DaoGoodsTypeIml.class);

    public DaoGoodsTypeIml(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public GoodsType insert(GoodsType goodsType) {
        String query = "INSERT INTO goods_Type (name, parent_id, vendorCode) VALUES (?, ?, ?)";
        Optional<Integer> parent_id = Optional.ofNullable(goodsType.getParent_id());
//        jdbcTemplate.update(query, goodsType.getName(), parent_id.orElse(null), goodsType.getVendorCode());
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                query,
                Types.VARCHAR, Types.INTEGER, Types.VARCHAR
        );
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc =
                preparedStatementCreatorFactory.newPreparedStatementCreator(
                        Arrays.asList(
                                goodsType.getName(),
                                parent_id.orElse(null),
                                goodsType.getVendorCode()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                psc,
                keyHolder
        );
        goodsType.setId((int) keyHolder.getKeys().get("id"));
        return goodsType;
    }

    @Override
    public GoodsType update(GoodsType goodsType) {
        String query = "UPDATE goods_Type SET name = ?, parent_id = ?, vendorCode = ? WHERE id = ?";
        Optional<Integer> parent_id = Optional.ofNullable(goodsType.getParent_id());
        jdbcTemplate.update(query, goodsType.getName(), parent_id.orElse(null), goodsType.getVendorCode(), goodsType.getId());
        return goodsType;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM goods_Type WHERE id = ? ";
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<GoodsType> findAll() {
        String query = "SELECT * FROM goods_type";
        List<GoodsType> goodsTypesList = jdbcTemplate.query(query, new GoodsTypeMapper());
        List<GoodsType> goodsTypes = new ArrayList<>(goodsTypesList);
        logger.info(goodsTypes.toString());
        return goodsTypes;
    }

    @Override
    public GoodsType getById(int id) {
        String query = "SELECT * FROM goods_type WHERE id = ?";
        List<GoodsType> goodsTypesList = jdbcTemplate.query(query, new GoodsTypeMapper(), id);
        List<GoodsType> goodsTypes = new ArrayList<>(goodsTypesList);
        return goodsTypes.get(0);
    }

}
