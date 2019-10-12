package com.github.dariozubaray.springboot.api.rest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.dariozubaray.springboot.api.rest.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long>{

}
