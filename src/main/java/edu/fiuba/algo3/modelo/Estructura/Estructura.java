package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoOperativo;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public abstract class Estructura {
    protected Posicion posicion;
    protected EstadoOperativo estado;
    protected Construible construible;

    public Estructura(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setEstado(EstadoOperativo estado) {
        this.estado = estado;
    }

    public void pasarTurno() {
        this.estado.pasarTurno(this);
    }

    public void operar() {
        this.estado.operar(this);
    }

    public abstract void efectuarOperacion();

    public abstract void pasarTurnoOperativo();

    public void construir(Recurso recurso) {
        construible.construible(recurso);
    }
}