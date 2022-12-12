package edu.fiuba.algo3.vista.Etiquetas;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EtiquetaPrincipal extends Label {

    public EtiquetaPrincipal(String texto){

        this.setText(texto);
        this.setFont(Font.font("arial", 40));
        this.setTextFill(Color.DARKBLUE);

    }
}
