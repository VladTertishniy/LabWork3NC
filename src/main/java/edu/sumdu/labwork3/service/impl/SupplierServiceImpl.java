package edu.sumdu.labwork3.service.impl;

import edu.sumdu.labwork3.dao.DaoSupplier;
import edu.sumdu.labwork3.model.Supplier;
import edu.sumdu.labwork3.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final DaoSupplier daoSupplier;

    public SupplierServiceImpl(DaoSupplier daoSupplier) {
        this.daoSupplier = daoSupplier;
    }

    @Override
    public void insert(Supplier supplier) {
        daoSupplier.insert(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return daoSupplier.findAll();
    }

    @Override
    public void update(Supplier supplier) {
        daoSupplier.update(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        daoSupplier.delete(supplier);
    }

    @Override
    public Supplier getById(int id) {
        return daoSupplier.getById(id);
    }
}
