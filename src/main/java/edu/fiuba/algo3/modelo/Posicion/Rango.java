package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;

public class Rango {
    private Posicion posicion;
    private int radio;

    public Rango(Posicion posicion, int radio) {
        this.posicion = posicion;
        this.radio = radio;
    }

    public boolean incluye(Posicion posicion) {
        //REDO: Este metodo rompe encapsulamiento.
        if (!(posicion.getX() <= this.posicion.getX() + radio &
                posicion.getX() >= this.posicion.getX() - radio &
                posicion.getY() <= this.posicion.getY() + radio &
                posicion.getY() >= this.posicion.getY() - radio)) {
            return false;
        }
        return true;
    }

    public void expandir() {
        this.radio += 1;
    }
}
