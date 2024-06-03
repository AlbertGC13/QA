Este tarea se utiliza Junit en un carrito de compras en Java. Permite agregar, eliminar y modificar productos en el carrito, así como calcular el total de la compra, garantizando la correcta funcionalidad de las clases `Producto`, `ItemCarrito` y `Carrito`.

## Estructura del Proyecto

- `Producto.java`: Clase que representa un producto con un nombre, precio y un identificador único.
- `ItemCarrito.java`: Clase que representa un ítem en el carrito, que incluye un producto y su cantidad.
- `Carrito.java`: Clase que maneja la lógica del carrito de compras, incluyendo agregar, eliminar y modificar productos, y calcular el total de la compra.
- `CantidadInvalidaException.java`: Excepción personalizada para manejar cantidades inválidas.
- `ProductoNoEncontradoException.java`: Excepción personalizada para manejar casos en los que un producto no se encuentra en el carrito.

## Pruebas Unitarias

El proyecto incluye pruebas unitarias para todas las clases principales:

- `ProductoTest.java`: Pruebas para la clase `Producto`.
- `ItemCarritoTest.java`: Pruebas para la clase `ItemCarrito`.
- `CarritoTest.java`: Pruebas para la clase `Carrito`.

## Requisitos

- Java Development Kit (JDK) 21
- JUnit 4

## Instalación y Ejecución

1. **Clonar el repositorio**:
    ```sh
    git clone https://github.com/AlbertGC13/QA.git
    cd QA
    ```

2. **Compilar el proyecto y ejecutar las pruebas unitarias**:
    ```sh
    mvn test
    ```
