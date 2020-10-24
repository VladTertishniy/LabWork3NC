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
    public Consumer insert(Consumer consumer) {
        return daoConsumer.insert(consumer);
    }

    @Override
    public List<Consumer> getAll() {
        return daoConsumer.findAll();
    }

    @Override
    public Consumer update(Consumer consumer) {
        return daoConsumer.update(consumer);
    }

    @Override
    public void delete(int id) {
        daoConsumer.delete(id);
    }

    @Override
    public Consumer getById(int id) {
        return daoConsumer.getById(id);
    }
}
