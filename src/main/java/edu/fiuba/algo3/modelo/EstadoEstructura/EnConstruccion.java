package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraNoOperativa;

public class EnConstruccion implements EstadoOperativo {
    private int tiempoParaOperar;

    public EnConstruccion(int tiempoParaOperar) {
        this.tiempoParaOperar = tiempoParaOperar;
    }

    public void operar(Estructura estructura) {
        throw new EstructuraNoOperativa();
    }

    public void pasarTurno(Estructura estructura) {
        this.tiempoParaOperar -= 1;
        if (this.tiempoParaOperar == 0) {
            estructura.setEstado(new Operativo());
        }
    }
}