package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoGoodsType;
import edu.sumdu.labwork3.model.GoodsType;
import edu.sumdu.labwork3.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    private final DaoGoodsType daoGoodsType;

    public GoodsTypeServiceImpl(DaoGoodsType daoGoodsType) {
        this.daoGoodsType = daoGoodsType;
    }

    @Override
    public void insert(GoodsType goodsType) {
        daoGoodsType.insert(goodsType);
    }

    @Override
    public List<GoodsType> getAll() {
        return daoGoodsType.findAll();
    }

    @Override
    public void update(GoodsType goodsType) {
        daoGoodsType.update(goodsType);
    }

    @Override
    public void delete(GoodsType goodsType) {
        daoGoodsType.delete(goodsType);
    }

    @Override
    public GoodsType getById(int id) {
        //todo
        return daoGoodsType.findById(id);
    }
}
