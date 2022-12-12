package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.ComandoBool;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.Escudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Vida;

public class Operativa implements EstadoOperativo {
    @Override
    public void operable(Comando comando) {
        comando.ejecutar();
    }

    @Override
    public boolean operable(ComandoBool comando) {
        return comando.ejecutar();
    }

    @Override
    public EstadoOperativo pasarTurno(Vida vida, Escudo escudo, Comando comandoAlPasarTurno) {
        vida.regenerar();
        escudo.regenerar();
        comandoAlPasarTurno.ejecutar();
        return this;
    }

    @Override
    public void atacable(Comando comandoAtaque) {
        comandoAtaque.ejecutar();
    }

    @Override
    public int afectarSuministro(AfectaSuministro afectaSuministro, int suministro) {
        return afectaSuministro.afectarSuministro(suministro);
    }
}
