package edu.fiuba.algo3.modelo.CompatibilidadDeTerreno;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.TerrenoLlano;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.Volcan;
import edu.fiuba.algo3.modelo.Excepciones.TerrenoIncompatible;

public class ConstruibleEnLlanura implements CompatibilidadDeTerreno{
    @Override
    public CeldaDeTerreno obtenerTerrenoLlano(TerrenoLlano terrenoLlano) {
        return terrenoLlano;
    }

    @Override
    public CeldaDeTerreno obtenerVolcan(Volcan volcan) {
        throw new TerrenoIncompatible();
    }
}
