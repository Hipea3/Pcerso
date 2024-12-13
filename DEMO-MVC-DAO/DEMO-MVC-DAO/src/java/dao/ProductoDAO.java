/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Productos;

/**
 *
 * @author Marux
 */
public interface ProductoDAO {
    int save(Productos producto);
    
    int update(Productos producto);
    
    int delete(int idProducto);
    
    List<Productos> getAll();
    
    Productos getById(int idProducto);
    
}
