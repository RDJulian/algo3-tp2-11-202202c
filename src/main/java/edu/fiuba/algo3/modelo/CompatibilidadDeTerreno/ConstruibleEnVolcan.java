package edu.fiuba.algo3.modelo.CompatibilidadDeTerreno;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.TerrenoLlano;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.Volcan;
import edu.fiuba.algo3.modelo.Excepciones.TerrenoIncompatible;

public class ConstruibleEnVolcan implements CompatibilidadDeTerreno{
    @Override
    public CeldaDeTerreno obtenerTerrenoLlano(TerrenoLlano terrenoLlano) {
        throw new TerrenoIncompatible();
    }

    @Override
    public CeldaDeTerreno obtenerVolcan(Volcan volcan) {
        return volcan;
    }
}
