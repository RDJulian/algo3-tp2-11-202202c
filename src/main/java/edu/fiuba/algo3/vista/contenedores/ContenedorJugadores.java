package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.vista.Etiquetas.EtiquetaPrincipal;
import edu.fiuba.algo3.vista.Etiquetas.EtiquetaSecundaria;
import edu.fiuba.algo3.vista.botones.BotonComenzarJuego;
import edu.fiuba.algo3.vista.botones.BotonDeSalir;
import edu.fiuba.algo3.vista.botones.BotonRefrescar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ContenedorJugadores extends VBox {

    Stage stage;
    Juego juego;
    Raza razaJugador1;
    Raza razaJugador2;
    String nombreJugador1 = "nombre 1";
    String nombreJugador2 = "nombre 2";
    String colorJugador1 = "color 1";
    String colorJugador2 = "nombre 2";

    public ContenedorJugadores (Stage stage, Scene escenaPrincipal) {
        super();

        this.stage = stage;
        this.juego = new Juego();
        this.razaJugador1 = new Raza();
        this.razaJugador2 = new Raza();

        //Configuración del Layout
        this.setAlignment (Pos.CENTER);
        this.setSpacing (20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/fondoJugadores.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //Controladores
        EtiquetaPrincipal etiquetaPrincipal = new EtiquetaPrincipal("Por favor elijan sus nombre y colores para empezar a jugar:");

        BotonComenzarJuego botonComenzarJuego = new BotonComenzarJuego(stage, escenaPrincipal);

        BotonDeSalir botonDeSalir = new BotonDeSalir();

        ContenedorPropiedadesJugadores jugador1 = new ContenedorPropiedadesJugadores("Protos", this.nombreJugador1, this.colorJugador1);
        ContenedorPropiedadesJugadores jugador2 = new ContenedorPropiedadesJugadores("Zerg", this.nombreJugador2, this.colorJugador2);

        EtiquetaSecundaria prueba = new EtiquetaSecundaria(this.nombreJugador1 + "," + this.nombreJugador2 + "," + this.colorJugador1 + "," + this.colorJugador2);
        prueba.setTextFill(Color.GOLDENROD);
        BotonRefrescar botonPrueba = new BotonRefrescar(this.nombreJugador1, this.nombreJugador2, this.colorJugador1, this.colorJugador2, prueba);

        //Contenedores
        HBox contenedorTop = new HBox();
        contenedorTop.setAlignment(Pos.TOP_LEFT);
        contenedorTop.getChildren().addAll(etiquetaPrincipal);
        contenedorTop.setPadding(new Insets(10));

        HBox contenedorCentro = new HBox();
        contenedorCentro.getChildren().addAll(jugador1, jugador2);
        contenedorCentro.setAlignment(Pos.CENTER);

        HBox contenedorBottom = new HBox();
        contenedorBottom.setAlignment(Pos.CENTER_RIGHT);
        contenedorBottom.getChildren().addAll(botonPrueba, prueba, botonDeSalir, botonComenzarJuego);
        contenedorBottom.setPadding(new Insets(10));

        this.getChildren().addAll(contenedorTop, contenedorCentro, contenedorBottom);
    }
}
