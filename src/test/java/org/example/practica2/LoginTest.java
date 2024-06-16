package org.example.practica2;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest {

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
    public void loginTest() {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.setDefaultTimeout(30000);
        page.navigate("http://localhost:8080/login");

        Locator usernameInput = page.locator("vaadin-text-field#username").locator("input");
        Locator passwordInput = page.locator("vaadin-password-field#password").locator("input");
        Locator loginButton = page.locator("vaadin-button:has-text('Login')");

        // Verifico la visibilidad de los campos
        assertThat(usernameInput).isVisible();
        assertThat(passwordInput).isVisible();
        assertThat(loginButton).isVisible();

        // Lleno los campos y se hace clic en el botón de inicio de sesión
        usernameInput.fill("user");
        passwordInput.fill("password");
        loginButton.click();

        // Verifico el resultado
        assertThat(page.locator("text=Login successful")).isVisible();
    }
}
