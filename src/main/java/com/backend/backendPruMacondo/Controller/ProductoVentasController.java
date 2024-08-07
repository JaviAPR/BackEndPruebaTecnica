package com.backend.backendPruMacondo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backendPruMacondo.DTO.ProductoDTO;
import com.backend.backendPruMacondo.Repository.Entity.ProductoEntity;
import com.backend.backendPruMacondo.Service.ProductoService;
import org.springframework.data.domain.Page;



@RestController
@RequestMapping("/negocio")
public class ProductoVentasController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public Page<ProductoEntity> getAllProductos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return productoService.findAllPaginated(page, size);
    }

    @GetMapping("/producto/{id}")
    public ProductoDTO getProductById(@PathVariable int id) {
        return productoService.findById(id);
    }

    @GetMapping("/search/{nombre}")
    public Page<ProductoEntity> searchProductos(
            @PathVariable String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return productoService.findByNombrePaginated(nombre, page, size);
    }

    @PostMapping("/registrar")
    public ProductoEntity save(@RequestBody ProductoEntity productoEntity) {
        return productoService.save(productoEntity);
    }

    @PutMapping("/actualizar/{id}")
    public ProductoEntity update(@PathVariable int id, @RequestBody ProductoEntity productoEntity) {
        return productoService.update(id, productoEntity);
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteById(@PathVariable int id) {
        return productoService.deleteById(id);
    }
}