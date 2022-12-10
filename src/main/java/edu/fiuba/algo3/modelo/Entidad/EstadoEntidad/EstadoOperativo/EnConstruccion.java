package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Vida.Defensa;
import edu.fiuba.algo3.modelo.Entidad.Vida.Vida;

public class EnConstruccion implements EstadoOperativo {
    private int tiempoParaOperar;

    public EnConstruccion(int tiempoParaOperar) {
        this.tiempoParaOperar = tiempoParaOperar;
    }

    @Override
    public void operable(Comando comando) {
        throw new EntidadNoOperativaException();
    }

    @Override
    public EstadoOperativo pasarTurno(Vida vida, Defensa defensa, Comando comando) {
        vida.regenerar();
        defensa.regenerar();
        tiempoParaOperar -= 1;
        if (tiempoParaOperar == 0) {
            return new Operativa();
        }
        return this;
    }

    @Override
    public void atacable(Comando comando) {
        comando.ejecutar();
    }

    @Override
    public int afectarSuministro(AfectaSuministro rol, int suministro) {
        return suministro;
    }
}