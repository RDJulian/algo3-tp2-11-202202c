package edu.fiuba.algo3.modelo.Reserva;

public class ReservaGas {
    private int unidades;
    public ReservaGas(){
        this.unidades = 0;
    }

    public int getRecurso() {
        return this.unidades;
    }

    public void agregarRecurso(int unidades) {
        this.unidades += unidades;
    }
}
