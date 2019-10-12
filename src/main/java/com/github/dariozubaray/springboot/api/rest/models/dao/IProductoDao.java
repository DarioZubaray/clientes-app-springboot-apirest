package com.github.dariozubaray.springboot.api.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.dariozubaray.springboot.api.rest.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long>{

    @Query("select p from Producto p where p.nombre like %?1%")
    public List<Producto> findByNombre(String termino);

    public List<Producto> findByNombreContainingIgnoreCase(String termino);

    public List<Producto> findByNombreStartingWithIgnoreCase(String termino);
}
