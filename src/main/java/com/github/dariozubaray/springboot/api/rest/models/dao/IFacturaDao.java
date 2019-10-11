package com.github.dariozubaray.springboot.api.rest.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.github.dariozubaray.springboot.api.rest.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}
