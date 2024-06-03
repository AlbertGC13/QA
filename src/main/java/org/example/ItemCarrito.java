package org.example;

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    // Constructor que inicializa el item con un producto y una cantidad
    public ItemCarrito(Producto producto, int cantidad) throws CantidadInvalidaException {
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad debe ser mayor que cero");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Devuelve el producto del item
    public Producto getProducto() {
        return producto;
    }

    // Devuelve la cantidad del producto en el item
    public int getCantidad() {
        return cantidad;
    }

    // Establece una nueva cantidad para el producto en el item
    public void setCantidad(int cantidad) throws CantidadInvalidaException {
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad debe ser mayor que cero");
        }
        this.cantidad = cantidad;
    }

    // Calcula el total del precio del producto en el item
    public double getTotal() {
        return producto.getPrecio() * cantidad;
    }
}
