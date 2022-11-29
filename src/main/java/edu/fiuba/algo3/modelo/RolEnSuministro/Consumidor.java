package edu.fiuba.algo3.modelo.RolEnSuministro;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoEntidad;

public class Consumidor extends RolEnSuministro {

    private int suministroAConsumir;

    public Consumidor(int cantAConsumir) {
        this.suministroAConsumir = cantAConsumir;
    }

    @Override
    public int afectarSuministro(int suministroActual, EstadoEntidad estadoEntidad) {
        return suministroActual - suministroAConsumir;
    }
}
