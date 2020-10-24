package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.Goods;

import java.util.List;

public interface DaoGoods {
    Goods insert(Goods goods);
    Goods update(Goods goods);
    void delete(int id);
    List<Goods> findAll();
    Goods getById(int id);
}
