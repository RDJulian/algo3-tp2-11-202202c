package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.SinEnergia;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.Memento;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.UsaMemento;

import java.util.ArrayList;

public abstract class EstructuraEnergizada extends Estructura implements UsaMemento {
    protected Memento memento;
    protected Energia energia;

    @Override
    public void guardarEstado() {
        this.memento = new Memento(estadoEntidad);
        this.estadoEntidad = new SinEnergia();
    }

    @Override
    public void restaurarEstado() {
        this.estadoEntidad = memento.restaurar();
    }

    public void actualizarEstado(ArrayList<Pilon> pilones) {
        energia.actualizarEstado(pilones, posicion, this);
    }
}
