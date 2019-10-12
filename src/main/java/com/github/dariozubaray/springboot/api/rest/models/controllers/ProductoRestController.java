package com.github.dariozubaray.springboot.api.rest.models.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.dariozubaray.springboot.api.rest.models.entity.Producto;
import com.github.dariozubaray.springboot.api.rest.models.services.IProductoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductoRestController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> index() {
        return productoService.findAll();
    }

    @GetMapping("/productos/page/{pagina}")
    public Page<Producto> index(@PathVariable Integer pagina) {
        return productoService.findAll(PageRequest.of(pagina, 5));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/productos/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Producto producto =  null;
        Map<String, Object> response = new HashMap<>();

        try {
            producto = productoService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al ejecutar la consulta en la BD");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(producto == null) {
            response.put("mensaje", "El producto con el ID " + id + " no existe en la BD");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/productos")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Producto producto, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo '" + err.getField() + " '" + err.getDefaultMessage())
                                        .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        Producto productoCreado =  null;

        try {
            productoCreado = productoService.save(producto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al ejecutar la actualización de producto en la BD");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido creado con éxito");
        response.put("producto", productoCreado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/productos/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> update(@Valid @RequestBody Producto producto, BindingResult result, @PathVariable Long id) {
        Producto productoActualizado = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo '" + err.getField() + " '" + err.getDefaultMessage())
                                        .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Producto productoDB = null;
        try {
            productoDB = productoService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al ejecutar la consulta de producto en la BD");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(productoDB == null) {
            response.put("mensaje", "El producto con el ID " + id + " no existe en la BD");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        if (producto.getNombre() != null) {
            productoDB.setNombre(producto.getNombre());
        }
        if (producto.getPrecio() != null) {
            productoDB.setPrecio(producto.getPrecio());
        }
        if (producto.getCreateAt() != null) {
            productoDB.setCreateAt(producto.getCreateAt());
        }

        try {
            productoActualizado = productoService.save(productoDB);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al ejecutar la actualización de producto en la BD");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido actualizado con éxito");
        response.put("producto", productoActualizado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            productoService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al ejecutar la eliminación de producto en la BD");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido eliminado con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
