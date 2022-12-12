package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.ComandoBool;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.Escudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Vida;

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
    public boolean operable(ComandoBool comando) {
        throw new EntidadNoOperativaException();
    }

    @Override
    public EstadoOperativo pasarTurno(Vida vida, Escudo escudo, Comando comandoAlPasarTurno) {
        vida.regenerar();
        escudo.regenerar();
        tiempoParaOperar -= 1;
        if (tiempoParaOperar == 0) {
            return new Operativa();
        }
        return this;
    }

    @Override
    public void atacable(Comando comandoAtaque) {
        comandoAtaque.ejecutar();
    }

    @Override
    public int afectarSuministro(AfectaSuministro afectaSuministro, int suministro) {
        return suministro;
    }
}