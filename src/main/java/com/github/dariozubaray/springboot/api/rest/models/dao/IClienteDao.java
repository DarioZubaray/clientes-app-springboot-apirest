package com.github.dariozubaray.springboot.api.rest.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.github.dariozubaray.springboot.api.rest.models.entity.Cliente;
import com.github.dariozubaray.springboot.api.rest.models.entity.Region;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

    @Query("from Region")
    public List<Region> findAllRegiones();
}
