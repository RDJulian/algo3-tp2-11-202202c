package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ConfirmarColorEventHandler implements EventHandler<ActionEvent> {

    Label etiqueta;
    String nombreColor;
    String colorJugador;

    public ConfirmarColorEventHandler (Label etiqueta, String nombreColor, String colorJugador){

        this.etiqueta = etiqueta;
        this.nombreColor = nombreColor;
        this.colorJugador = colorJugador;
    }

    @Override
    public void handle (ActionEvent actionEvent){

        this.etiqueta.setText("Su color es: " + nombreColor);
        this.colorJugador = this.nombreColor;
    }

}
