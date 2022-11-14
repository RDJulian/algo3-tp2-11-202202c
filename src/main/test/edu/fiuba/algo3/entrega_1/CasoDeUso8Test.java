package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficiente;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso8Test {

    @Test
    public void test01AccesoSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new Acceso();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 50);
        assertEquals(reservaGas.getRecurso(), 200);
    }

    @Test
    public void test02AsimiladorSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new Asimilador();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 100);
        assertEquals(reservaGas.getRecurso(), 200);
    }

    @Test
    public void test03CriaderoSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new Criadero();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 150);
        assertEquals(reservaGas.getRecurso(), 200);
    }

    @Test
    public void test04EspiralSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new Espiral();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 50);
        assertEquals(reservaGas.getRecurso(), 100);
    }

    @Test
    public void test05ExtractorSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new Extractor();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 100);
        assertEquals(reservaGas.getRecurso(), 200);
    }

    @Test
    public void test06GuaridaSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new Guarida();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 0);
        assertEquals(reservaGas.getRecurso(), 100);
    }

    @Test
    public void test07NexoMineralSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new NexoMineral();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 150);
        assertEquals(reservaGas.getRecurso(), 200);
    }

    @Test
    public void test08PilonSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new Pilon();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 100);
        assertEquals(reservaGas.getRecurso(), 200);
    }

    @Test
    public void test09PuertoEstelarSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new PuertoEstelar();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 50);
        assertEquals(reservaGas.getRecurso(), 50);
    }

    @Test
    public void test10ReservaDeReproduccionSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        Estructura estructura = new ReservaDeReproduccion();

        assertThrows(RecursoInsuficiente.class, () -> estructura.construible(reservaMineral, reservaGas));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> estructura.construible(reservaMineral, reservaGas));
        assertEquals(reservaMineral.getRecurso(), 50);
        assertEquals(reservaGas.getRecurso(), 200);
    }
}
