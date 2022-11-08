package edu.fiuba.algo3.modelo.Reserva;

public class ReservaMineral {
    private int unidades;
    public ReservaMineral(){
        this.unidades = 0;
    }

    public int getRecurso() {
        return this.unidades;
    }

    public void agregarRecurso(int unidades) {
        this.unidades += unidades;
    }
}
