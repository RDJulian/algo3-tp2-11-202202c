package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
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

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso7Test {

    @Test
    public void test01ZanganoObtieneMineralCorrectamenteParaLosZerg() {
        Raza raza = new Raza();
        Posicion posicion = new Posicion(0, 0);
        Recurso mineral = new Mineral(posicion);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        Zangano zangano = new Zangano(posicion, raza, estructuras);
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
        Recurso recurso = new GasVespeno(posicion);

        Extractor extractor = new Extractor(posicion, raza, recurso);

        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano();
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
        Recurso recurso = new Mineral(posicion);

        NexoMineral nexoMineral = new NexoMineral(posicion, raza, recurso);

        pasarKTurnos(nexoMineral, 4);

        nexoMineral.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(21, 0));
        assertDoesNotThrow(() -> raza.gastarRecursos(20, 0));
    }

    @Test
    public void test04AsimiladorObtieneGasCorrectamenteParaLosProtoss() {
        Raza raza = new Raza();
        Posicion posicion = new Posicion(0, 0);
        Recurso recurso = new GasVespeno(posicion);

        Asimilador asimilador = new Asimilador(posicion, raza, recurso);

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
