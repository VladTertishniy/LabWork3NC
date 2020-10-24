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
    public Goods insert(Goods goods) {
       return daoGoods.insert(goods);
    }

    @Override
    public List<Goods> getAll() {
        return daoGoods.findAll();
    }

    @Override
    public Goods update(Goods goods) {
        return daoGoods.update(goods);
    }

    @Override
    public void delete(int id) {
        daoGoods.delete(id);
    }

    @Override
    public Goods getById(int id) {
        return daoGoods.getById(id);
    }
}
