package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    /**
     Agrega un producto al carrito. Si el producto ya existe, incrementa la cantidad.
     @throws IllegalArgumentException si la cantidad es menor o igual a cero.
     */
    public void agregarProducto(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        for (ItemCarrito item : items) {
            if (item.getProducto().equals(producto)) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad));
    }

    /**
     Elimina un producto del carrito.
     @throws ProductoNoEncontradoException si el producto no se encuentra en el carrito.
     */
    public void eliminarProducto(Producto producto) throws ProductoNoEncontradoException {
        boolean removed = items.removeIf(item -> item.getProducto().equals(producto));
        if (!removed) {
            throw new ProductoNoEncontradoException("Producto no encontrado en el carrito");
        }
    }

    /**
     Modifica la cantidad de un producto en el carrito.
     Si la cantidad es menor o igual a cero, elimina el producto del carrito.
     */
    public void modificarCantidad(Producto producto, int cantidad) throws ProductoNoEncontradoException {
        for (ItemCarrito item : items) {
            if (item.getProducto().equals(producto)) {
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

    /**
     * Calcula el total de la compra en el carrito.
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getTotal();
        }
        return total;
    }

    /**
     * Obtiene los items en el carrito.+
     */
    public List<ItemCarrito> getItems() {
        return items;
    }
}
