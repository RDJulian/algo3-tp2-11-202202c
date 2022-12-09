package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorExtractor;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso4Test {

    @Test
    public void test01UnExtractorNoGeneraGasSinZanganos() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno(posicion);
        Raza raza = new Raza();

        Extractor extractor = new Extractor(posicion, raza, gasVespeno);
        pasarKTurnos(extractor, 6);

        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 1));
    }

    @Test
    public void test02UnExtractorGeneraDiezGasConUnZangano() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno(posicion);
        Raza raza = new Raza();

        Extractor extractor = new Extractor(posicion, raza, gasVespeno);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano();
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 11));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 10));
    }

    @Test
    public void test03UnExtractorGeneraVeinteGasConDosZanganos() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno(posicion);
        Raza raza = new Raza();

        Extractor extractor = new Extractor(posicion, raza, gasVespeno);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano();
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);
        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 21));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 20));
    }

    @Test
    public void test04UnExtractorGeneraTreintaGasConTresZanganos() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno(posicion);
        Raza raza = new Raza();

        Extractor extractor = new Extractor(posicion, raza, gasVespeno);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano();
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);
        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 31));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 30));
    }

    @Test
    public void test05UnExtractorNoAdmiteMasDeTresZanganos() {
        Posicion posicion = new Posicion(0, 0);
        GasVespeno gasVespeno = new GasVespeno(posicion);
        Raza raza = new Raza();

        Extractor extractor = new Extractor(posicion, raza, gasVespeno);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano();
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);

        assertThrows(ExtractorLlenoException.class, () -> extractor.agregarZangano(zangano));
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}