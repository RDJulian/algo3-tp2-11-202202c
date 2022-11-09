package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.Volcan;
import edu.fiuba.algo3.modelo.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Extractor;
import edu.fiuba.algo3.modelo.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Excepciones.TerrenoIncompatible;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {

    @Test
    public void test01CriaderoNoSePuedeConstruirSobreElGasVespeno(){
        assertThrows(TerrenoIncompatible.class, () -> {
            new Criadero(new Volcan());
        });
    }

    @Test
    public void test02ExtractorSePuedeConstruirSobreElGasVespeno(){
        assertDoesNotThrow(() -> {
            new Extractor(new Volcan(), new ReservaGas());
        });
    }

    @Test
    public void test03AsimiladorSePuedeConstruirSobreElGasVespeno(){
        assertDoesNotThrow(() -> {
            new Asimilador(new Volcan(), new ReservaGas());
        });
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
