package com.github.dariozubaray.springboot.api.rest.models.services;

import com.github.dariozubaray.springboot.api.rest.models.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);
}
