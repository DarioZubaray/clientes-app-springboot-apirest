package com.github.dariozubaray.springboot.api.rest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dariozubaray.springboot.api.rest.models.dao.IProductoDao;
import com.github.dariozubaray.springboot.api.rest.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {


    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public Page<Producto> findAll(Pageable pageable) {
        return productoDao.findAll(pageable);
    }

    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto save(Producto cliente) {
        return productoDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoDao.deleteById(id);
    }

}
