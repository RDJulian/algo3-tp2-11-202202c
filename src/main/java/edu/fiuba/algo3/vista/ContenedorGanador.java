package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controladores.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/FondoBienvenidos.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //Controladores
        Label etiqueta = new Label();
        etiqueta.setText("Felicitaciones al jugor X por haber ganado esta épica batalla!");
        etiqueta.setFont(Font.font("arial", 40));
        etiqueta.setTextFill(Color.GOLDENROD);

        Image imagenMedalla = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/medalla.gif");
        ImageView marcoMedalla = new ImageView(imagenMedalla);

        Image imagenConfettiIzquierda = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/confetti3.gif");
        ImageView marcoConfettiIzquierda = new ImageView(imagenConfettiIzquierda);

        Image imagenConfettiDerecha = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/confetti3.gif");
        ImageView marcoConfettiDerecha = new ImageView(imagenConfettiDerecha);

        HBox contenedorPincipal = new HBox();
        contenedorPincipal.getChildren().addAll(marcoConfettiIzquierda, marcoMedalla, marcoConfettiDerecha);
        contenedorPincipal.setAlignment(Pos.CENTER);

        Button botonDeSalir = new Button();
        botonDeSalir.setText("Salir");
        botonDeSalir.setFont(Font.font("arial", 20));

        this.getChildren().addAll(etiqueta, contenedorPincipal, botonDeSalir);

        //Eventos
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonDeSalir.setOnAction(botonSalirEventHandler);
    }
}
