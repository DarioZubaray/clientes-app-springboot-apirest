package com.github.dariozubaray.springboot.api.rest.models.services;

import java.util.List;
import com.github.dariozubaray.springboot.api.rest.models.entity.Cliente;

public interface IClienteService {

    public List<Cliente> findAll();
}
