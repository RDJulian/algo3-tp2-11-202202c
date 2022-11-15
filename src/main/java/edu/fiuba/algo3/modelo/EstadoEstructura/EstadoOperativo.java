package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public interface EstadoOperativo {
    void operar(Estructura estructura);

    void pasarTurno(Estructura estructura, Vida vida, Defensa defensa);

    void atacable();
}
