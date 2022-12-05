package edu.fiuba.algo3.modelo.Entidad.Suministro;

public class NoAfecta extends AfectaSuministro {
    @Override
    public int afectarSuministro(int suministroActual) {
        return suministroActual;
    }
}
