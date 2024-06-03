package org.example;

import java.util.UUID;

public class Producto {
    private String id;
    private String nombre;
    private double precio;

    // Constructor que inicializa el producto con un nombre y un precio, y genera un ID único
    public Producto(String nombre, double precio) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.precio = precio;
    }

    // Devuelve el ID del producto
    public String getId() {
        return id;
    }

    // Devuelve el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Devuelve el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Establece un nuevo nombre para el producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Establece un nuevo precio para el producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
