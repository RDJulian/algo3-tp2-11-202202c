package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.ConstruibleEnLlanura;
import edu.fiuba.algo3.modelo.Excepciones.FueraDeRangoDelPilon;

public class Acceso extends Estructura{

    public Acceso(CeldaDeTerreno celdaDeTerreno){
        CompatibilidadDeTerreno compatibilidad = new ConstruibleEnLlanura();
        this.celdaDeTerreno = celdaDeTerreno.verificarCompatibilidad(compatibilidad);
        int cantEnergia = celdaDeTerreno.getEnergiaPresente();
        if (cantEnergia<1){throw new FueraDeRangoDelPilon();}
    }
    @Override
    public void pasarTurnoOperativo() {

    }
}
