package edu.fiuba.algo3.modelo.EstadoEntidad;

import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class EnConstruccion implements EstadoEntidad {
    private int tiempoParaOperar;

    public EnConstruccion(int tiempoParaOperar) {
        this.tiempoParaOperar = tiempoParaOperar;
    }

    @Override
    public void operable() {
        throw new EntidadNoOperativaException();
    }

    @Override
    public void pasarTurno(Estructura estructura, Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa) {
        this.tiempoParaOperar -= 1;
        if (this.tiempoParaOperar == 0) {
            estructura.setEstado(new Operativa());
        }
        vida.regenerar();
        defensa.regenerar();
    }

    @Override
    public void pasarTurno(Unidad unidad, Vida vida, Defensa defensa) {
        this.tiempoParaOperar -= 1;
        if (this.tiempoParaOperar == 0) {
            unidad.setEstado(new Operativa());
        }
        vida.regenerar();
        defensa.regenerar();
    }

    @Override
    public void atacable() {
    }
}