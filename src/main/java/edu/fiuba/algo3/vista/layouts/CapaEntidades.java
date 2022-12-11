package edu.fiuba.algo3.vista.layouts;

import javafx.scene.layout.GridPane;

public class CapaEntidades extends GridPane {


    public void agregarCanvas(VistaEntidad dibujoEntidad, int col, int fil){
        this.add(dibujoEntidad,col,fil);
    }
}
