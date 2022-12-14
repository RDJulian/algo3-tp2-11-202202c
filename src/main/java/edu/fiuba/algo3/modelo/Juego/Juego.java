package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.NombreNoValidoException;
import edu.fiuba.algo3.modelo.Mapa.Base;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Raza> razas;
    private int turno;

    public Juego() {
        this.razas = new ArrayList<>();
    }

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
        this.turno = 1;

        iniciarJuego();
    }

    //Hardcodeado.
    public void iniciarJuego() {
        Mapa.obtenerInstancia().generarBases(new Base(15, 15), new Base(-15, -15));
    }

    public void pasarTurno() {
        for (Raza raza : razas) {
            raza.pasarTurno();
        }
        Mapa.obtenerInstancia().pasarTurno();
        Mapa.obtenerInstancia().actualizarTablero();
        turno += 1;
    }

    public Raza razaAJugar() {
        return razas.get(turno - 1 % 2);
    }

    public boolean terminarJuego() {
        return razas.get(0).sinEstructuras() || razas.get(1).sinEstructuras();
    }
}