package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.UsaMementoOperativo;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public class Energia {
    private UsaMementoOperativo originador;
    protected MementoOperativo memento;
    private boolean energizado;

    public Energia(UsaMementoOperativo originador) {
        energizado = true;
        this.originador = originador;
    }

    private boolean energizado(ArrayList<Pilon> pilones, Posicion posicion) {
        for (Pilon pilon : pilones) {
            if (!pilon.fueraDeRango(posicion)) {
                return true;
            }
        }
        return false;
    }

    public void actualizarEstado(ArrayList<Pilon> pilones, Posicion posicion) {
        if (!energizado(pilones, posicion) && energizado) {
            memento = originador.guardarEstado();
            this.energizado = false;
        } else if (energizado(pilones, posicion) && !energizado) {
            originador.restaurarEstado(memento);
            this.energizado = true;
        }
    }
}
