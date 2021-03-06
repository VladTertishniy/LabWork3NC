package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DaoBasketOfGoods;
import edu.sumdu.labwork3.mapper.BasketOfGoodsMapper;
import edu.sumdu.labwork3.model.BasketOfGoods;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoBasketOfGoodsImpl implements DaoBasketOfGoods {

    private final JdbcTemplate jdbcTemplate;
    final static Logger logger = Logger.getLogger(DaoBasketOfGoodsImpl.class);

    public DaoBasketOfGoodsImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BasketOfGoods insert(BasketOfGoods basketOfGoods) {
        String query = "INSERT INTO basket_of_goods (goods_id, order_id, count, sum) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
                query,
                basketOfGoods.getGoods().getId(),
                basketOfGoods.getOrder().getId(),
                basketOfGoods.getCount(),
                basketOfGoods.getSum());
        return basketOfGoods;
    }

    @Override
    public BasketOfGoods update(BasketOfGoods basketOfGoods) {
        String query = "UPDATE basket_of_goods SET count = ?, sum = ? WHERE order_id = ? and goods_id = ?";
        jdbcTemplate.update(
                query,
                basketOfGoods.getCount(),
                basketOfGoods.getSum(),
                basketOfGoods.getOrder().getId(),
                basketOfGoods.getGoods().getId());
        return basketOfGoods;
    }

    @Override
    public void delete(BasketOfGoods basketOfGoods) {
        delete(basketOfGoods.getOrder().getId(), basketOfGoods.getGoods().getId());
    }

    @Override
    public void delete(int orderId, int goodsId) {
        String query = "DELETE FROM basket_of_goods WHERE order_id = ? AND goods_id = ?";
        jdbcTemplate.update(query, orderId, goodsId);
    }

    @Override
    public List<BasketOfGoods> findAll() {
        String query = "select u.id user_id,\n" +
                "       u.username user_name,\n" +
                "       u.password user_password,\n" +
                "       c.email consumer_email,\n" +
                "       c.lastname consumer_lastname,\n" +
                "       c.firstname consumer_firstname,\n" +
                "       c.phoneNumber consumer_phoneNumber,\n" +
                "       c.counterpartyType consumer_counterpartyType,\n" +
                "       o.id order_id,\n" +
                "       o.number order_number,\n" +
                "       o.orderDate order_date,\n" +
                "       g.id goods_id,\n" +
                "       g.name goods_name,\n" +
                "       g.price goods_price,\n" +
                "       g.supplier_id goods_supplier_id,\n" +
                "       gt.id goodsType_id,\n" +
                "       gt.name goodsType_name,\n" +
                "       gt.parent_id goodsType_parent_id,\n" +
                "       gt.vendorCode goodsType_vendorCode,\n" +
                "       s.firstname supplier_firstname,\n" +
                "       s.lastname supplier_lastname,\n" +
                "       s.phoneNumber supplier_phoneNumber,\n" +
                "       s.email supplier_email,\n" +
                "       s.organization supplier_organization,\n" +
                "       bg.count,\n" +
                "       bg.sum\n" +
                "from basket_of_goods bg\n" +
                "    left join \"order\" o on bg.order_id = o.id\n" +
                "    left join \"user\" u on o.user_id = u.id\n" +
                "    left join consumer c on u.id = c.user_id\n" +
                "    left join goods g on bg.goods_id = g.id\n" +
                "    left join goods_type gt on g.goods_type_id = gt.id\n" +
                "    left join supplier s on g.supplier_id = s.user_id";
        List<BasketOfGoods> basketOfGoodsList = jdbcTemplate.query(query, new BasketOfGoodsMapper());
        List<BasketOfGoods> basketsOfGoods = new ArrayList<>(basketOfGoodsList);
        logger.info(basketsOfGoods.toString());
        return basketsOfGoods;
    }

    @Override
    public List<BasketOfGoods> getByGoodsId(int id) {
        String query = "select u.id user_id,\n" +
                "       u.username user_name,\n" +
                "       u.password user_password,\n" +
                "       c.email consumer_email,\n" +
                "       c.lastname consumer_lastname,\n" +
                "       c.firstname consumer_firstname,\n" +
                "       c.phoneNumber consumer_phoneNumber,\n" +
                "       c.counterpartyType consumer_counterpartyType,\n" +
                "       o.id order_id,\n" +
                "       o.number order_number,\n" +
                "       o.orderDate order_date,\n" +
                "       g.id goods_id,\n" +
                "       g.name goods_name,\n" +
                "       g.price goods_price,\n" +
                "       g.supplier_id goods_supplier_id,\n" +
                "       gt.id goodsType_id,\n" +
                "       gt.name goodsType_name,\n" +
                "       gt.parent_id goodsType_parent_id,\n" +
                "       gt.vendorCode goodsType_vendorCode,\n" +
                "       s.firstname supplier_firstname,\n" +
                "       s.lastname supplier_lastname,\n" +
                "       s.phoneNumber supplier_phoneNumber,\n" +
                "       s.email supplier_email,\n" +
                "       s.organization supplier_organization,\n" +
                "       bg.count,\n" +
                "       bg.sum\n" +
                "from basket_of_goods bg\n" +
                "    left join \"order\" o on bg.order_id = o.id\n" +
                "    left join \"user\" u on o.user_id = u.id\n" +
                "    left join consumer c on u.id = c.user_id\n" +
                "    left join goods g on bg.goods_id = g.id\n" +
                "    left join goods_type gt on g.goods_type_id = gt.id\n" +
                "    left join supplier s on g.supplier_id = s.user_id where g.id = ?";
        List<BasketOfGoods> basketOfGoodsList = jdbcTemplate.query(query, new BasketOfGoodsMapper(), id);
        return new ArrayList<>(basketOfGoodsList);
    }

    @Override
    public List<BasketOfGoods> getByOrderId(int id) {
        String query = "select u.id user_id,\n" +
                "       u.username user_name,\n" +
                "       u.password user_password,\n" +
                "       c.email consumer_email,\n" +
                "       c.lastname consumer_lastname,\n" +
                "       c.firstname consumer_firstname,\n" +
                "       c.phoneNumber consumer_phoneNumber,\n" +
                "       c.counterpartyType consumer_counterpartyType,\n" +
                "       o.id order_id,\n" +
                "       o.number order_number,\n" +
                "       o.orderDate order_date,\n" +
                "       g.id goods_id,\n" +
                "       g.name goods_name,\n" +
                "       g.price goods_price,\n" +
                "       g.supplier_id goods_supplier_id,\n" +
                "       gt.id goodsType_id,\n" +
                "       gt.name goodsType_name,\n" +
                "       gt.parent_id goodsType_parent_id,\n" +
                "       gt.vendorCode goodsType_vendorCode,\n" +
                "       s.firstname supplier_firstname,\n" +
                "       s.lastname supplier_lastname,\n" +
                "       s.phoneNumber supplier_phoneNumber,\n" +
                "       s.email supplier_email,\n" +
                "       s.organization supplier_organization,\n" +
                "       bg.count,\n" +
                "       bg.sum\n" +
                "from basket_of_goods bg\n" +
                "    left join \"order\" o on bg.order_id = o.id\n" +
                "    left join \"user\" u on o.user_id = u.id\n" +
                "    left join consumer c on u.id = c.user_id\n" +
                "    left join goods g on bg.goods_id = g.id\n" +
                "    left join goods_type gt on g.goods_type_id = gt.id\n" +
                "    left join supplier s on g.supplier_id = s.user_id where o.id = ?";
        List<BasketOfGoods> basketOfGoodsList = jdbcTemplate.query(query, new BasketOfGoodsMapper(), id);
        return new ArrayList<>(basketOfGoodsList);
    }

    @Override
    public BasketOfGoods getByOrderAndGoodsId(int orderId, int goodsId) {
        String query = "select u.id user_id,\n" +
                "       u.username user_name,\n" +
                "       u.password user_password,\n" +
                "       c.email consumer_email,\n" +
                "       c.lastname consumer_lastname,\n" +
                "       c.firstname consumer_firstname,\n" +
                "       c.phoneNumber consumer_phoneNumber,\n" +
                "       c.counterpartyType consumer_counterpartyType,\n" +
                "       o.id order_id,\n" +
                "       o.number order_number,\n" +
                "       o.orderDate order_date,\n" +
                "       g.id goods_id,\n" +
                "       g.name goods_name,\n" +
                "       g.price goods_price,\n" +
                "       g.supplier_id goods_supplier_id,\n" +
                "       gt.id goodsType_id,\n" +
                "       gt.name goodsType_name,\n" +
                "       gt.parent_id goodsType_parent_id,\n" +
                "       gt.vendorCode goodsType_vendorCode,\n" +
                "       s.firstname supplier_firstname,\n" +
                "       s.lastname supplier_lastname,\n" +
                "       s.phoneNumber supplier_phoneNumber,\n" +
                "       s.email supplier_email,\n" +
                "       s.organization supplier_organization,\n" +
                "       bg.count,\n" +
                "       bg.sum\n" +
                "from basket_of_goods bg\n" +
                "    left join \"order\" o on bg.order_id = o.id\n" +
                "    left join \"user\" u on o.user_id = u.id\n" +
                "    left join consumer c on u.id = c.user_id\n" +
                "    left join goods g on bg.goods_id = g.id\n" +
                "    left join goods_type gt on g.goods_type_id = gt.id\n" +
                "    left join supplier s on g.supplier_id = s.user_id where o.id = ? and g.id = ?";
        List<BasketOfGoods> basketOfGoodsList = jdbcTemplate.query(query, new BasketOfGoodsMapper(), orderId, goodsId);
        return new ArrayList<>(basketOfGoodsList).get(0);
    }
}
