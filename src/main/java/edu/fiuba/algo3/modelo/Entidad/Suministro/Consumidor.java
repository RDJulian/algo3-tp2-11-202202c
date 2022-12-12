package edu.fiuba.algo3.modelo.Entidad.Suministro;

public class Consumidor implements AfectaSuministro {
    private int suministroAConsumir;

    public Consumidor(int cantidadAConsumir) {
        this.suministroAConsumir = cantidadAConsumir;
    }

    @Override
    public int afectarSuministro(int suministroActual) {
        return suministroActual - suministroAConsumir;
    }
}