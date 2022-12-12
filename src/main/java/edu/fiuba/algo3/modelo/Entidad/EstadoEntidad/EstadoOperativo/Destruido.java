package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.ComandoBool;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.Escudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Vida;

public class Destruido implements EstadoOperativo {
    @Override
    public void operable(Comando comando) {
        throw new EntidadDestruidaException();
    }

    @Override
    public boolean operable(ComandoBool comando) {
        throw new EntidadDestruidaException();
    }

    @Override
    public EstadoOperativo pasarTurno(Vida vida, Escudo escudo, Comando comandoAlPasarTurno) {
        return this;
    }

    @Override
    public void atacable(Comando comandoAtaque) {
        throw new EntidadDestruidaException();
    }

    @Override
    public int afectarSuministro(AfectaSuministro afectaSuministro, int suministro) {
        return suministro;
    }
}
