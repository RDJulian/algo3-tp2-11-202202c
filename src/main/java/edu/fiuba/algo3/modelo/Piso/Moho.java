package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Moho implements Piso {
    private int turnos;
    private int rango;
    private Posicion posicion;

    public Moho(Posicion posicion) {
        this.rango = 5;
        this.turnos = 0;
        this.posicion = posicion;

        posicion.cubrirConMoho();
    }

    //Llamar este metodo luego de pasar turno para todas las posiciones. La idea es que se actualicen todas.
    @Override
    public void actualizarPosicionEnRango(Posicion posicion) {
        if (posicion.enRango(this.posicion, rango)) {
            posicion.cubrirConMoho();
        }
    }

    public void pasarTurno() {
        turnos += 1;
        if (turnos % 2 == 0) {
            this.rango += 1;
        }
    }
}
