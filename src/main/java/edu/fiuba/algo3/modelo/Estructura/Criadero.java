package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;

public class Criadero extends Estructura {

    private Integer cantidadLarvas;

    public Criadero(Posicion posicion) {
        super(posicion);
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


    public void construirEnGasVespeno(GasVespeno gasVespeno) {
        throw new ConstruccionNoValida();
    }


    public void construir(Moho moho) {
        moho.enRango(this.posicion);
    }
}
