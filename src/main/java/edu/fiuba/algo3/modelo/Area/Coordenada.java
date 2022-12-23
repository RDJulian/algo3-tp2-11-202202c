package edu.fiuba.algo3.modelo.Area;

public class Coordenada {
    private int posicionX;
    private int posicionY;

    public Coordenada(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    private boolean enRango(int posicionX, int posicionY, int radio) {
        return (this.posicionX - radio <= posicionX &&
                this.posicionX + radio >= posicionX &&
                this.posicionY - radio <= posicionY &&
                this.posicionY + radio >= posicionY);
    }

    public boolean enRango(Coordenada coordenada, int radio) {
        return (coordenada.enRango(this.posicionX, this.posicionY, radio));
    }

    private boolean esOpuesta(int posicionX, int posicionY) {
        return (this.posicionX == -posicionX && this.posicionY == -posicionY);
    }

    public boolean esOpuesta(Coordenada coordenada) {
        return coordenada.esOpuesta(this.posicionX, this.posicionY);
    }

    private boolean es(int posicionX, int posicionY) {
        return (posicionX == this.posicionX && posicionY == this.posicionY);
    }

    public boolean es(Coordenada coordenada) {
        return coordenada.es(this.posicionX, this.posicionY);
    }

    public int x(){
        return posicionX;
    }

    public int y(){
        return posicionY;
    }
}
