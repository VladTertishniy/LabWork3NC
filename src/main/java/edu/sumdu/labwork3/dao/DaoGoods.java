package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.Goods;

import java.util.List;

public interface DaoGoods {
    void insert(Goods goods);
    void update(Goods goods);
    void delete(Goods goods);
    List<Goods> findAll();
    Goods getById(int id);
}
