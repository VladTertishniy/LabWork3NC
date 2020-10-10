package edu.sumdu.labwork3.dao;


import edu.sumdu.labwork3.model.GoodsType;

import java.util.List;

public interface DaoGoodsType {
    void insert(GoodsType goodsType);
    void update(GoodsType goodsType);
    void delete(GoodsType goodsType);
    List<GoodsType> findAll();
}
