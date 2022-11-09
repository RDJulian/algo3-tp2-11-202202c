package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEstructura;
import edu.fiuba.algo3.modelo.EstadoEstructura.Operativo;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;

public abstract class Estructura {
    protected Posicion posicion;

    //No deberia estar aca. Deberia ser parte del estado.
    protected Integer tiempoConstruccionRestante;
    protected EstadoEstructura estado;

    public Estructura(Posicion posicion) {
        this.posicion = posicion;
        this.estado = new EnConstruccion();
    }

    public void pasarTurno() {
        this.estado.pasarTurnoCon(this);
    }

    public abstract void pasarTurnoOperativo();

    public void pasarTurnoEnConstruccion() {
        this.tiempoConstruccionRestante -= 1;
        if (this.tiempoConstruccionRestante == 0) this.estado = new Operativo();
    }

    //Este metodo es muy especifico para que este declarado en una abstraccion.
    // Son las estructuras las que deberian saber si se pueden construir o no dependiendo de lo que necesiten.
    public abstract void construirEnGasVespeno(GasVespeno gasVespeno);
}
