package edu.fiuba.algo3.modelo.Posicion;

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

    public void ocupable() {
        estadoPosicion.ocupable();
    }

    public void setEstadoPosicion(EstadoPosicion newEstadoPosicion) {
        this.estadoPosicion = newEstadoPosicion;
    }
}
