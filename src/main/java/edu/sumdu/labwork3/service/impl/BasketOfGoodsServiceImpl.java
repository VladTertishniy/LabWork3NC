package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoBasketOfGoods;
import edu.sumdu.labwork3.model.BasketOfGoods;
import edu.sumdu.labwork3.model.Goods;
import edu.sumdu.labwork3.model.Order;
import edu.sumdu.labwork3.service.BasketOfGoodsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketOfGoodsServiceImpl implements BasketOfGoodsService {

    private final DaoBasketOfGoods daoBasketOfGoods;

    public BasketOfGoodsServiceImpl(DaoBasketOfGoods daoBasketOfGoods) {
        this.daoBasketOfGoods = daoBasketOfGoods;
    }

    @Override
    public BasketOfGoods insert(BasketOfGoods basketOfGoods) {
        return daoBasketOfGoods.insert(basketOfGoods);
    }

    @Override
    public BasketOfGoods update(BasketOfGoods basketOfGoods) {
        return daoBasketOfGoods.update(basketOfGoods);
    }

    @Override
    public void delete(BasketOfGoods basketOfGoods) {
        daoBasketOfGoods.delete(basketOfGoods);
    }

    @Override
    public void delete(int orderId, int goodsId) {
        daoBasketOfGoods.delete(orderId, goodsId);
    }

    @Override
    public List<BasketOfGoods> findAll() {
        return daoBasketOfGoods.findAll();
    }

    @Override
    public List<BasketOfGoods> getByGoodsId(int id) {
        return daoBasketOfGoods.getByGoodsId(id);
    }

    @Override
    public List<BasketOfGoods> getByOrderId(int id) {
        return daoBasketOfGoods.getByOrderId(id);
    }

    @Override
    public BasketOfGoods getByOrderAndGoodsId(int orderId, int goodsId) {
        return daoBasketOfGoods.getByOrderAndGoodsId(orderId, goodsId);
    }

    @Override
    public List<BasketOfGoods> preparedBaskets(Order order, List<Goods> goodsList) {
        List<BasketOfGoods> basketOfGoodsList = new ArrayList<>();
        for (Goods goods:goodsList) {
            BasketOfGoods basketOfGoods = new BasketOfGoods();
            basketOfGoods.setOrder(order);
            basketOfGoods.setGoods(goods);
            basketOfGoodsList.add(basketOfGoods);
        }
        return  basketOfGoodsList;
    }
}
