package edu.fiuba.algo3.modelo.RolEnSuministro;

public class Neutral extends RolEnSuministro {
    @Override
    public int afectarSuministro(int suministroActual) {
        return suministroActual;
    }
}
