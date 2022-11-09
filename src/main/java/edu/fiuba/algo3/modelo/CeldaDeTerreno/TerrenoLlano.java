package edu.fiuba.algo3.modelo.CeldaDeTerreno;

import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;
import edu.fiuba.algo3.modelo.Cubierta.Natural;

public class TerrenoLlano extends CeldaDeTerreno {

    public TerrenoLlano(){this.cubierta = new Natural();}
    public CeldaDeTerreno verificarCompatibilidad(CompatibilidadDeTerreno compatibilidad) {
        return compatibilidad.obtenerTerrenoLlano(this);
    }
}
