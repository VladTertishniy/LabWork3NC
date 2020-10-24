package edu.sumdu.labwork3.service;

import edu.sumdu.labwork3.model.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier insert(Supplier supplier);
    List<Supplier> getAll();
    Supplier update(Supplier supplier);
    void delete(int id);
    Supplier getById(int id);
}
