package edu.fiuba.algo3.modelo.Entidad.Invisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Invisibilidad.EstadoInvisibilidad.EstadoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.RevelaEntidades;
import edu.fiuba.algo3.modelo.Area.Area;

import java.util.ArrayList;

public class Invisibilidad {
    private UsaMementoInvisibilidad originador;
    private EstadoInvisibilidad invisibilidad;

    public Invisibilidad(UsaMementoInvisibilidad originador) {
        this.invisibilidad = new Invisible();
        this.originador = originador;
    }

    public EstadoInvisibilidad invisible(ArrayList<RevelaEntidades> reveladores, Area area) {
        boolean invisible = true;
        int i = 0;
        while (invisible && i < reveladores.size()) {
            invisible = reveladores.get(i).revelar(area);
            i++;
        }
        if (invisible) {
            return invisibilidad.ocultar();
        } else {
            return invisibilidad.revelar();
        }
    }

    public void actualizarEstado(ArrayList<RevelaEntidades> reveladores, Area area) {
        EstadoInvisibilidad estadoAnterior = invisibilidad;
        invisibilidad = invisible(reveladores, area);
        if (estadoAnterior != invisibilidad) {
            invisibilidad.actualizarEstado(originador);
        }
    }

    //La idea de este metodo es contemplar el caso en que un Zealot gana el status de invisible cuando esta siendo
    //revelado.
    public void sincronizarEstado() {
        invisibilidad.sincronizarEstado(originador);
    }
}