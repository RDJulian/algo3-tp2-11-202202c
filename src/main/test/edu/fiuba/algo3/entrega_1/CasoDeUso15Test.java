package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacio;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso15Test { //Se deberia resumir o setear directamente los estados para ahorrar lineas de codigo.
    @Test
    public void test01ElMineralSePuedeExtraerHastaQueSeQuedeVacioYLuegoNoSePuedeSeguirExtrayendo() {
        Recurso mineral = new Mineral();
        Pilon pilon = new Pilon(new Posicion(0, 0));
        Estructura nexoMineral = new NexoMineral(new Posicion(0, 0), new Reserva());

        pasarKTurnos(pilon, 5);
        nexoMineral.construible(pilon);
        nexoMineral.construible(mineral);
        pasarKTurnos(nexoMineral, 4);

        pasarKTurnos(nexoMineral, 99);

        assertDoesNotThrow(nexoMineral::pasarTurno);

        assertThrows(RecursoVacio.class, nexoMineral::pasarTurno);
    }

    @Test
    public void test02ElGasVespenoSePuedeExtraerHastaQueSeQuedeVacioYLuegoNoSePuedeSeguirExtrayendo() {
        Recurso mineral = new GasVespeno();
        Extractor extractor = new Extractor(new Posicion(0, 0), new Reserva());
        extractor.construible(mineral);
        pasarKTurnos(extractor, 6);
        extractor.agregarZangano(new Zangano());
        extractor.agregarZangano(new Zangano());

        pasarKTurnos(extractor, 249);

        assertDoesNotThrow(extractor::pasarTurno);

        assertThrows(RecursoVacio.class, extractor::pasarTurno);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
