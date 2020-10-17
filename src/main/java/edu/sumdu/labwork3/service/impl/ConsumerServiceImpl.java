package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoConsumer;
import edu.sumdu.labwork3.model.Consumer;
import edu.sumdu.labwork3.service.ConsumerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final DaoConsumer daoConsumer;

    public ConsumerServiceImpl(DaoConsumer daoConsumer) {
        this.daoConsumer = daoConsumer;
    }

    @Override
    public void insert(Consumer consumer) {
        daoConsumer.insert(consumer);
    }

    @Override
    public List<Consumer> getAll() {
        return daoConsumer.findAll();
    }

    @Override
    public void update(Consumer consumer) {
        daoConsumer.update(consumer);
    }

    @Override
    public void delete(Consumer consumer) {
        daoConsumer.delete(consumer);
    }

    @Override
    public Consumer getById(int id) {
        return daoConsumer.getById(id);
    }
}
