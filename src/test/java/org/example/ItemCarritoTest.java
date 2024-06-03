package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemCarritoTest {

    // Prueba para crear un item del carrito con un producto y cantidad válidos
    @Test
    public void testCrearItemCarrito() throws CantidadInvalidaException {
        Producto producto = new Producto("Manzana", 0.50);
        ItemCarrito item = new ItemCarrito(producto, 3);
        assertEquals(producto, item.getProducto());
        assertEquals(3, item.getCantidad());
        assertEquals(1.50, item.getTotal(), 0.01);
    }

    // Prueba para establecer una nueva cantidad en un item del carrito
    @Test
    public void testSetCantidad() throws CantidadInvalidaException {
        Producto producto = new Producto("Manzana", 0.50);
        ItemCarrito item = new ItemCarrito(producto, 3);
        item.setCantidad(5);
        assertEquals(5, item.getCantidad());
    }

    // Prueba para calcular el total después de cambiar la cantidad de un producto en el item del carrito
    @Test
    public void testGetTotalDespuesDeCambiarCantidad() throws CantidadInvalidaException {
        Producto producto = new Producto("Manzana", 0.50);
        ItemCarrito item = new ItemCarrito(producto, 3);
        item.setCantidad(5);
        assertEquals(2.50, item.getTotal(), 0.01);
    }

    // Prueba para asegurar que el producto en un item del carrito no es nulo
    @Test
    public void testProductoNoNull() throws CantidadInvalidaException {
        Producto producto = new Producto("Manzana", 0.50);
        ItemCarrito item = new ItemCarrito(producto, 3);
        assertNotNull(item.getProducto());
    }

    // Prueba para manejar una cantidad inválida en el constructor de ItemCarrito
    @Test(expected = CantidadInvalidaException.class)
    public void testCantidadInvalida() throws CantidadInvalidaException {
        Producto producto = new Producto("Manzana", 0.50);
        ItemCarrito item = new ItemCarrito(producto, -1);
    }
}
