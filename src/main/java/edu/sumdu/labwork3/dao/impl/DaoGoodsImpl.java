package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoGoods;
import edu.sumdu.labwork3.mapper.GoodsMapper;
import edu.sumdu.labwork3.model.Goods;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoGoodsImpl implements DaoGoods {

    private final JdbcTemplate jdbcTemplate;
    final static Logger logger = Logger.getLogger(DaoGoodsImpl.class);

    public DaoGoodsImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Goods goods) {
        String query = "INSERT INTO goods (name, price, goods_type_id, supplier_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, goods.getName(), goods.getPrice(), goods.getGoodsType().getId(), goods.getSupplier().getUser().getUser_id());
    }

    @Override
    public void update(Goods goods) {
        String query = "UPDATE goods SET name = ?, price = ?, goods_type_id = ?, supplier_id = ?  WHERE id = ?";
        jdbcTemplate.update(query, goods.getName(), goods.getPrice(), goods.getGoodsType().getId(), goods.getSupplier().getUser().getUser_id() ,goods.getId());
    }

    @Override
    public void delete(Goods goods) {
        String query = "DELETE FROM goods WHERE id = ? ";
        jdbcTemplate.update(query, goods.getId());
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
                "from \"user\" u\n" +
                "    left join supplier s on u.id = s.user_id\n" +
                "    left join goods g on s.user_id = g.supplier_id\n" +
                "    left join goods_type gt on g.goods_type_id = gt.id";
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
                "from \"user\" u\n" +
                "    left join supplier s on u.id = s.user_id\n" +
                "    left join goods g on s.user_id = g.supplier_id\n" +
                "    left join goods_type gt on g.goods_type_id = gt.id\n" +
                "where g.id = ?";
        List<Goods> goodsList = jdbcTemplate.query(query, new GoodsMapper(), id);
        List<Goods> goods = new ArrayList<>(goodsList);
        return goods.get(0);
    }
}
