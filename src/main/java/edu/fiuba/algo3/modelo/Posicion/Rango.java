package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Estructura.Estructura;

public class Rango {
    private Posicion posicion;
    private int radio;

    public Rango(Posicion posicion, int radio) {
        this.posicion = posicion;
        this.radio = radio;
    }

    public boolean incluye(Posicion posicion) {
        //REDO: Este metodo rompe encapsulamiento.
        return posicion.getX() <= this.posicion.getX() + radio &
                posicion.getX() >= this.posicion.getX() - radio &
                posicion.getY() <= this.posicion.getY() + radio &
                posicion.getY() >= this.posicion.getY() - radio;
    }

    public void expandir() {
        this.radio += 1;
    } //Esto solo aplica al Moho.


}
