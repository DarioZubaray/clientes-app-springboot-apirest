package com.github.dariozubaray.springboot.api.rest.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.github.dariozubaray.springboot.api.rest.models.entity.Factura;
import com.github.dariozubaray.springboot.api.rest.models.entity.Producto;
import com.github.dariozubaray.springboot.api.rest.models.services.IClienteService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
public class FacturaRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/facturas/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Factura show(@PathVariable Long id) {
        return clienteService.findFacturaById(id);
    }

    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteService.deleteFactura(id);
    }
    
    @GetMapping("/facturas/filtrar-productos/{termino}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String termino) {
        return clienteService.findProductoByNombre(termino);
    }

    @PostMapping("/facturas")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura) {
        return clienteService.saveFactura(factura);
    }
}
