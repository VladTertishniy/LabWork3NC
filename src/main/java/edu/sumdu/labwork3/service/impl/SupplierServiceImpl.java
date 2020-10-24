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
    public Supplier insert(Supplier supplier) {
        return daoSupplier.insert(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return daoSupplier.findAll();
    }

    @Override
    public Supplier update(Supplier supplier) {
        return daoSupplier.update(supplier);
    }

    @Override
    public void delete(int id) {
        daoSupplier.delete(id);
    }

    @Override
    public Supplier getById(int id) {
        return daoSupplier.getById(id);
    }
}
