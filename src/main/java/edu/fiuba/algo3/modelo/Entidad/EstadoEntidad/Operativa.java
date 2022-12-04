package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Operativa implements EstadoOperativo {
    @Override
    public void operable() {

    }

    @Override
    public EstadoOperativo pasarTurno(Vida vida, Defensa defensa) {
        vida.regenerar();
        defensa.regenerar();
        return this;
    }

    @Override
    public void atacable() {
    }

    @Override
    public int afectarSuministro(RolEnSuministro rol, int suministro) {
        return rol.afectarSuministro(suministro);
    }
}
