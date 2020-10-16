package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Supplier;

import java.util.List;

public interface SupplierService {
    void insert(Supplier supplier);
    List<Supplier> getAll();
    void update(Supplier supplier);
    void delete(Supplier supplier);
    Supplier getById(int id);
}
