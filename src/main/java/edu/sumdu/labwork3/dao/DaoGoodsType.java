package edu.sumdu.labwork3.dao;


import edu.sumdu.labwork3.model.GoodsType;

import java.util.List;

public interface DaoGoodsType {
    GoodsType insert(GoodsType goodsType);
    GoodsType update(GoodsType goodsType);
    void delete(int id);
    List<GoodsType> findAll();
    GoodsType getById(int id);
}
