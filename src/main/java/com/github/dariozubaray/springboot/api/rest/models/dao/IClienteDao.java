package com.github.dariozubaray.springboot.api.rest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.dariozubaray.springboot.api.rest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

}
