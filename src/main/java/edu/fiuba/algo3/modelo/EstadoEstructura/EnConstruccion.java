package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraNoOperativa;

public class EnConstruccion implements EstadoEstructura {

    public void efectuarEstado(){
        throw new EstructuraNoOperativa();
    };

    public void pasarTurnoCon(Estructura estructura) {
        estructura.pasarTurnoEnConstruccion();
    };
}
