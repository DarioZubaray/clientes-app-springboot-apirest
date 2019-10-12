package com.github.dariozubaray.springboot.api.rest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.dariozubaray.springboot.api.rest.models.entity.Producto;

public interface IProductoService {

    public List<Producto> findAll();

    public Page<Producto> findAll(Pageable pageable);

    public Producto findById(Long id);

    public Producto save(Producto cliente);

    public void delete(Long id);
}
