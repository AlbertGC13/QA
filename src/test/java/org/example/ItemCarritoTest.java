package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemCarritoTest {
    @Test
    public void testCrearItemCarrito() {
        Producto producto = new Producto("Manzana", 0.50);
        ItemCarrito item = new ItemCarrito(producto, 3);
        assertEquals(producto, item.getProducto());
        assertEquals(3, item.getCantidad());
        assertEquals(1.50, item.getTotal(), 0.01);
    }
}
