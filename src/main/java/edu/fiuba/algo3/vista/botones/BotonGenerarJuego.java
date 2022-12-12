package edu.fiuba.algo3.vista.botones;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonGenerarJuego extends Button {

    Stage stage;

    public BotonGenerarJuego (Stage stage){

        this.stage = stage;

        //Propiedades del Boton
        this.setText("Generar Juego");
        this.setFont(Font.font("arial", 30));
        this.setPadding(new Insets(10));
        this.setTextFill(Color.BLACK);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(1.5D))));
        Background unFondo = new Background(new BackgroundFill(Color.web("4C4EF3", 0.4F), new CornerRadii(25), new Insets(0)));
        super.setBackground(unFondo);

    }

}
