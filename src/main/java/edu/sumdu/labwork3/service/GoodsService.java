package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Goods;

import java.util.List;

public interface GoodsService {
    void insert(Goods goods);
    List<Goods> getAll();
    void update(Goods goods);
    void delete(Goods goods);
    Goods getById(int id);
}
