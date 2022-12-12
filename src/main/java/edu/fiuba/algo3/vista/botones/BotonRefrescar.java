package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.refrescarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BotonRefrescar extends Button {

    public BotonRefrescar (String nom1, String nom2, String col1, String col2, Label label) {

        this.setText("Refrescar");

        this.setOnAction(new refrescarEventHandler(nom1, nom2, col1, col2, label));
    }

}
