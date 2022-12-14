package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Etiquetas.EtiquetaPrincipal;
import edu.fiuba.algo3.vista.Etiquetas.EtiquetaSecundaria;
import edu.fiuba.algo3.vista.botones.BotonDeSalir;
import edu.fiuba.algo3.vista.botones.BotonGenerarJuego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ContenedorJugadores extends VBox {

    private Stage stage;
    private String nombreJugador1;
    private String nombreJugador2;
    private String colorJugador1;
    private String colorJugador2;

    public ContenedorJugadores(Stage stage, Scene escenaPrincipal, Juego juego) {
        super();

        this.stage = stage;

        //Configuración del Layout
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/fondoJugadores.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //Controladores
        EtiquetaPrincipal etiquetaPrincipal = new EtiquetaPrincipal("Por favor elijan sus nombre y colores para empezar a jugar:");

        BotonDeSalir botonDeSalir = new BotonDeSalir();

        ContenedorPropiedadesJugadores jugador1 = new ContenedorPropiedadesJugadores("Protoss");
        ContenedorPropiedadesJugadores jugador2 = new ContenedorPropiedadesJugadores("Zerg");

        EtiquetaSecundaria mensajeDeError = new EtiquetaSecundaria("");

        BotonGenerarJuego botonGenerarJuego = new BotonGenerarJuego(stage, escenaPrincipal, this, jugador1, jugador2, mensajeDeError, juego);

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
        contenedorBottom.getChildren().addAll(mensajeDeError, botonDeSalir, botonGenerarJuego);
        contenedorBottom.setPadding(new Insets(10));

        this.getChildren().addAll(contenedorTop, contenedorCentro, contenedorBottom);
    }

    public void setNombres(String jugador1, String jugador2) {
        this.nombreJugador1 = jugador1;
        this.nombreJugador2 = jugador2;
    }

    public void setColores(String color1, String color2) {
        this.colorJugador1 = color1;
        this.colorJugador2 = color2;
    }

    public String getNombre1() {
        return this.nombreJugador1;
    }

    public String getNombre2() {
        return this.nombreJugador2;
    }

    public String getColor1() {
        return this.colorJugador1;
    }

    public String getColor2() {
        return this.colorJugador2;
    }
}
