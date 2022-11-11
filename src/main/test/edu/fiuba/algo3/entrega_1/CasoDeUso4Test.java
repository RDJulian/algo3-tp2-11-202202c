package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLleno;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso4Test {

    @Test
    public void test01UnExtractorNoGeneraGasSinZanganos() {
        GasVespeno gasVespeno = new GasVespeno();
        ReservaGas reservaGas = new ReservaGas();
        Extractor extractor = new Extractor(new Posicion(0, 0), reservaGas);
        extractor.construible(gasVespeno);

        pasarKTurnos(extractor, 6);

        extractor.pasarTurno();

        assertEquals(reservaGas.getRecurso(), 0);
    }

    @Test
    public void test02UnExtractorGeneraDiezGasConUnZangano() {
        GasVespeno gasVespeno = new GasVespeno();
        ReservaGas reservaGas = new ReservaGas();
        Extractor extractor = new Extractor(new Posicion(0, 0), reservaGas);
        extractor.construible(gasVespeno);

        pasarKTurnos(extractor, 6);

        extractor.agregarZangano(new Zangano());
        extractor.pasarTurno();

        assertEquals(reservaGas.getRecurso(), 10);
    }

    @Test
    public void test03UnExtractorGeneraVeinteGasConDosZanganos() {
        GasVespeno gasVespeno = new GasVespeno();
        ReservaGas reservaGas = new ReservaGas();
        Extractor extractor = new Extractor(new Posicion(0, 0), reservaGas);
        extractor.construible(gasVespeno);

        pasarKTurnos(extractor, 6);

        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.pasarTurno();

        assertEquals(reservaGas.getRecurso(), 20);
    }

    @Test
    public void test04UnExtractorGeneraTreintaGasConTresZanganos() {
        GasVespeno gasVespeno = new GasVespeno();
        ReservaGas reservaGas = new ReservaGas();
        Extractor extractor = new Extractor(new Posicion(0, 0), reservaGas);
        extractor.construible(gasVespeno);

        pasarKTurnos(extractor, 6);

        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.pasarTurno();

        assertEquals(reservaGas.getRecurso(), 30);
    }

    @Test
    public void test05UnExtractorNoAdmiteMasDeTresZanganos() {
        GasVespeno gasVespeno = new GasVespeno();
        ReservaGas reservaGas = new ReservaGas();
        Extractor extractor = new Extractor(new Posicion(0, 0), reservaGas);
        pasarKTurnos(extractor, 6);
        extractor.construible(gasVespeno);

        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());

        assertThrows(ExtractorLleno.class, () -> {
            extractor.agregarZangano(new Zangano());
        });
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}