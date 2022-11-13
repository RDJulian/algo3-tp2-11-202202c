package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupada;

public class Posicion {
    private int posicionX;
    private int posicionY;

    private EstadoPosicion estadoPosicion;

    public Posicion(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.estadoPosicion = new Desocupada();

    }

    public int getX() {
        return this.posicionX;
    }

    public int getY() {
        return this.posicionY;
    }

    public void ocupable() throws PosicionOcupada {
        estadoPosicion.ocupable();
    }

    public void setEstadoPosicion(EstadoPosicion newEstadoPosicion) {
        this.estadoPosicion = newEstadoPosicion;
    }
}
