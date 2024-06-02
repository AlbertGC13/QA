package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarritoTest {
    private Carrito carrito;
    private Producto manzana;
    private Producto banana;

    @Before
    public void setUp() {
        carrito = new Carrito();
        manzana = new Producto("Manzana", 0.50);
        banana = new Producto("Banana", 0.30);
    }

    @Test
    public void testAgregarProducto() {
        carrito.agregarProducto(manzana, 4);
        assertEquals(1, carrito.getItems().size());
        assertEquals(2.00, carrito.calcularTotal(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarProductoConCantidadInvalida() {
        carrito.agregarProducto(manzana, -10);
    }

    @Test
    public void testAgregarProductoExistente() {
        carrito.agregarProducto(manzana, 3);
        carrito.agregarProducto(manzana, 2);
        assertEquals(1, carrito.getItems().size());
        assertEquals(5, carrito.getItems().get(0).getCantidad());
        assertEquals(2.50, carrito.calcularTotal(), 0.01);
    }

    @Test
    public void testEliminarProducto() throws ProductoNoEncontradoException {
        carrito.agregarProducto(manzana, 3);
        carrito.eliminarProducto(manzana);
        assertEquals(0, carrito.getItems().size());
    }

    @Test(expected = ProductoNoEncontradoException.class)
    public void testEliminarProductoNoExistente() throws ProductoNoEncontradoException {
        carrito.eliminarProducto(banana);
    }

    @Test
    public void testModificarCantidad() throws ProductoNoEncontradoException {
        carrito.agregarProducto(manzana, 3);
        carrito.modificarCantidad(manzana, 5);
        assertEquals(5, carrito.getItems().get(0).getCantidad());
    }

    @Test(expected = ProductoNoEncontradoException.class)
    public void testModificarCantidadProductoNoExistente() throws ProductoNoEncontradoException {
        carrito.modificarCantidad(banana, 2);
    }

    @Test
    public void testModificarCantidadNegativa() throws ProductoNoEncontradoException {
        carrito.agregarProducto(manzana, 3);
        carrito.modificarCantidad(manzana, -1);
        assertEquals(0, carrito.getItems().size());
    }

    @Test
    public void testCalcularTotal() {
        carrito.agregarProducto(manzana, 3);
        carrito.agregarProducto(banana, 2);
        assertEquals(2.10, carrito.calcularTotal(), 0.01);
    }
}