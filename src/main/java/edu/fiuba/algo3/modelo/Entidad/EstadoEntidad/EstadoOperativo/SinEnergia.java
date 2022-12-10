package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Vida.Defensa;
import edu.fiuba.algo3.modelo.Entidad.Vida.Vida;

public class SinEnergia implements EstadoOperativo {
    //Supuesto: una estructura Protoss sin energia (Acceso y Puerto Estelar) no pueden hacer nada
    //cuando no estan en el rango de un Pilon. Esto significa que su escudo no puede regenerarse.
    //Se agrega que no pueden sumar suministro si esta sin energia.
    @Override
    public void operable(Comando comando) {
        throw new EntidadNoOperativaException();
    }

    @Override
    public EstadoOperativo pasarTurno(Vida vida, Defensa defensa, Comando comando) {
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