package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Extractor;
import edu.fiuba.algo3.modelo.Exceptions.CombinacionDeEstructurasInvalida;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {

    @Test
    public void test01CriadoNoSePuedeConstruirSobreElGasVespeno(){
        Criadero criadero = new Criadero();
        GasVespeno gasVespeno = new GasVespeno();
        assertThrows(CombinacionDeEstructurasInvalida.class, () -> {
            gasVespeno.agregarRefineria(criadero);
        });
    }

    @Test
    public void test02ExtractorPuedeConstruirseSobreElGasVespeno(){
        Extractor extractor = new Extractor();
        pasarKTurnos(extractor, 4);
        GasVespeno gasVespeno = new GasVespeno();
        assertThrows(CombinacionDeEstructurasInvalida.class, () -> {
            gasVespeno.agregarRefineria(extractor);
        });
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}