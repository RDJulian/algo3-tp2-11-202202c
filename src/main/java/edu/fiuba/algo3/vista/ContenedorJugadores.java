package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controladores.BotonCambiarEscenaEventHandler;
import edu.fiuba.algo3.controladores.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class ContenedorJugadores extends VBox {

    Stage stage;

    public ContenedorJugadores (Stage stage, Scene escenaPrincipal) {
        super();

        //Configuración del Layout
        this.stage = stage;
        this.setAlignment (Pos.CENTER);
        this.setSpacing (20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/fondoJugadores5.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //Controladores
        Label etiqueta = new Label();
        etiqueta.setText("Por favor elijan sus nombre y colores para empezar a jugar:");

        Button botonDeEmpezarJuego = new Button();
        botonDeEmpezarJuego.setText("Comenzar a jugar");

        Button botonDeSalir = new Button();
        botonDeSalir.setText("Salir");

        Label etiquetaEleccionDeJugadores = new Label();
        etiquetaEleccionDeJugadores.setText("SOY EL CONTENEDOR CENTRO");
        etiquetaEleccionDeJugadores.setPadding( new Insets(50));

        Label etiquetaEleccionDeJugadores2 = new Label();
        etiquetaEleccionDeJugadores2.setText("SOY EL CONTENEDOR CENTRO");
        etiquetaEleccionDeJugadores2.setPadding( new Insets(50));

        HBox contenedorTop = new HBox();
        contenedorTop.setAlignment(Pos.TOP_LEFT);
        contenedorTop.getChildren().addAll(etiqueta);

        HBox contenedorCentro = new HBox();
        contenedorCentro.getChildren().addAll(etiquetaEleccionDeJugadores, etiquetaEleccionDeJugadores2);
        contenedorCentro.setAlignment(Pos.CENTER);

        HBox contenedorBottom = new HBox();
        contenedorBottom.setAlignment(Pos.CENTER_RIGHT);
        contenedorBottom.getChildren().addAll(botonDeSalir, botonDeEmpezarJuego);

        this.getChildren().addAll(contenedorTop, contenedorCentro, contenedorBottom);

        //Eventos
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonDeSalir.setOnAction(botonSalirEventHandler);

        BotonCambiarEscenaEventHandler botonCambiarEscenaEventHandler = new BotonCambiarEscenaEventHandler(stage, escenaPrincipal);
        botonDeEmpezarJuego.setOnAction(botonCambiarEscenaEventHandler);
    }
}
