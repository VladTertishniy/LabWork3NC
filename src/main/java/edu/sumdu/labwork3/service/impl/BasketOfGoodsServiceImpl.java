package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoBasketOfGoods;
import edu.sumdu.labwork3.model.BasketOfGoods;
import edu.sumdu.labwork3.service.BasketOfGoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketOfGoodsServiceImpl implements BasketOfGoodsService {

    private final DaoBasketOfGoods daoBasketOfGoods;

    public BasketOfGoodsServiceImpl(DaoBasketOfGoods daoBasketOfGoods) {
        this.daoBasketOfGoods = daoBasketOfGoods;
    }

    @Override
    public void insert(BasketOfGoods basketOfGoods) {
        daoBasketOfGoods.insert(basketOfGoods);
    }

    @Override
    public void update(BasketOfGoods basketOfGoods) {
        daoBasketOfGoods.update(basketOfGoods);
    }

    @Override
    public void delete(BasketOfGoods basketOfGoods) {
        daoBasketOfGoods.delete(basketOfGoods);
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
}
