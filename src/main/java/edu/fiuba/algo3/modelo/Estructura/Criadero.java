package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;

import edu.fiuba.algo3.modelo.Exceptions.CombinacionDeEstructurasInvalida;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Zangano;

public class Criadero extends Estructura{

    private Integer cantidadLarvas;

    public Criadero(){

        this.cantidadLarvas = 3;
        this.estado = new EnConstruccion();
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


    public void construirEnGasVespeno(GasVespeno gasVespeno) {
        throw new CombinacionDeEstructurasInvalida();
    }


}
