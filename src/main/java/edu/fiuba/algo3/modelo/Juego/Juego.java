package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.NombreNoValidoException;
import edu.fiuba.algo3.modelo.Mapa.Base;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Raza.Raza;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;

public class Juego {
    private String jugadorUno;
    private String jugadorDos;
    private String colorUno;
    private String colorDos;
    private Raza razaJugadorUno;
    private Raza razaJugadorDos;

    public void registrarJugadores(String unNombre, String unColor, Raza unaRaza,
                                   String otroNombre, String otroColor, Raza otraRaza) {
        if (unNombre.length() < 6 || otroNombre.length() < 6) {
            throw new NombreNoValidoException();
        }

        if (unNombre.equals(otroNombre) ||
                unColor.equals(otroColor) ||
                unaRaza == otraRaza) {
            throw new JugadoresNoCompatiblesException();
        }

        this.jugadorUno = unNombre;
        this.jugadorDos = otroNombre;

        this.colorUno = unColor;
        this.colorDos = otroColor;

        this.razaJugadorUno = unaRaza;
        this.razaJugadorDos = otraRaza;
    }

    public void iniciarJuego() {
        Mapa.obtenerInstancia().generarBases(new Base(15, 15), new Base(-15, -15));
    }

    public void pasarTurno() {
        razaJugadorUno.pasarTurno();
        razaJugadorDos.pasarTurno();
        Mapa.obtenerInstancia().pasarTurno();
        Mapa.obtenerInstancia().actualizarTablero();
    }

    public boolean terminarJuego() {
        return razaJugadorUno.sinEstructuras() || razaJugadorDos.sinEstructuras();
    }
}