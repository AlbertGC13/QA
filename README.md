# Automatización de Pruebas con Playwright y Vaadin

Este proyecto implementa una aplicación web simple utilizando Vaadin y Playwright para la automatización de pruebas. La aplicación incluye vistas para inicio de sesión, formulario de registro y gestión de notas.

## Estructura del Proyecto

- **Vistas**
  - `LoginView.java`: Vista de inicio de sesión con 2 campos para nombre de usuario y contraseña, y un botón para enviar.
  - `RegistroView.java`: Vista de formulario de contacto con 3 campos para nombre, correo electrónico y mensaje, y un botón para enviar.
  - `NotasView.java`: Vista de gestión de notas con 2 campos para el título y contenido de la nota, y un botón para agregar.

- **Pruebas**
  - `LoginTest.java`: Pruebas de integración para la vista de inicio de sesión utilizando Playwright.
  - `RegistroTest.java`: Pruebas de integración para la vista de formulario de contacto utilizando Playwright.
  - `NotasTest.java`: Pruebas de integración para la vista de gestión de notas utilizando Playwright.
 
# Instalación y Ejecución

1. **Clonar el repositorio**:
   Primero ejecuta estos comandos en la carpeta de tu preferencia
   ```sh
    git clone https://github.com/AlbertGC13/QA.git
    cd QA
    git checkout main
    ```

3. **Instalar dependencias**:
    ```sh
    mvn clean install
    ```

4. **Iniciar el servidor**:
    ```sh
    mvn spring-boot:run
    ```

5. **Ejecutar las pruebas de playwright**:
    ```sh
    mvn test
    ```
