package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Consumer;

import java.util.List;

public interface ConsumerService {
    void insert(Consumer consumer);
    List<Consumer> getAll();
    void update(Consumer consumer);
    void delete(Consumer consumer);
    Consumer getById(int id);
}
