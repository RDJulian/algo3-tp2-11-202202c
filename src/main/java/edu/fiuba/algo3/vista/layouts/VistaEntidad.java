package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class VistaEntidad {

    private Posicion posicion;
    private Estructura estructura;
    private Unidad unidad;

    public VistaEntidad(Posicion posicion, Estructura estructura, Unidad unidad) {
        this.posicion = posicion;
        this.estructura = estructura;
        this.unidad = unidad;
    }
}
