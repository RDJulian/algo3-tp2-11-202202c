package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoOperativo;
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

    //Esta solucion ya no es valida porque las posiciones tienen un estado. Ver como relacionar con eso
    private boolean energizado(ArrayList<Pilon> pilones, Posicion posicion) {
        return true;
    }

    public void actualizarEstado(ArrayList<Pilon> pilones, Posicion posicion) {

    }
}
