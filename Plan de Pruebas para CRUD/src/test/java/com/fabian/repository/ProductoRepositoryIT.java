package com.fabian.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fabian.model.Producto;

class ProductoRepositoryIT {

    private ProductoRepository productoRepository = new ProductoRepositoryImpl();

    // Ante sde cada prueba para asegurarse de una base de datos limpia
    @BeforeEach
    void setUp() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS productos (" +
                                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                                "nombre VARCHAR(255)," +
                                "precio DOUBLE," +
                                "cantidad INT)";
        String deleteDataSQL = "DELETE FROM productos";

        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            stmt.execute(deleteDataSQL); // Se limpian los datos
        }
    }

    @Test
    void testGuardarYBuscarTodos() {
        Producto nuevoProducto = new Producto(null, "Silla Gamer", 300.0, 15);

        productoRepository.guardar(nuevoProducto);
        List<Producto> productos = productoRepository.buscarTodos();

        assertFalse(productos.isEmpty());
        assertEquals(1, productos.size());
        assertEquals("Silla Gamer", productos.get(0).getNombre());
    }
    
    @Test
    void testActualizarProducto() {
        // Se guarda un producto inicial
        Producto productoOriginal = productoRepository.guardar(new Producto(null, "Monitor Viejo", 100.0, 10));
        
        // Se crea el objeto con los datos nuevos
        Producto productoConCambios = new Producto(productoOriginal.getId(), "Monitor Nuevo 4K", 199.00, 8);

        // Ejecuta la actualizacion
        productoRepository.actualizar(productoConCambios);
        
        // Buscamos de nuevo
        List<Producto> productos = productoRepository.buscarTodos();

        assertEquals(1, productos.size());
        Producto productoActualizado = productos.get(0);
        
        assertEquals("Monitor Nuevo 4K", productoActualizado.getNombre());
        assertEquals(199.00, productoActualizado.getPrecio());
    }

    @Test
    void testEliminarProducto() {
        // Se guarda un producto para que exista
        Producto productoAEliminar = productoRepository.guardar(new Producto(null, "Producto Descartable", 1.0, 1));
        Long id = productoAEliminar.getId();
        
        // Se elimina
        productoRepository.eliminar(id);
        
        // Se busca
        List<Producto> productos = productoRepository.buscarTodos();
        
        assertTrue(productos.isEmpty());
    }
}