package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Operativa extends EstadoEntidad {
    public Operativa(RolEnSuministro rol) {
        super(rol);
    }

    @Override
    public void operable() {
    }

    @Override
    public EstadoEntidad pasarTurno(Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa) {
        vida.regenerar();
        defensa.regenerar();
        accionAlPasarTurno.ejecutar();
        return this;
    }

    @Override
    public void atacable() {
    }

    @Override
    public int afectarSuministro(int suministro) {
        return rol.afectarSuministro(suministro);
    }
}
