package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTest {
    @Test
    public void testCrearProducto() {
        Producto producto = new Producto("Manzana", 0.50);
        assertEquals("Manzana", producto.getNombre());
        assertEquals(0.50, producto.getPrecio(), 0.01);
    }
}
