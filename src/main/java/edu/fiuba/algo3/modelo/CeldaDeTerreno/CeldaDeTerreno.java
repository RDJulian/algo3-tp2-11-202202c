package edu.fiuba.algo3.modelo.CeldaDeTerreno;

import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;
import edu.fiuba.algo3.modelo.Cubierta.Cubierta;
import edu.fiuba.algo3.modelo.Mundo.Cuadricula;

public abstract class CeldaDeTerreno {

    private CeldaDeTerreno celdaSuperior;
    private CeldaDeTerreno celdaInferior;
    protected Cubierta cubierta;

    public CeldaDeTerreno getCeldaSuperior() {
        return celdaSuperior;
    }

    public CeldaDeTerreno getCeldaInferior() {
        return celdaInferior;
    }

    public void expandirPorAbajo(CeldaDeTerreno celdaInf){
        this.celdaInferior = celdaInf;
        celdaInf.setCeldaSuperior(this);
    }

    public void setCeldaSuperior(CeldaDeTerreno celdaSup){
        this.celdaSuperior = celdaSup;
    }

    public abstract CeldaDeTerreno verificarCompatibilidad(CompatibilidadDeTerreno compatibilidad);

    public void energizar() {
        this.cubierta = cubierta.energizar();
    }

    public int getEnergiaPresente() {return this.cubierta.getEnergiaPresente();}
}
