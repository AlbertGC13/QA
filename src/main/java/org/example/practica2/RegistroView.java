package org.example.practica2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("registro")
public class RegistroView extends VerticalLayout {

    public RegistroView() {
        TextField name = new TextField("Name");
        name.setId("name");
        EmailField email = new EmailField("Email");
        email.setId("email");
        TextArea message = new TextArea("Message");
        message.setId("message");
        Button sendButton = new Button("Send", event -> {
            Notification.show("Message received");
        });

        add(name, email, message, sendButton);
    }
}
