package com.mateomontero.pokepabellon.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private double precio;
    private String descripcion;
    private int id;
    private double size;
    private int cantidad_en_stock;
    public Producto(String nombre, double precio, String descripcion, int id, double size, int cantidad_en_stock) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.id = id;
        this.size = size;
        this.cantidad_en_stock = cantidad_en_stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getCantidad_en_stock() {
        return cantidad_en_stock;
    }

    public void setCantidad_en_stock(int cantidad_en_stock) {
        this.cantidad_en_stock = cantidad_en_stock;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
