package com.fabian.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fabian.model.Producto;

public class ProductoRepositoryImpl implements ProductoRepository {

    private Connection getConnection() throws SQLException {
        // H2 en memoria
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    }

    @Override
    public Producto guardar(Producto producto) {
        String sql = "INSERT INTO productos(nombre, precio, cantidad) VALUES(?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getCantidad());
            pstmt.executeUpdate();

            // Obtenemos el id generado por la base de datos
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    producto.setId(generatedKeys.getLong(1));
                }
            }
            return producto;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el producto", e);
        }
    }

    @Override
    public List<Producto> buscarTodos() {
        String sql = "SELECT * FROM productos";
        List<Producto> productos = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                productos.add(new Producto(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar los productos", e);
        }
        return productos;
    }

    @Override
    public void actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getCantidad());
            pstmt.setLong(4, producto.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el producto", e);
        }
    }

    @Override
    public void eliminar(Long id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el producto", e);
        }
    }
}