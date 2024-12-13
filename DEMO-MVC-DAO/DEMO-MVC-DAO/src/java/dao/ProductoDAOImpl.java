/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;
/**
 *
 * @author Marux
 */
public class ProductoDAOImpl implements ProductoDAO{
    private String sql = "";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public int save(Productos producto) {
       int row = 0;
       sql = "INSERT INTO productos (nombre, categoria, cantidad) VALUES (?, ?, ?)";
       connection = DBConnection.getConnection();
       try{
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, producto.getNombre());
           preparedStatement.setString(2, producto.getCategoria());
           preparedStatement.setInt(3, producto.getCantidad());
           row = preparedStatement.executeUpdate();
           preparedStatement.close();
           connection.close();
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
       return row;
    }

    @Override
    public int update(Productos producto) {
    
        int row = 0;
        
        sql = "UPDATE productos SET nombre = ?, categoria = ?, cantidad = ? WHERE id = ?";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setString(2, producto.getCategoria());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setInt(4, producto.getId());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(int idProducto) {
        
        int row = 0;
        sql = "DELETE FROM productos WHERE id = ?";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProducto);
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return row;
        
    }

    @Override
    public List<Productos> getAll() {
        List<Productos> list = new ArrayList();
        sql = "SELECT * FROM productos";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Productos producto = new Productos();
                producto.setId(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setCategoria(resultSet.getString(3));
                producto.setCantidad(resultSet.getInt(4));
                list.add(producto);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Productos getById(int idProducto) {
        Productos producto = null;
        sql = "SELECT * FROM productos WHERE id = ?";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProducto);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                producto = new Productos();
                producto.setId(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setCategoria(resultSet.getString(3));
                producto.setCantidad(resultSet.getInt(4));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return producto;
    }
    
}
