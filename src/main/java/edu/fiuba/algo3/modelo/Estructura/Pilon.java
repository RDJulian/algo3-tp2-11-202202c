package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.ConstruibleEnLlanura;
import edu.fiuba.algo3.modelo.Mundo.Cuadricula;

public class Pilon extends Estructura{
    private Cuadricula rango;

    public Pilon(Cuadricula rango) {
        CompatibilidadDeTerreno compatibilidad = new ConstruibleEnLlanura();
        this.celdaDeTerreno = rango.verificarCompatibilidad(compatibilidad);
        this.rango = rango;
        this.rango.energizar();
    }

    @Override
    public void pasarTurnoOperativo() {

    }
}
