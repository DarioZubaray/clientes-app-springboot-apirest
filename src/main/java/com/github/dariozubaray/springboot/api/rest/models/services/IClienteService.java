package com.github.dariozubaray.springboot.api.rest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.dariozubaray.springboot.api.rest.models.entity.Cliente;
import com.github.dariozubaray.springboot.api.rest.models.entity.Factura;
import com.github.dariozubaray.springboot.api.rest.models.entity.Region;

public interface IClienteService {

    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public Cliente findById(Long id);

    public Cliente save(Cliente cliente);

    public void delete(Long id);

    public List<Region> findAllRegiones();

    public Factura findFacturaById(Long id);

    public Factura saveFactura(Factura factura);

    public void deleteFactura(Long id);
}
