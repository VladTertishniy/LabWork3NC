package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.BasketOfGoods;

import java.util.List;

public interface DaoBasketOfGoods {
    BasketOfGoods insert(BasketOfGoods basketOfGoods);
    BasketOfGoods update(BasketOfGoods basketOfGoods);
    void delete(BasketOfGoods basketOfGoods);
    void delete(int orderId, int goodsId);
    List<BasketOfGoods> findAll();
    List<BasketOfGoods> getByGoodsId(int id);
    List<BasketOfGoods> getByOrderId(int id);
    BasketOfGoods getByOrderAndGoodsId(int orderId, int goodsId);
}
