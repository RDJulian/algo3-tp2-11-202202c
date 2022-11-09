package edu.fiuba.algo3.modelo.CompatibilidadDeTerreno;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.TerrenoLlano;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.Volcan;

public interface CompatibilidadDeTerreno {
    CeldaDeTerreno obtenerTerrenoLlano(TerrenoLlano terrenoLlano);

    CeldaDeTerreno obtenerVolcan(Volcan volcan);
}
