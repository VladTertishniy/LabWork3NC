package edu.sumdu.labwork3.model.impl;

import edu.sumdu.labwork3.dao.DaoGoodsType;
import edu.sumdu.labwork3.model.GoodsType;
import edu.sumdu.labwork3.model.GoodsTypeService;
import org.springframework.stereotype.Service;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    private final DaoGoodsType daoGoodsType;

    public GoodsTypeServiceImpl(DaoGoodsType daoGoodsType) {
        this.daoGoodsType = daoGoodsType;
    }

    @Override
    public void create(GoodsType goodsType) {
        daoGoodsType.insert(goodsType);
    }
}
