package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;

public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos (Stage stage, Scene EscenaJugadores){

        super();

        this.stage = stage;
        this.setAlignment (Pos.CENTER);
        this.setSpacing (20);
        this.setPadding(new Insets(25));
        //Image imagen = new Image("/Assets/fondo Bienvenida.jpg");
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        Button botonComenzarJuego = new Button();
        botonComenzarJuego.setText("Comenzar Juego!");

        Button botonDeSalir = new Button();
        botonDeSalir.setText("Salir");

        Label etiqueta = new Label();
        etiqueta.setText("Bienvenidos a AlgoStar");

        this.getChildren().addAll(etiqueta, botonComenzarJuego, botonDeSalir);
    }

}
