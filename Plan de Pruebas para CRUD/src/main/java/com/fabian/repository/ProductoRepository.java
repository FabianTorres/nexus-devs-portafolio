package com.fabian.repository;

import java.util.List;

import com.fabian.model.Producto;

public interface ProductoRepository {
    Producto guardar(Producto producto);
    List<Producto> buscarTodos();
    void actualizar(Producto producto);
    void eliminar(Long id);
}