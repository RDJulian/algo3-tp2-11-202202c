package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso7Test {

    @Test
    public void test01ZanganoObtieneMineralCorrectamenteParaLosZerg() {
        Raza raza = new Raza();
        Posicion posicion = new Posicion(0, 0);
        Recurso mineral = new Mineral(posicion);
        Zangano zangano = new Zangano(posicion, raza);

        zangano.pasarTurno();
        zangano.ocupar(mineral);
        zangano.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(11, 0));
        assertDoesNotThrow(() -> raza.gastarRecursos(10, 0));
    }

    @Test
    public void test02ExtractorObtieneGasCorrectamenteParaLosZerg() {
        Raza raza = new Raza();
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno(posicion);
        Extractor extractor = new Extractor(posicion, gasVespeno, raza);

        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(posicion, raza);
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);

        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 11));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 10));
    }

    @Test
    public void test03NexoMineralObtieneMineralCorrectamenteParaLosProtoss() {
        Raza raza = new Raza();
        Posicion posicion = new Posicion(0, 0);
        Mineral mineral = new Mineral(posicion);
        NexoMineral nexoMineral = new NexoMineral(posicion, mineral, raza);

        pasarKTurnos(nexoMineral, 4);

        nexoMineral.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(21, 0));
        assertDoesNotThrow(() -> raza.gastarRecursos(20, 0));
    }

    @Test
    public void test04AsimiladorObtieneGasCorrectamenteParaLosProtoss() {
        Raza raza = new Raza();
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno(posicion);
        Asimilador asimilador = new Asimilador(posicion, gasVespeno, raza);

        pasarKTurnos(asimilador, 6);

        asimilador.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 21));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 20));
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
