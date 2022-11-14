package edu.fiuba.algo3.modelo.Posicion;

public class Rango {
    private Posicion posicion;
    private int radio;

    public Rango(Posicion posicion, int radio) {
        this.posicion = posicion;
        this.radio = radio;
    }

    public boolean noIncluye(Posicion posicion) {
        //REDO: Este metodo rompe encapsulamiento.
        return !(posicion.getX() <= this.posicion.getX() + radio &
                posicion.getX() >= this.posicion.getX() - radio &
                posicion.getY() <= this.posicion.getY() + radio &
                posicion.getY() >= this.posicion.getY() - radio);
    }

    public void expandir() {
        this.radio += 1;
    } //Esto solo aplica al Moho.


}
