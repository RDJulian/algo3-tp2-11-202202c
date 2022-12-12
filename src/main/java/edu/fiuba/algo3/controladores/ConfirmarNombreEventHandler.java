package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConfirmarNombreEventHandler implements EventHandler<ActionEvent> {

    TextField textField;
    Label label;

    String nombreJugador;

    public ConfirmarNombreEventHandler (TextField textField, Label label, String nombreJugador){
        this.textField = textField;
        this.label = label;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle (ActionEvent actionEvent){

        if (this.textField.getText().trim().equals("")){

            this.label.setText("Su nombre es: Ingrese un nombre");
            this.textField.requestFocus();

        } else {

            this.label.setText("Su nombre es: " +  this.textField.getText());
            this.nombreJugador = this.textField.getText();

        }
    }

}
