package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.SalirEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonDeSalir extends Button {

    public BotonDeSalir(){

        //Propiedades del Boton.
        this.setText("Salir");
        this.setFont(Font.font("arial", 30));
        this.setPadding(new Insets(10));
        this.setTextFill(Color.BLACK);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(1.5D))));
        Background unFondo = new Background(new BackgroundFill(Color.web("4C4EF3", 0.4F), new CornerRadii(25), new Insets(0)));
        super.setBackground(unFondo);

        //Eventos.
        this.setOnAction(new SalirEventHandler());

    }
}