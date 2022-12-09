package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso15Test {
    @Test
    public void test01ElMineralSePuedeExtraerHastaQueSeQuedeVacioYLuegoNoSePuedeSeguirExtrayendo() {
        Raza raza = new Raza();
        Posicion posicion = new Posicion(0, 0);
        Recurso mineral = new Mineral(posicion);
        NexoMineral nexoMineral = new NexoMineral(posicion, raza, mineral);
        pasarKTurnos(nexoMineral, 4);

        pasarKTurnos(nexoMineral, 99);

        assertDoesNotThrow(nexoMineral::pasarTurno);
        assertThrows(RecursoVacioException.class, nexoMineral::pasarTurno);
    }

    @Test
    public void test02ElGasVespenoSePuedeExtraerHastaQueSeQuedeVacioYLuegoNoSePuedeSeguirExtrayendo() {
        Raza raza = new Raza();
        Posicion posicion = new Posicion(0, 0);
        Recurso mineral = new GasVespeno(posicion);
        Extractor extractor = new Extractor(posicion, raza, mineral);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano();
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);

        pasarKTurnos(extractor, 249);

        assertDoesNotThrow(extractor::pasarTurno);
        assertThrows(RecursoVacioException.class, extractor::pasarTurno);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
