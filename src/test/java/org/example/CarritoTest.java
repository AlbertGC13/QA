package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarritoTest {
    private Carrito carrito;
    private Producto manzana;
    private Producto banana;

    // Configuración inicial antes de cada test
    @Before
    public void setUp() {
        carrito = new Carrito();
        manzana = new Producto("Manzana", 0.50);
        banana = new Producto("Banana", 0.30);
    }

    // Prueba para agregar un producto al carrito
    @Test
    public void testAgregarProducto() throws CantidadInvalidaException {
        carrito.agregarProducto(manzana, 4);
        assertEquals(1, carrito.getItems().size());
        assertEquals(2.00, carrito.calcularTotal(), 0.01);
    }

    // Prueba para agregar un producto con una cantidad inválida
    @Test(expected = CantidadInvalidaException.class)
    public void testAgregarProductoConCantidadInvalida() throws CantidadInvalidaException {
        carrito.agregarProducto(manzana, -1);
    }

    // Prueba para agregar una cantidad adicional de un producto existente
    @Test
    public void testAgregarProductoExistente() throws CantidadInvalidaException {
        carrito.agregarProducto(manzana, 3);
        carrito.agregarProducto(manzana, 2);
        assertEquals(1, carrito.getItems().size());
        assertEquals(5, carrito.getItems().get(0).getCantidad());
        assertEquals(2.50, carrito.calcularTotal(), 0.01);
    }

    // Prueba para eliminar un producto del carrito
    @Test
    public void testEliminarProducto() throws ProductoNoEncontradoException, CantidadInvalidaException {
        carrito.agregarProducto(manzana, 3);
        carrito.eliminarProducto(manzana);
        assertEquals(0, carrito.getItems().size());
    }

    // Prueba para intentar eliminar un producto que no existe en el carrito
    @Test(expected = ProductoNoEncontradoException.class)
    public void testEliminarProductoNoExistente() throws ProductoNoEncontradoException {
        carrito.eliminarProducto(banana);
    }

    // Prueba para modificar la cantidad de un producto en el carrito
    @Test
    public void testModificarCantidad() throws ProductoNoEncontradoException, CantidadInvalidaException {
        carrito.agregarProducto(manzana, 3);
        carrito.modificarCantidad(manzana, 5);
        assertEquals(5, carrito.getItems().get(0).getCantidad());
    }

    // Prueba para intentar modificar la cantidad de un producto que no existe en el carrito
    @Test(expected = ProductoNoEncontradoException.class)
    public void testModificarCantidadProductoNoExistente() throws ProductoNoEncontradoException, CantidadInvalidaException {
        carrito.modificarCantidad(banana, 2);
    }

    // Prueba para modificar la cantidad de un producto a una cantidad negativa, lo que debería eliminar el producto
    @Test
    public void testModificarCantidadNegativa() throws ProductoNoEncontradoException, CantidadInvalidaException {
        carrito.agregarProducto(manzana, 3);
        carrito.modificarCantidad(manzana, -1);
        assertEquals(0, carrito.getItems().size());
    }

    // Prueba para calcular el total de los productos en el carrito
    @Test
    public void testCalcularTotal() throws CantidadInvalidaException {
        carrito.agregarProducto(manzana, 3);
        carrito.agregarProducto(banana, 2);
        assertEquals(2.10, carrito.calcularTotal(), 0.01);
    }
}
