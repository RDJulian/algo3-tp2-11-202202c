package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Exceptions.EstructuraNoOperativaException;

public class EnConstruccion implements EstadoEstructura {

    public void efectuarEstado(){
        throw new EstructuraNoOperativaException();
    };

    public void pasarTurnoCon(Estructura estructura) {
        estructura.pasarTurnoEnConstruccion();
    };
}
