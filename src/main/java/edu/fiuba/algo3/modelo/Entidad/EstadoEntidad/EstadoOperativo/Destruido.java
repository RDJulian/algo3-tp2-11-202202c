package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Destruido implements EstadoOperativo {
    @Override
    public void operable(Comando comando) {
        throw new EntidadDestruidaException();
    }

    @Override
    public EstadoOperativo pasarTurno(Vida vida, Defensa defensa, Comando comando) {
        return this;
    }

    @Override
    public void atacable(Comando comando) {
        throw new EntidadDestruidaException();
    }

    @Override
    public int afectarSuministro(AfectaSuministro rol, int suministro) {
        return suministro;
    }
}
