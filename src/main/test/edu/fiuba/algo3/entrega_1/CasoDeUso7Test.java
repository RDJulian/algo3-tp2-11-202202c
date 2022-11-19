package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso7Test {

    @Test
    public void test01ZanganoObtieneMineralCorrectamenteParaLosZerg() {
        Reserva reserva = new Reserva();
        Recurso mineral = new Mineral(new Posicion(0, 0));
        Zangano zangano = new Zangano();

        mineral.ocupar(zangano);
        zangano.extraerRecurso(mineral, reserva);

        assertEquals(reserva.getRecurso(), 10);
    }

    @Test
    public void test02ExtractorObtieneGasCorrectamenteParaLosZerg() {
        GasVespeno gasVespeno = new GasVespeno(new Posicion(0, 0));
        Reserva reserva = new Reserva();
        Extractor extractor = new Extractor(new Posicion(0, 0), gasVespeno, reserva);

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
        Recurso mineral = new Mineral(new Posicion(0, 0));
        NexoMineral nexoMineral = new NexoMineral(new Posicion(0, 0), mineral, reserva);

        pasarKTurnos(nexoMineral, 5);

        assertEquals(reserva.getRecurso(), 20);

        nexoMineral.pasarTurno();

        assertEquals(reserva.getRecurso(), 40);
    }

    @Test
    public void test04AsimiladorObtieneGasCorrectamenteParaLosZerg() {
        Reserva reserva = new Reserva();
        Recurso gasVespeno = new GasVespeno(new Posicion(0, 0));
        Asimilador asimilador = new Asimilador(new Posicion(0, 0), gasVespeno, reserva);

        pasarKTurnos(asimilador, 7);

        assertEquals(reserva.getRecurso(), 20);

        asimilador.pasarTurno();

        assertEquals(reserva.getRecurso(), 40);
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
