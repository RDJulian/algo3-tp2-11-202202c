package edu.fiuba.algo3.modelo.Posicion;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class Posicion {
    //Plantear relacion con las Areas.
    //Deberia implementar algun metodo que desocupe.
    private int posicionX;
    private int posicionY;

    private EstadoPosicion estadoPosicion;

    public Posicion(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.estadoPosicion = new Desocupada();
    }

    public void ocupable() {
        estadoPosicion.ocupable();
    }

    public void ocupar() {
        this.estadoPosicion = new Ocupada();
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

    private boolean esOpuesta(int posicionX, int posicionY) {
        return (this.posicionX == -posicionX && this.posicionY == -posicionY);
    }

    public boolean esOpuesta(Posicion posicion) {
        return posicion.esOpuesta(this.posicionX, this.posicionY);
    }

    private boolean es(int posicionX, int posicionY) {
        return (posicionX == this.posicionX && posicionY == this.posicionY);
    }

    public boolean es(Posicion posicion) {
        return posicion.es(this.posicionX, this.posicionY);
    }
}
