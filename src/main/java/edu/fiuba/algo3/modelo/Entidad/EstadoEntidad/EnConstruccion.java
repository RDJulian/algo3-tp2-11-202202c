package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.AccionAlPasarTurno;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class EnConstruccion extends EstadoEntidad {
    private int tiempoParaOperar;

    public EnConstruccion(int tiempoParaOperar) {
        this.tiempoParaOperar = tiempoParaOperar;
    }

    @Override
    public void operable() {
        throw new EntidadNoOperativaException();
    }

    @Override
    public EstadoEntidad pasarTurno(Vida vida, Defensa defensa) {
        vida.regenerar();
        defensa.regenerar();
        tiempoParaOperar -= 1;
        if (tiempoParaOperar == 0) {
            return new Operativa();
        }
        return this;
    }

    @Override
    public EstadoEntidad pasarTurno(Vida vida, Defensa defensa, AccionAlPasarTurno entidad) {
        vida.regenerar();
        defensa.regenerar();
        tiempoParaOperar -= 1;
        if (tiempoParaOperar == 0) {
            return new Operativa();
        }
        return this;
    }

    @Override
    public void atacable() {
    }

    @Override
    public int afectarSuministro(RolEnSuministro rol, int suministro) {
        return suministro;
    }
}