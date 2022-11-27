package edu.fiuba.algo3.modelo.RolEnSuministro;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoEntidad;

public class Proveedor extends RolEnSuministro {
    //Se podria pedir el suministro que aporta.

    public int afectarSuministro(int suministroActual, EstadoEntidad estadoEntidad) {
        int nuevoSuministro = suministroActual;
        if (estadoEntidad.visitar(this)) {
            nuevoSuministro += 5;
            if (nuevoSuministro > 200) {
                nuevoSuministro = 200;
            }
        }
        return nuevoSuministro;
    }
}
