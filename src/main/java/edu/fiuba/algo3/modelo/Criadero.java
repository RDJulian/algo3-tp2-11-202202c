package edu.fiuba.algo3.modelo;

public class Criadero {

    private Integer cantidadLarvas;

    public Criadero(){
        this.cantidadLarvas = 3;
    }

    public Integer getLarvas() {
        return cantidadLarvas;
    }

    public Zangano engendrarZangano() {
        this.cantidadLarvas -= 1;
        return new Zangano();
    }

    public void pasarTurno() {
        this.cantidadLarvas += 1;
    }
}
