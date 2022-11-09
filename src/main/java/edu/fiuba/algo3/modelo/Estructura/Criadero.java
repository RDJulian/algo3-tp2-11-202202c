package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.ConstruibleEnLlanura;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;

public class Criadero extends Estructura{

    private Integer cantidadLarvas;

    public Criadero(CeldaDeTerreno celdaDeTerreno){
        CompatibilidadDeTerreno compatibilidad = new ConstruibleEnLlanura();
        this.celdaDeTerreno = celdaDeTerreno.verificarCompatibilidad(compatibilidad);
        this.cantidadLarvas = 3;
        this.tiempoConstruccionRestante = 4;
    }

    public Integer getLarvas() {
        return cantidadLarvas;
    }

    public Zangano engendrarZangano() {
        this.estado.efectuarEstado();
        this.cantidadLarvas -= 1;
        return new Zangano();
    }

    public void pasarTurnoOperativo() {
        this.cantidadLarvas += 1;
    }

}
