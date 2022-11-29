package edu.fiuba.algo3.modelo.RolEnSuministro;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoEntidad;

public class Neutral extends RolEnSuministro {
    @Override
    public int afectarSuministro(int suministroActual, EstadoEntidad estadoEntidad) {
        return suministroActual;
    }
}
