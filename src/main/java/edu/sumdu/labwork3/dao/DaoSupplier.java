package edu.sumdu.labwork3.dao;

import edu.sumdu.labwork3.model.Supplier;

import java.util.List;

public interface DaoSupplier {
    Supplier insert(Supplier supplier);
    Supplier update(Supplier supplier);
    void delete(int id);
    List<Supplier> findAll();
    Supplier getById(int id);
}
