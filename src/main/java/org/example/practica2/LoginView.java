package org.example.practica2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginView extends VerticalLayout {

    public LoginView() {
        TextField username = new TextField("Username");
        username.setId("username");
        PasswordField password = new PasswordField("Password");
        password.setId("password");
        Button loginButton = new Button("Login", event -> {
            if ("user".equals(username.getValue()) && "password".equals(password.getValue())) {
                Notification.show("Login successful");
            } else {
                Notification.show("Login failed");
            }
        });

        add(username, password, loginButton);
    }
}

