package edu.fiuba.algo3.modelo.Posicion;

public class Posicion {
    //A futuro pueden ser las Areas, y pueden ser singletons.
    //Buscar mejor forma de resolver chequeos, y cambiar nombres.
    private int posicionX;
    private int posicionY;

    private EstadoPosicion estadoPosicion;

    public Posicion(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.estadoPosicion = new Desocupada();
    }

    private boolean enRango(int posicionX, int posicionY, int radio) {
        return (this.posicionX - radio <= posicionX &&
                this.posicionX + radio >= posicionX &&
                this.posicionY - radio <= posicionY &&
                this.posicionY + radio >= posicionY);
    }

    public boolean enRango(Posicion posicion, int radio) {
        return (posicion.enRango(this.posicionX, this.posicionY, radio));
    }

    public void ocupable() {
        estadoPosicion.ocupable();
    }

    public void setEstadoPosicion(EstadoPosicion estadoPosicion) {
        this.estadoPosicion = estadoPosicion;
    }
}
