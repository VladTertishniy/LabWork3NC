package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Goods;

import java.util.List;

public interface GoodsService {
    Goods insert(Goods goods);
    List<Goods> getAll();
    Goods update(Goods goods);
    void delete(int id);
    Goods getById(int id);
}
