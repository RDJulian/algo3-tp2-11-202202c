package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoOperativo;
import edu.fiuba.algo3.modelo.Area.Area;

import java.util.ArrayList;

public class Energia {
    private UsaMementoOperativo originador;
    protected MementoOperativo memento;
    private boolean energizado;

    public Energia(UsaMementoOperativo originador) {
        energizado = true;
        this.originador = originador;
    }

    public void actualizarEstado(Area area) {

    }
}
