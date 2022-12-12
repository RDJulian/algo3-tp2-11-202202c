package edu.fiuba.algo3.vista.Etiquetas;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EtiquetaSecundaria extends Label {

    public EtiquetaSecundaria(String texto){

        this.setText(texto);
        this.setFont(Font.font("arial", 20));
        this.setTextFill(Color.LIGHTBLUE);
        this.setPadding(new Insets(10));

    }
}
