package com.fabian.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fabian.model.Producto;
import com.fabian.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class) 
class ProductoServiceTest {
	
    @Mock // Se crea un mock 
    private ProductoRepository productoRepository;
	
    @InjectMocks // Se inyecta el mock
    private ProductoService productoService;

    @Test
    void testCrearProducto() { // Nombre del test simplificado

        Producto productoSinId = new Producto(null, "Laptop Gamer", 1500.00, 10);
        Producto productoConId = new Producto(1L, "Laptop Gamer", 1500.00, 10);
        
        // Se dice al mock que hacer, cuando se llame a guardar, devuelve el producto con ID
        when(productoRepository.guardar(productoSinId)).thenReturn(productoConId);


        Producto productoCreado = productoService.crearProducto(productoSinId);


        assertNotNull(productoCreado);
        assertNotNull(productoCreado.getId());
        assertEquals("Laptop Gamer", productoCreado.getNombre());
        
        // Se verifica que el metodo al menos fue llamado una vez
        verify(productoRepository, times(1)).guardar(productoSinId);
    }
    
    @Test
    void testNoDebeCrearProductoConPrecioNegativo() {
        Producto productoConPrecioNegativo = new Producto(2L, "Producto Malo", -100.0, 20);

        // El servicio debe lanzar la excepcion antes de llamar al repositorio
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.crearProducto(productoConPrecioNegativo);
        });
        
        // Se comprueba que el metodo no se llamo
        verify(productoRepository, never()).guardar(any(Producto.class));
    }
    
    @Test
    void testNoDebeCrearProductoConNombreVacio() {
        Producto productoSinNombre = new Producto(3L, "", 50.0, 5);

     // El servicio debe lanzar la excepcion antes de llamar al repositorio
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.crearProducto(productoSinNombre);
        });
        
        verify(productoRepository, never()).guardar(any(Producto.class));
    }
    
    @Test
    void testListarProductosCuandoNoHayProductos() {
        
        // Se le dice al mock que entre lista vacia cuando no hay productos
        when(productoRepository.buscarTodos()).thenReturn(new ArrayList<>());

        List<Producto> productos = productoService.listarProductos();

        assertNotNull(productos);
        assertTrue(productos.isEmpty());
    }
    
    @Test
    void testListarProductosDevuelveTodosLosProductos() {
        // Se crea lista falsa y le dice al mock que la devuelva
        List<Producto> listaFalsa = List.of(
            new Producto(1L, "Teclado", 120.0, 50),
            new Producto(2L, "Mouse", 45.0, 100)
        );
        when(productoRepository.buscarTodos()).thenReturn(listaFalsa);
        
        List<Producto> productos = productoService.listarProductos();

        assertNotNull(productos);
        assertEquals(2, productos.size());
    }
    
    @Test
    void testActualizarProductoExistente() {
        Producto productoActualizado = new Producto(1L, "Monitor Curvo 24", 350.0, 25);

        productoService.actualizarProducto(productoActualizado);

        // Se verifica que el mock fue llamado con el producto correcto
        verify(productoRepository, times(1)).actualizar(productoActualizado);
    }
    
    @Test
    void testActualizarProductoInexistente() {
        Producto productoQueNoExiste = new Producto(99L, "Producto Fantasma", 10.0, 10);
        // El mock debe tirar una excepcion cuando se intente actualizar este producto
        doThrow(new RuntimeException("Producto no encontrado")).when(productoRepository).actualizar(productoQueNoExiste);

        // Se verifica que el servicio maneje bien la excepcion del repositorio
        assertThrows(RuntimeException.class, () -> {
            productoService.actualizarProducto(productoQueNoExiste);
        });
    }
    
    @Test
    void testEliminarProductoExistente() {
        Long idParaEliminar = 1L;

        productoService.eliminarProducto(idParaEliminar);

        // Se verifica que el metodo es llamado con el id correcto
        verify(productoRepository, times(1)).eliminar(idParaEliminar);
    }
}