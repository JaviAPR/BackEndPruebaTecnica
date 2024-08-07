package com.backend.backendPruMacondo.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.backend.backendPruMacondo.DTO.ProductoDTO;
import com.backend.backendPruMacondo.Repository.ProductoRepository;
import com.backend.backendPruMacondo.Repository.Entity.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public Page<ProductoEntity> findAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productoRepository.findAll(pageable);
    }
    public ProductoDTO findById(int id){
       try {
        Optional<ProductoEntity> productoOptional = productoRepository.findById(id);
        ProductoEntity productoEntity = productoOptional.get();
        
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre(productoEntity.getNombre());
        productoDTO.setDescripcion(productoEntity.getDescripcion());
        productoDTO.setPrecio(productoEntity.getPrecio());
        productoDTO.setCategoria(productoEntity.getCategoria());
        
        return productoDTO;
        
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
        
    }
     public Page<ProductoEntity> findByNombrePaginated(String nombre, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productoRepository.findByNombreQuery(nombre, pageable);
    }

    public ProductoEntity save(ProductoEntity productoEntity){
        return productoRepository.save(productoEntity);
    }

    public ProductoEntity update(int id,ProductoEntity productoActualizado){
        ProductoEntity productoExistente;
        Optional<ProductoEntity> productoOptional = productoRepository.findById(id);
        
        if (productoOptional.isPresent()) {
            productoExistente = productoOptional.get();
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setPrecio(productoActualizado.getPrecio());
            return productoRepository.save(productoExistente);
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }

    public String deleteById(int id){
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return "El producto ha sido eliminado";
        } else {
            return "No se encontró ningún producto con id: " + id;
        }
    }

}
