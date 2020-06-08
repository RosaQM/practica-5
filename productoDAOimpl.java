package com.emergentes.dao;

import com.emergente.modelo.producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productoDAOimpl extends ConexionDB implements productoDAO{
    @Override
    public void insert(producto Producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into productos (descripcion, stock) values (?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, Producto.getDescripcion());
            ps.setString(2, Producto.getStock());
            ps.executeUpdate(sql);    
        } catch (Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }
    @Override
    public void update(producto Producto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos set descripcion=?, stock=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, Producto.getDescripcion());
            ps.setString(2, Producto.getStock());
            ps.setInt(3, Producto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    @Override
    public void delete(int id) throws Exception {
         try {
            this.conectar();
            String sql = "DELETE from productos where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    @Override
    public producto getById(int id) throws Exception {
        producto pro = new producto();
        try {
            this.conectar();
            String sql = "SELECT * from productos where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                pro.setId(rs.getInt("id"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setStock(rs.getString("stock"));               
            }            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return pro;
    }
    @Override
    public List<producto> getAll() throws Exception {
        List<producto> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * from productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<producto>();
            while(rs.next())
            {
                producto pro = new producto();
                pro.setId(rs.getInt("id"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setStock(rs.getString("stock"));
                lista.add(pro);
            }
        } catch (Exception e) {
        }finally{
            this.desconectar();
        }
        return lista;
    }
}

