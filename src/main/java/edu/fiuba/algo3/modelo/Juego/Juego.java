package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.NombreNoValidoException;
import edu.fiuba.algo3.modelo.Juego.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.Vector;

public class Juego {
    //Esta clase seria la encargada de manejar los turnos.
    private Vector<Jugador> jugadores;

    public Juego() {
        this.jugadores = new Vector<>();
    }

    //Las razas deberian ser singletons. No deberia haber mas de una instancia de ambas.
    //Si se hace eso, esta comparacion se puede mantener sencilla. Color deberia ser clase a futuro.
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

        jugadores.add(new Jugador(unNombre, unColor, unaRaza));
        jugadores.add(new Jugador(otroNombre, otroColor, otraRaza));
    }
}
