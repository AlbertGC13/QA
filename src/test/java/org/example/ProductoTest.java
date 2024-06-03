package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTest {

    // Prueba para crear un producto con nombre y precio válidos
    @Test
    public void testCrearProducto() {
        Producto producto = new Producto("Manzana", 0.50);
        assertEquals("Manzana", producto.getNombre());
        assertEquals(0.50, producto.getPrecio(), 0.01);
        assertNotNull(producto.getId());
    }

    // Prueba para cambiar el nombre de un producto
    @Test
    public void testSetNombre() {
        Producto producto = new Producto("Manzana", 0.50);
        producto.setNombre("Banana");
        assertEquals("Banana", producto.getNombre());
    }

    // Prueba para cambiar el precio de un producto
    @Test
    public void testSetPrecio() {
        Producto producto = new Producto("Manzana", 0.50);
        producto.setPrecio(0.75);
        assertEquals(0.75, producto.getPrecio(), 0.01);
    }
}
