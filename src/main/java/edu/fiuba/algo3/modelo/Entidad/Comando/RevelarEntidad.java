package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Area.Area;

public class RevelarEntidad implements ComandoBool {
    Area areaObjetivo;
    Area areaRevelador;
    int radioDeDeteccion;

    public RevelarEntidad(Area areaObjetivo, Area areaRevelador, int radioDeDeteccion) {
        this.areaObjetivo = areaObjetivo;
        this.areaRevelador = areaRevelador;
        this.radioDeDeteccion = radioDeDeteccion;
    }

    @Override
    public boolean ejecutar() {
        return !areaObjetivo.enRango(areaRevelador, radioDeDeteccion);
    }
}
