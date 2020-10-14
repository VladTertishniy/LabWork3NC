package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    void insert(GoodsType goodsType);
    List<GoodsType> getAll();
    void update(GoodsType goodsType);
    void delete(GoodsType goodsType);
    GoodsType getById(int id);
}
