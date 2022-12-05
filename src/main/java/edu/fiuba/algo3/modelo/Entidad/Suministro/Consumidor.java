package edu.fiuba.algo3.modelo.Entidad.Suministro;

public class Consumidor extends AfectaSuministro {

    private int suministroAConsumir;

    public Consumidor(int cantAConsumir) {
        this.suministroAConsumir = cantAConsumir;
    }

    @Override
    public int afectarSuministro(int suministroActual) {
        return suministroActual - suministroAConsumir;
    }
}
