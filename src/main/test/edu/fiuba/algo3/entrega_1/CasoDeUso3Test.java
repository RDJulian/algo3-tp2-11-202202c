package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Extractor;
import edu.fiuba.algo3.modelo.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {

    @Test
    public void test01CriaderoNoSePuedeConstruirSobreElGasVespeno() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        GasVespeno gasVespeno = new GasVespeno();
        assertThrows(ConstruccionNoValida.class, () -> {
            gasVespeno.agregarRefineria(criadero);
        });
    }

    @Test
    public void test02ExtractorSePuedeConstruirSobreElGasVespeno() {
        Extractor extractor = new Extractor(new Posicion(0, 0), new ReservaGas());
        GasVespeno gasVespeno = new GasVespeno();
        assertDoesNotThrow(() -> {
            gasVespeno.agregarRefineria(extractor);
        });
    }

    @Test
    public void test03AsimiladorSePuedeConstruirSobreElGasVespeno() {
        Asimilador asimilador = new Asimilador(new Posicion(0, 0));
        GasVespeno gasVespeno = new GasVespeno();
        assertDoesNotThrow(() -> {
            gasVespeno.agregarRefineria(asimilador);
        });
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
