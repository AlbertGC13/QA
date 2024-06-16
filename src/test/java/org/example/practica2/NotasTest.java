package org.example.practica2;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NotasTest {

    private static Playwright playwright;
    private static Browser browser;

    @BeforeAll
    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    public static void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    public void notasTest() {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.setDefaultTimeout(60000);
        page.navigate("http://localhost:8080/notas");

        Locator tituloInput = page.locator("vaadin-text-field#titulo").locator("input");
        Locator contenidoInput = page.locator("vaadin-text-area#contenido").locator("textarea");
        Locator agregarButton = page.locator("vaadin-button#agregar");

        // Verifico la visibilidad de los campos
        assertThat(tituloInput).isVisible();
        assertThat(contenidoInput).isVisible();
        assertThat(agregarButton).isVisible();

        // Lleno los campos y se hace clic en el botón de agregar nota
        tituloInput.fill("Nota 1");
        contenidoInput.fill("Cualquier cosa");
        agregarButton.click();

        // Verifico que la nota se ha añadido a la lista
        Locator notaTitulo = page.locator("vaadin-grid-cell-content").filter(new Locator.FilterOptions().setHasText("Nota 1")).first();
        Locator notaContenido = page.locator("vaadin-grid-cell-content").filter(new Locator.FilterOptions().setHasText("Cualquier cosa")).first();
        assertThat(notaTitulo).isVisible();
        assertThat(notaContenido).isVisible();

        assertThat(page.locator("text=Nota agregada")).isVisible();
    }
}
