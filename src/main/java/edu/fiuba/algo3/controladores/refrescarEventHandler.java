package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class refrescarEventHandler implements EventHandler<ActionEvent> {

    Label label;
    String nom1;
    String nom2;
    String col1;
    String col2;


    public refrescarEventHandler (String nom1, String nom2, String col1, String col2, Label label){

        this.label = label;
        this.nom1 = nom1;
        this.nom2 = nom2;
        this.col1 = col1;
        this.col2 = col2;

    }


    @Override
    public void handle (ActionEvent actionEvent){

        this.label.setText(this.nom1 + "," + this.nom2 + "," + this.col1 + "," + this.col2);

    }


}
