package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class LimpiarTextoEventHandler implements EventHandler<ActionEvent> {

    private TextField textField;

    public LimpiarTextoEventHandler (TextField textField){
        this.textField = textField;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.textField.clear();
        this.textField.requestFocus();
    }
}
