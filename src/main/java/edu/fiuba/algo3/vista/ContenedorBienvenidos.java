package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controladores.BotonCambiarEscenaEventHandler;
import edu.fiuba.algo3.controladores.BotonSalirEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.text.Font;


public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos (Stage stage, Scene escenaJugadores, String versionDeJava, String versionDeFX){

        super();

        // Configuraciones del Layout
        this.stage = stage;
        this.setAlignment (Pos.CENTER);
        this.setSpacing (20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/FondoBienvenidos2.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));



        // Controladores
        Label etiqueta = new Label();
        etiqueta.setText("Bienvenidos a AlgoCraft");
        etiqueta.setFont(Font.font("arial", 40));
        etiqueta.setTextFill(Color.DARKBLUE);

        Image imagenPrincial = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/imagenEscenaBienvenidos.png");
        ImageView marco = new ImageView(imagenPrincial);

        Button botonComenzarJuego = new Button();
        botonComenzarJuego.setText("Comenzar Juego");
        botonComenzarJuego.setFont(Font.font("arial", 30));

        Button botonDeSalir = new Button();
        botonDeSalir.setText("Salir");
        botonDeSalir.setFont(Font.font("arial", 20));

        Label etiquetaDeEspecificaciones = new Label("JavaFX " + versionDeFX + ", running on Java " + versionDeJava + ".");
        etiquetaDeEspecificaciones.setFont(Font.font("arial", 10));

        VBox contenedorPieDePagina = new VBox();
        contenedorPieDePagina.getChildren().add(etiquetaDeEspecificaciones);
        contenedorPieDePagina.setAlignment(Pos.BOTTOM_RIGHT);

        this.getChildren().addAll(etiqueta, marco, botonComenzarJuego, botonDeSalir,contenedorPieDePagina);



        //Eventos
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonDeSalir.setOnAction(botonSalirEventHandler);

        BotonCambiarEscenaEventHandler botonCambiarEscenaEventHandler = new BotonCambiarEscenaEventHandler(stage, escenaJugadores);
        botonComenzarJuego.setOnAction(botonCambiarEscenaEventHandler);
    }

}
