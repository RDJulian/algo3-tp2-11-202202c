package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controladores.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ContenedorGanador extends VBox{

    Stage stage;

    public ContenedorGanador (Stage stage){
        super();

        //Configuración del Layout
        this.stage = stage;
        this.setAlignment (Pos.CENTER);
        this.setSpacing (20);
        this.setPadding(new Insets(25));
        //Image imagen = new Image("/Assets/fondoBienvenida.jpg");
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        //Controladores
        Label etiqueta = new Label();
        etiqueta.setText("Felicitaciones al jugor X por haber ganado esta épica batalla!");

        Button botonDeSalir = new Button();
        botonDeSalir.setText("Salir");

        this.getChildren().addAll(etiqueta, botonDeSalir);

        //Eventos
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonDeSalir.setOnAction(botonSalirEventHandler);
    }
}
