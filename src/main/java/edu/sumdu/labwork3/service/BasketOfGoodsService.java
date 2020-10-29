package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.BasketOfGoods;
import edu.sumdu.labwork3.model.Goods;
import edu.sumdu.labwork3.model.Order;

import java.util.List;

public interface BasketOfGoodsService {
    BasketOfGoods insert(BasketOfGoods basketOfGoods);
    BasketOfGoods update(BasketOfGoods basketOfGoods);
    void delete(BasketOfGoods basketOfGoods);
    void delete(int orderId, int goodsId);
    List<BasketOfGoods> findAll();
    List<BasketOfGoods> getByGoodsId(int id);
    List<BasketOfGoods> getByOrderId(int id);
    BasketOfGoods getByOrderAndGoodsId(int orderId, int goodsId);
    List<BasketOfGoods> preparedBaskets(Order order, List<Goods> goodsList);
}
