package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoGoods;
import edu.sumdu.labwork3.model.Goods;
import edu.sumdu.labwork3.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    private final DaoGoods daoGoods;

    public GoodsServiceImpl(DaoGoods daoGoods) {
        this.daoGoods = daoGoods;
    }

    @Override
    public void insert(Goods goods) {
        daoGoods.insert(goods);
    }

    @Override
    public List<Goods> getAll() {
        return daoGoods.findAll();
    }

    @Override
    public void update(Goods goods) {
        daoGoods.update(goods);
    }

    @Override
    public void delete(Goods goods) {
        daoGoods.delete(goods);
    }

    @Override
    public Goods getById(int id) {
        return daoGoods.getById(id);
    }
}
