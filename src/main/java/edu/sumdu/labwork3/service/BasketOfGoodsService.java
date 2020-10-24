package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.BasketOfGoods;

import java.util.List;

public interface BasketOfGoodsService {
    void insert(BasketOfGoods basketOfGoods);
    void update(BasketOfGoods basketOfGoods);
    void delete(BasketOfGoods basketOfGoods);
    List<BasketOfGoods> findAll();
    List<BasketOfGoods> getByGoodsId(int id);
    List<BasketOfGoods> getByOrderId(int id);
}
