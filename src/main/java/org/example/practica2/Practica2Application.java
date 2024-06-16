package org.example.practica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@SpringBootApplication
public class Practica2Application extends VerticalLayout {

    public static void main(String[] args) {
        SpringApplication.run(Practica2Application.class, args);
    }

}
