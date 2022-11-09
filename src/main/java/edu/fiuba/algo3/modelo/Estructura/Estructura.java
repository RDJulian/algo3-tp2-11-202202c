package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEstructura;
import edu.fiuba.algo3.modelo.EstadoEstructura.Operativo;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;

public abstract class Estructura {

    protected Integer tiempoConstruccionRestante;
    protected EstadoEstructura estado;
    protected CeldaDeTerreno celdaDeTerreno;

    public Estructura(){
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
}
