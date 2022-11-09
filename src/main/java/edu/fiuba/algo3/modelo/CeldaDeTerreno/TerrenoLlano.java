package edu.fiuba.algo3.modelo.CeldaDeTerreno;

import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;

public class TerrenoLlano extends CeldaDeTerreno {

    public CeldaDeTerreno verificarCompatibilidad(CompatibilidadDeTerreno compatibilidad) {
        return compatibilidad.obtenerTerrenoLlano(this);
    }
}
