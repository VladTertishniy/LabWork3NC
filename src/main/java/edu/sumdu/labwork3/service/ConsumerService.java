package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Consumer;

import java.util.List;

public interface ConsumerService {
    Consumer insert(Consumer consumer);
    List<Consumer> getAll();
    Consumer update(Consumer consumer);
    void delete(int id);
    Consumer getById(int id);
}
