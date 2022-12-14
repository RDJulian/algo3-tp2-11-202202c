package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.NombreNoValidoException;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class Juego {
    private Mapa mapa;
    private ArrayList<Raza> razas;
    private int turno;

    public Juego() {
        this.mapa = Mapa.obtenerInstancia();

        this.razas = new ArrayList<>();
        this.turno = 1;
    }

    //Se debe llamar antes de empezar con la secuencia del juego.
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

        razas.add(unaRaza);
        razas.add(otraRaza);
        unaRaza.asignarContrincante(otraRaza);
    }

    public void pasarTurno() {
        for (Raza raza : razas) {
            raza.pasarTurno();
        }
        mapa.pasarTurno();
        mapa.actualizarTablero();
        turno += 1;
    }

    public Raza razaAJugar() {
        return razas.get(turno - 1 % 2);
    }

    public boolean terminarJuego() {
        return razas.get(0).sinEstructuras() || razas.get(1).sinEstructuras();
    }
}