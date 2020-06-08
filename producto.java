
package com.emergente.modelo;

public class producto {
    private int id;
    private String descripcion;
    private String stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "aviso{" + "id=" + id + ", descripcion=" + descripcion + ", stock=" + stock + '}';
    }
    
    
    
}
