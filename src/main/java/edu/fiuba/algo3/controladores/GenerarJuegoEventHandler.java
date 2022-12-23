package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.NombreNoValidoException;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Mapa.Base;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.vista.contenedores.ContenedorJugadores;
import edu.fiuba.algo3.vista.contenedores.ContenedorPropiedadesJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GenerarJuegoEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene siguienteEscena;
    ContenedorJugadores contenedor;
    ContenedorPropiedadesJugadores jugador1;
    ContenedorPropiedadesJugadores jugador2;
    Juego juego;
    Protoss razaJugador1;
    Zerg razaJugador2;
    Label etiqueta;

    public GenerarJuegoEventHandler(Stage stage, Scene siguienteEscena, ContenedorJugadores contenedor, ContenedorPropiedadesJugadores jugador1, ContenedorPropiedadesJugadores jugador2, Label etiqueta, Juego juego) {

        this.stage = stage;
        this.siguienteEscena = siguienteEscena;
        this.contenedor = contenedor;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.juego = juego;
        this.razaJugador1 = new Protoss();
        this.razaJugador2 = new Zerg();
        this.etiqueta = etiqueta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {


        this.contenedor.setNombres(this.jugador1.getNombre(), this.jugador2.getNombre());
        this.contenedor.setColores(this.jugador1.getColor(), this.jugador2.getColor());

        try {


            this.juego.registrarJugadores(this.contenedor.getNombre1(), this.contenedor.getColor1(), this.razaJugador1, this.contenedor.getNombre2(), this.contenedor.getColor2(), this.razaJugador2);
            stage.setScene(siguienteEscena);


        } catch (NombreNoValidoException e) {

            this.etiqueta.setText("Un nombre no es valido");
            this.etiqueta.setTextFill(Color.RED);

        } catch (JugadoresNoCompatiblesException e) {

            this.etiqueta.setText("Los jugadores comparten nombre o color");
            this.etiqueta.setTextFill(Color.RED);

        }

    }

}
