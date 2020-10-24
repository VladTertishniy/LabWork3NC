package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    GoodsType insert(GoodsType goodsType);
    List<GoodsType> getAll();
    GoodsType update(GoodsType goodsType);
    void delete(int id);
    GoodsType getById(int id);
}
