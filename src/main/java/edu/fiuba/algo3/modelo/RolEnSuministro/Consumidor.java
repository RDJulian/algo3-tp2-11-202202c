package edu.fiuba.algo3.modelo.RolEnSuministro;

public class Consumidor extends RolEnSuministro {

    private int suministroAConsumir;

    public Consumidor(int cantAConsumir) {
        this.suministroAConsumir = cantAConsumir;
    }

    @Override
    public int afectarSuministro(int suministroActual) {
        return suministroActual - suministroAConsumir;
    }
}
