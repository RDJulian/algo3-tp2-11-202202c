package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso7Test {

    @Test
    public void test01ZanganoObtieneMineralCorrectamenteParaLosZerg() {
        Reserva reserva = new Reserva();
        Recurso mineral = new Mineral();
        Zangano zangano = new Zangano();

        zangano.extraerRecurso(mineral, reserva);

        assertEquals(reserva.getRecurso(), 10);
    }

    @Test
    public void test02ExtractorObtieneGasCorrectamenteParaLosZerg() {
        GasVespeno gasVespeno = new GasVespeno();
        Reserva reserva = new Reserva();
        Extractor extractor = new Extractor(new Posicion(0, 0), reserva);
        extractor.construible(gasVespeno);

        pasarKTurnos(extractor, 6);

        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());
        extractor.pasarTurno();

        assertEquals(reserva.getRecurso(), 30);

        extractor.pasarTurno();

        assertEquals(reserva.getRecurso(), 60);
    }

    @Test
    public void test03NexoMineralObtieneMineralCorrectamenteParaLosZerg() {
        Reserva reserva = new Reserva();
        Recurso mineral = new Mineral();
        Estructura estructura = new NexoMineral(new Posicion(0, 0), reserva);
        estructura.construible(mineral);

        pasarKTurnos(estructura, 5);

        assertEquals(reserva.getRecurso(), 20);

        estructura.pasarTurno();

        assertEquals(reserva.getRecurso(), 40);
    }

    @Test
    public void test04AsimiladorObtieneGasCorrectamenteParaLosZerg() {
        Reserva reserva = new Reserva();
        Recurso gasVespeno = new GasVespeno();
        Estructura estructura = new Asimilador(new Posicion(0, 0), reserva);
        estructura.construible(gasVespeno);

        pasarKTurnos(estructura, 7);

        assertEquals(reserva.getRecurso(), 20);

        estructura.pasarTurno();

        assertEquals(reserva.getRecurso(), 40);
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
