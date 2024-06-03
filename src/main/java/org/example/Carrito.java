package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    // Constructor que inicializa la lista de items
    public Carrito() {
        this.items = new ArrayList<>();
    }

    // Agrega un producto al carrito o incrementa la cantidad si ya existe
    public void agregarProducto(Producto producto, int cantidad) throws CantidadInvalidaException {
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad debe ser mayor que cero");
        }
        for (ItemCarrito item : items) {
            if (item.getProducto().getId().equals(producto.getId())) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad));
    }

    // Elimina un producto del carrito por su ID
    public void eliminarProducto(Producto producto) throws ProductoNoEncontradoException {
        boolean removed = items.removeIf(item -> item.getProducto().getId().equals(producto.getId()));
        if (!removed) {
            throw new ProductoNoEncontradoException("Producto no encontrado en el carrito");
        }
    }

    // Modifica la cantidad de un producto en el carrito o lo elimina si la cantidad es menor o igual a cero
    public void modificarCantidad(Producto producto, int cantidad) throws ProductoNoEncontradoException, CantidadInvalidaException {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId().equals(producto.getId())) {
                if (cantidad <= 0) {
                    items.remove(item);
                } else {
                    item.setCantidad(cantidad);
                }
                return;
            }
        }
        throw new ProductoNoEncontradoException("Producto no encontrado en el carrito");
    }

    // Calcula el total del precio de todos los productos en el carrito
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getTotal();
        }
        return total;
    }

    // Devuelve la lista de items en el carrito
    public List<ItemCarrito> getItems() {
        return items;
    }
}
