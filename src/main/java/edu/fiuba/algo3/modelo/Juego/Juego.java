package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.NombreNoValidoException;
import edu.fiuba.algo3.modelo.Juego.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class Juego {
    //Esta clase podria ser la encargada de manejar los turnos.
    private ArrayList<Jugador> jugadores;

    public Juego() {
        this.jugadores = new ArrayList<>();
    }

    //Las razas deberian ser singletons. No deberia haber mas de una instancia de ambas.
    //Si se hace eso, esta comparacion se puede mantener sencilla. Color podrian ser los de javafx.
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
