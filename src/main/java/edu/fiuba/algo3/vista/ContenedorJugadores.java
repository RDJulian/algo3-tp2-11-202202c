package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controladores.BotonCambiarEscenaEventHandler;
import edu.fiuba.algo3.controladores.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        //Image imagen = new Image("/Assets/fondoBienvenida.jpg");
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));

        //Controladores
        Label etiqueta = new Label();
        etiqueta.setText("Por favor elijan sus nombre y colores para empezar a jugar");

        Button botonDeEmpezarJuego = new Button();
        botonDeEmpezarJuego.setText("Empezar juego!");

        Button botonDeSalir = new Button();
        botonDeSalir.setText("Salir");

        this.getChildren().addAll(etiqueta, botonDeEmpezarJuego, botonDeSalir);

        //Eventos
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonDeSalir.setOnAction(botonSalirEventHandler);

        BotonCambiarEscenaEventHandler botonCambiarEscenaEventHandler = new BotonCambiarEscenaEventHandler(stage, escenaPrincipal);
        botonDeEmpezarJuego.setOnAction(botonCambiarEscenaEventHandler);
    }
}
