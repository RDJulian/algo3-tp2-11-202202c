package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Vida.Defensa;
import edu.fiuba.algo3.modelo.Entidad.Vida.Vida;

public class Operativa implements EstadoOperativo {
    @Override
    public void operable(Comando comando) {
        comando.ejecutar();
    }

    @Override
    public EstadoOperativo pasarTurno(Vida vida, Defensa defensa, Comando comando) {
        vida.regenerar();
        defensa.regenerar();
        comando.ejecutar();
        return this;
    }

    @Override
    public void atacable(Comando comando) {
        comando.ejecutar();
    }

    @Override
    public int afectarSuministro(AfectaSuministro rol, int suministro) {
        return rol.afectarSuministro(suministro);
    }
}
