
package com.emergentes.dao;

import com.emergente.modelo.producto;
import java.util.List;

public interface productoDAO {
    public void insert(producto Producto) throws Exception;
    public void update(producto Producto) throws Exception;
    public void delete(int id) throws Exception;
    public producto getById(int id) throws Exception;
    public List<producto> getAll() throws Exception;
}
