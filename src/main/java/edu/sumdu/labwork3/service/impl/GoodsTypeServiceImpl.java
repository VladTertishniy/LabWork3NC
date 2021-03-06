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
    public GoodsType insert(GoodsType goodsType) {
        daoGoodsType.insert(goodsType);
        return goodsType;
    }

    @Override
    public List<GoodsType> getAll() {
        return daoGoodsType.findAll();
    }

    @Override
    public GoodsType update(GoodsType goodsType) {
        daoGoodsType.update(goodsType);
        return goodsType;
    }

    @Override
    public void delete(int id) {
        daoGoodsType.delete(id);
    }

    @Override
    public GoodsType getById(int id) {
        return daoGoodsType.getById(id);
    }
}
