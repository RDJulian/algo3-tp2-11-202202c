package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.Volcan;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.ConstruibleEnVolcan;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLleno;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;

import java.util.Vector;

public class Extractor extends Estructura{
    private final Volcan volcan;
    private Vector<Zangano> zanganos;
    private ReservaGas reservaGas;

    public Extractor(CeldaDeTerreno celdaDeTerreno, ReservaGas reservaGas){
        CompatibilidadDeTerreno compatibilidad = new ConstruibleEnVolcan();
        this.volcan = (Volcan) celdaDeTerreno.verificarCompatibilidad(compatibilidad);
        this.tiempoConstruccionRestante = 6;
        this.zanganos = new Vector<Zangano>(0);
        this.reservaGas = reservaGas;
    }

    @Override
    public void pasarTurnoOperativo() {
        for (Zangano zangano : zanganos){
            zangano.extraerGas(this.volcan, this.reservaGas);
        }
    }

    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3){
            throw new ExtractorLleno();
        }
        this.zanganos.add(zangano);
    }

}
