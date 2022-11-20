package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso4Test {

    @Test
    public void test01UnExtractorNoGeneraGasSinZanganos() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno();
        Reserva reserva = new Reserva();
        Extractor extractor = new Extractor(posicion, gasVespeno, reserva);

        pasarKTurnos(extractor, 6);

        extractor.pasarTurno();

        assertEquals(reserva.getRecurso(), 0);
    }

    @Test
    public void test02UnExtractorGeneraDiezGasConUnZangano() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno();
        Reserva reserva = new Reserva();
        Extractor extractor = new Extractor(posicion, gasVespeno, reserva);

        pasarKTurnos(extractor, 6);

        extractor.agregarZangano(new Zangano());
        extractor.pasarTurno();

        assertEquals(reserva.getRecurso(), 10);
    }

    @Test
    public void test03UnExtractorGeneraVeinteGasConDosZanganos() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno();
        Reserva reserva = new Reserva();
        Extractor extractor = new Extractor(posicion, gasVespeno, reserva);

        pasarKTurnos(extractor, 6);

        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.pasarTurno();

        assertEquals(reserva.getRecurso(), 20);
    }

    @Test
    public void test04UnExtractorGeneraTreintaGasConTresZanganos() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno();
        Reserva reserva = new Reserva();
        Extractor extractor = new Extractor(posicion, gasVespeno, reserva);

        pasarKTurnos(extractor, 6);

        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.pasarTurno();

        assertEquals(reserva.getRecurso(), 30);
    }

    @Test
    public void test05UnExtractorNoAdmiteMasDeTresZanganos() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno();
        Reserva reserva = new Reserva();
        Extractor extractor = new Extractor(posicion, gasVespeno, reserva);

        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());

        assertThrows(ExtractorLlenoException.class, () -> extractor.agregarZangano(new Zangano()));
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}