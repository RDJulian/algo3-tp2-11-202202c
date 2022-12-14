package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.GenerarJuegoEventHandler;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.contenedores.ContenedorJugadores;
import edu.fiuba.algo3.vista.contenedores.ContenedorPropiedadesJugadores;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonGenerarJuego extends Button {

    public BotonGenerarJuego (Stage stage, Scene siguienteEscena, ContenedorJugadores contenedor, ContenedorPropiedadesJugadores jugador1, ContenedorPropiedadesJugadores jugador2, Label etiqueta, Juego juego){

        //Propiedades del Boton.
        this.setText("Generar Juego");
        this.setFont(Font.font("arial", 30));
        this.setPadding(new Insets(10));
        this.setTextFill(Color.BLACK);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(1.5D))));
        Background unFondo = new Background(new BackgroundFill(Color.web("4C4EF3", 0.4F), new CornerRadii(25), new Insets(0)));
        super.setBackground(unFondo);

        //Eventos.
        setOnAction(new GenerarJuegoEventHandler(stage, siguienteEscena, contenedor, jugador1, jugador2, etiqueta,juego));

    }

}
