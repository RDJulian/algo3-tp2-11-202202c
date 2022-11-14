package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public interface EstadoEnergetico { //Esta interfaz se creo para las estructuras Protoss

    void operar(Estructura estructura, EstadoOperativo estadoOperativo);

    void pasarTurno(Estructura estructura, EstadoOperativo estadoOperativo, Vida vida, Defensa defensa);
}
