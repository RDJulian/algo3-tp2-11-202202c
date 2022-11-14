package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraDestruida;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Destruido implements EstadoOperativo {
    @Override
    public void operar(Estructura estructura) {
        throw new EstructuraDestruida();
    }

    @Override
    public void pasarTurno(Estructura estructura, Vida vida, Defensa defensa) {

    }
}
