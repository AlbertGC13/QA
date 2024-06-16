package org.example.practica2;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegistroTest {

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
    public void registroFormTest() {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.setDefaultTimeout(30000);
        page.navigate("http://localhost:8080/registro");

        Locator nameInput = page.locator("vaadin-text-field#name").locator("input");
        Locator emailInput = page.locator("vaadin-email-field#email").locator("input");
        Locator messageInput = page.locator("vaadin-text-area#message").locator("textarea");
        Locator sendButton = page.locator("vaadin-button:has-text('Send')");

        // Verifico la visibilidad de los campos
        assertThat(nameInput).isVisible();
        assertThat(emailInput).isVisible();
        assertThat(messageInput).isVisible();
        assertThat(sendButton).isVisible();

        // Lleno los campos y se hace clic en el botón de envío
        nameInput.fill("Albert Garcia");
        emailInput.fill("agc@gmail.com");
        messageInput.fill("Hola, tengo 22 años.");
        sendButton.click();

        // Verifico el resultado
        assertThat(page.locator("text=Message received")).isVisible();
    }
}
