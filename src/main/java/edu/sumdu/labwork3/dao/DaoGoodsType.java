package edu.sumdu.labwork3.dao;


import edu.sumdu.labwork3.model.GoodsType;

import java.util.List;

public interface DaoGoodsType {
    void create(GoodsType goodsType);
    List<GoodsType> findAll();
}
