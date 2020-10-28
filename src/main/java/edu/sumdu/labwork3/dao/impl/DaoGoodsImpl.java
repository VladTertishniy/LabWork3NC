package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoGoods;
import edu.sumdu.labwork3.mapper.GoodsMapper;
import edu.sumdu.labwork3.model.Goods;
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

@Repository
public class DaoGoodsImpl implements DaoGoods {

    private final JdbcTemplate jdbcTemplate;
    final static Logger logger = Logger.getLogger(DaoGoodsImpl.class);

    public DaoGoodsImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Goods insert(Goods goods) {
        String query = "INSERT INTO goods (name, price, goods_type_id, supplier_id) VALUES (?, ?, ?, ?)";
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                query,
                Types.VARCHAR, Types.NUMERIC, Types.INTEGER, Types.INTEGER
        );
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc =
                preparedStatementCreatorFactory.newPreparedStatementCreator(
                        Arrays.asList(
                                goods.getName(),
                                goods.getPrice(),
                                goods.getGoodsType().getId(),
                                goods.getSupplier().getUser().getUser_id()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                psc,
                keyHolder
        );
        goods.setId((int) keyHolder.getKeys().get("id"));
        return goods;
    }

    @Override
    public Goods update(Goods goods) {
        String query = "UPDATE goods SET name = ?, price = ?, goods_type_id = ?, supplier_id = ?  WHERE id = ?";
        jdbcTemplate.update(query, goods.getName(), goods.getPrice(), goods.getGoodsType().getId(), goods.getSupplier().getUser().getUser_id() ,goods.getId());
        return goods;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM goods WHERE id = ? ";
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<Goods> findAll() {
        String query = "select\n" +
                "       u.id user_id,\n" +
                "       u.username user_name,\n" +
                "       u.password user_password,\n" +
                "       s.firstname supplier_firstname,\n" +
                "       s.lastname supplier_lastname,\n" +
                "       s.phoneNumber supplier_phoneNumber,\n" +
                "       s.email supplier_email,\n" +
                "       s.organization supplier_organization,\n" +
                "       g.id goods_id,\n" +
                "       g.name goods_name,\n" +
                "       g.price goods_price,\n" +
                "       g.supplier_id goods_supplier_id,\n" +
                "       gt.id goodsType_id,\n" +
                "       gt.name goodsType_name,\n" +
                "       gt.parent_id goodsType_parent_id,\n" +
                "       gt.vendorCode goodsType_vendorCode\n" +
                "from goods g\n" +
                "    left join supplier s on g.supplier_id = s.user_id\n" +
                "    left join \"user\" u on s.user_id = u.id\n" +
                "    left join goods_type gt on g.goods_type_id = gt.id\n";
        List<Goods> goodsList = jdbcTemplate.query(query, new GoodsMapper());
        List<Goods> goods = new ArrayList<>(goodsList);
        logger.info(goods.toString());
        return goods;
    }

    @Override
    public Goods getById(int id) {
        String query = "select\n" +
                "       u.id user_id,\n" +
                "       u.username user_name,\n" +
                "       u.password user_password,\n" +
                "       s.firstname supplier_firstname,\n" +
                "       s.lastname supplier_lastname,\n" +
                "       s.phoneNumber supplier_phoneNumber,\n" +
                "       s.email supplier_email,\n" +
                "       s.organization supplier_organization,\n" +
                "       g.id goods_id,\n" +
                "       g.name goods_name,\n" +
                "       g.price goods_price,\n" +
                "       g.supplier_id goods_supplier_id,\n" +
                "       gt.id goodsType_id,\n" +
                "       gt.name goodsType_name,\n" +
                "       gt.parent_id goodsType_parent_id,\n" +
                "       gt.vendorCode goodsType_vendorCode\n" +
                "from goods g\n" +
                "    left join supplier s on g.supplier_id = s.user_id\n" +
                "    left join \"user\" u on s.user_id = u.id\n" +
                "    left join goods_type gt on g.goods_type_id = gt.id\n" +
                "where g.id = ?";
        List<Goods> goodsList = jdbcTemplate.query(query, new GoodsMapper(), id);
        List<Goods> goods = new ArrayList<>(goodsList);
        return goods.get(0);
    }
}
