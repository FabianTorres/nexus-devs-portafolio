package com.fabian.service;

import java.util.List;

import com.fabian.model.Producto;
import com.fabian.repository.ProductoRepository;

public class ProductoService {
	
	private final ProductoRepository productoRepository;
	
    
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto crearProducto(Producto producto) {
    	// Validacion para el nombre
    	if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
    	
    	//No puede crear precio negativo
        if (producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }        
        
        return productoRepository.guardar(producto);
    }
    
    public List<Producto> listarProductos() {
        // Se devuelve la lista
        return productoRepository.buscarTodos();
    }
    
    public Producto actualizarProducto(Producto productoActualizado) {
    	productoRepository.actualizar(productoActualizado);
        return productoActualizado; 
    }
    
    public void eliminarProducto(Long id) {

    	productoRepository.eliminar(id);
    }
}