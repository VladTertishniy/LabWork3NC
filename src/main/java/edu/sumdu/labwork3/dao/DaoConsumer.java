package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.Consumer;

import java.util.List;

public interface DaoConsumer {
    Consumer insert(Consumer consumer);
    Consumer update(Consumer consumer);
    void delete(int id);
    List<Consumer> findAll();
    Consumer getById(int id);
}
