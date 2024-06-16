package org.example.practica2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("notas")
public class NotasView extends VerticalLayout {

    private List<Nota> notas;
    private Grid<Nota> grid;

    public NotasView() {
        notas = new ArrayList<>();

        TextField tituloField = new TextField("Título de la Nota");
        tituloField.setId("titulo");
        TextArea contenidoField = new TextArea("Contenido de la Nota");
        contenidoField.setId("contenido");
        Button agregarButton = new Button("Agregar Nota", event -> {
            String titulo = tituloField.getValue();
            String contenido = contenidoField.getValue();
            if (!titulo.isEmpty() && !contenido.isEmpty()) {
                notas.add(new Nota(titulo, contenido));
                grid.setItems(notas);
                tituloField.clear();
                contenidoField.clear();
                Notification.show("Nota agregada");
            } else {
                Notification.show("Por favor, llena ambos campos");
            }
        });
        agregarButton.setId("agregar");

        grid = new Grid<>(Nota.class);
        grid.setItems(notas);

        add(tituloField, contenidoField, agregarButton, grid);
    }

    public static class Nota {
        private String titulo;
        private String contenido;

        public Nota(String titulo, String contenido) {
            this.titulo = titulo;
            this.contenido = contenido;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getContenido() {
            return contenido;
        }
    }
}
