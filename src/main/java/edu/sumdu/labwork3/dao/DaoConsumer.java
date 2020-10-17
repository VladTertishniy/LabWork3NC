package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.Consumer;

import java.util.List;

public interface DaoConsumer {
    void insert(Consumer consumer);
    void update(Consumer consumer);
    void delete(Consumer consumer);
    List<Consumer> findAll();
    Consumer getById(int id);
}
