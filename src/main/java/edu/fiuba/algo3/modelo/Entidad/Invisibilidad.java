package edu.fiuba.algo3.modelo.Entidad;

import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.UsaMementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public class Invisibilidad {
    private UsaMementoInvisibilidad originador;
    private MementoInvisibilidad memento;
    private boolean invisible;

    public Invisibilidad(UsaMementoInvisibilidad originador) {
        invisible = true;
        this.originador = originador;
    }

    public boolean invisible(ArrayList<RevelaEntidades> reveladores, Posicion posicion) {
        for (RevelaEntidades revelador : reveladores) {
            if (!revelador.fueraDeRango(posicion)) {
                return false;
            }
        }
        return true;
    }

    public void actualizarEstado(ArrayList<RevelaEntidades> reveladores, Posicion posicion) {
        if (!invisible(reveladores, posicion) && invisible) {
            memento = originador.guardarEstado();
            this.invisible = false;
        } else if (invisible(reveladores, posicion) && !invisible) {
            originador.restaurarEstado(memento);
            this.invisible = true;
        }
    }

    //La idea de este metodo es contemplar el caso en que un Zealot gana el status de invisible cuando esta siendo
    //revelado.
    public void sincronizarEstado() {
        if (!invisible) {
            MementoInvisibilidad mementoAnterior = memento;
            memento = originador.guardarEstado();
            originador.restaurarEstado(mementoAnterior);
        }
    }
}