package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class VistaTerreno {

    private Posicion posicion;
    private Recurso recurso;
    private Piso piso;

    public VistaTerreno(Posicion posicion, Recurso recurso, Piso piso) {
        this.posicion = posicion;
        this.recurso = recurso;
        this.piso = piso;
    }
}
