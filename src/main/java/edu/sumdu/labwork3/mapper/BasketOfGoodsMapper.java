package edu.sumdu.labwork3.mapper;

import edu.sumdu.labwork3.model.*;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketOfGoodsMapper implements RowMapper<BasketOfGoods> {

    final static Logger logger = Logger.getLogger(BasketOfGoodsMapper.class);

    @Override
    public BasketOfGoods mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUsername(rs.getString("user_name"));
        user.setPassword(rs.getString("user_password"));
        Consumer consumer = new Consumer();
        consumer.setUser(user);
        consumer.setLastname(rs.getString("consumer_lastname"));
        consumer.setFirstname(rs.getString("consumer_firstname"));
        consumer.setEmail(rs.getString("consumer_email"));
        consumer.setCounterpartyType(rs.getString("consumer_counterpartyType"));
        consumer.setPhoneNumber(rs.getString("consumer_phoneNumber"));
        Order order = new Order();
        order.setConsumer(consumer);
        order.setNumber(rs.getInt("order_number"));
        order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
        order.setId(rs.getInt("order_id"));
        Supplier supplier = new Supplier();
        supplier.setUser(user);
        supplier.setEmail(rs.getString("supplier_email"));
        supplier.setFirstname(rs.getString("supplier_firstname"));
        supplier.setLastname(rs.getString("supplier_lastname"));
        supplier.setOrganization(rs.getString("supplier_organization"));
        supplier.setPhoneNumber(rs.getString("supplier_phoneNumber"));
        GoodsType goodsType = new GoodsType();
        goodsType.setId(rs.getInt("goodsType_id"));
        int goodsTypeParenId = rs.getInt("goodsType_parent_id");
        goodsType.setParent_id(goodsTypeParenId != 0 ? goodsTypeParenId : null );
        // additional LOGGER.info("Converting 0 -> null parentID data from ResultSet"); todo
        goodsType.setName(rs.getString("goodsType_name"));
        goodsType.setVendorCode(rs.getString("goodsType_vendorCode"));
        Goods goods = new Goods();
        goods.setPrice(rs.getFloat("goods_price"));
        goods.setGoodsType(goodsType);
        goods.setId(rs.getInt("goods_id"));
        goods.setName(rs.getString("goods_name"));
        goods.setSupplier(supplier);
        BasketOfGoods basketOfGoods = new BasketOfGoods();
        basketOfGoods.setOrder(order);
        basketOfGoods.setGoods(goods);
        basketOfGoods.setCount(rs.getInt("count"));
        basketOfGoods.setSum(rs.getFloat("sum"));
        return basketOfGoods;
    }
}
