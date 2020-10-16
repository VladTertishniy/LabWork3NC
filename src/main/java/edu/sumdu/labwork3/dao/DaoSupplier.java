package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.Supplier;

import java.util.List;

public interface DaoSupplier {
    void insert(Supplier supplier);
    void update(Supplier supplier);
    void delete(Supplier supplier);
    List<Supplier> findAll();
    Supplier getById(int id);
}
