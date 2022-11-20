package edu.fiuba.algo3.modelo.EstadoEntidad;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraNoOperativaException;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class EnConstruccion implements EstadoEntidad {
    private int tiempoParaOperar;

    public EnConstruccion(int tiempoParaOperar) {
        this.tiempoParaOperar = tiempoParaOperar;
    }

    @Override
    public void operable() {
        throw new EstructuraNoOperativaException();
    }

    @Override
    public void pasarTurno(Estructura estructura, Vida vida, Defensa defensa) {
        this.tiempoParaOperar -= 1;
        if (this.tiempoParaOperar == 0) {
            estructura.setEstado(new Operativa());
        }
        vida.regenerar();
        defensa.regenerar();
    }

    @Override
    public void atacable() {
    }
}