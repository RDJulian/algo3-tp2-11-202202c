package edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Unidad.RevelaEntidades;

import java.util.ArrayList;

public interface UsaMementoInvisibilidad {
    //Las estructuras que desean usar un memento deben implementar esta interfaz.
    MementoInvisibilidad guardarEstado();

    void restaurarEstado(MementoInvisibilidad snapshot);

    void actualizarEstado(ArrayList<RevelaEntidades> reveladores);
}