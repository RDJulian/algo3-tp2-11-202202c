package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Excepciones.ExtractorLleno;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;

import java.util.Vector;

public class Extractor extends Estructura{
    private GasVespeno gasVespeno;
    private Vector<Zangano> zanganos;

    public Extractor(){
        this.tiempoConstruccionRestante = 6;
        this.zanganos = new Vector<Zangano>(0);
    }

    @Override
    public void pasarTurnoOperativo() {
        for (Zangano zangano : zanganos){
            zangano.extraerGas(this.gasVespeno);
        }
    }

    @Override
    public void construirEnGasVespeno(GasVespeno gasVespeno) {
        this.gasVespeno = gasVespeno;
    }

    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3){
            throw new ExtractorLleno();
        }
        this.zanganos.add(zangano);
    }
}
