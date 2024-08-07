package com.backend.backendPruMacondo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backendPruMacondo.Repository.Entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {
    @Query("SELECT p FROM ProductoEntity p WHERE p.nombre LIKE %:nombre%")
    Page<ProductoEntity> findByNombreQuery(@Param("nombre") String nombre, Pageable pageable);

    
}
