package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorAcceso;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorAsimilador;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorExtractor;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorNexoMineral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {
    @Test
    public void test01EstructuraNoSePuedeConstruirSobreRecursoSiNoEsUnaDeLasEstructurasCorrectas() {
        ConstructorAcceso constructor = new ConstructorAcceso();
        Posicion posicion = new Posicion(0, 0);

        Pilon pilon = new Pilon(new Posicion(1, 1));
        pasarKTurnos(pilon, 5);

        Recurso gasVespeno = new GasVespeno(posicion);
        Recurso mineral = new Mineral(posicion);
        Raza raza = new Raza();

        raza.recolectarMineral(1000);
        raza.recolectarGas(1000);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, gasVespeno, pilon, raza, pilon));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, mineral, pilon, raza, pilon));
    }

    @Test
    public void test02AsimiladorSePuedenConstruirSobreElGasVespeno() {
        ConstructorAsimilador constructor = new ConstructorAsimilador();
        Posicion posicion = new Posicion(0, 0);

        Pilon pilon = new Pilon(new Posicion(1, 1));
        pasarKTurnos(pilon, 5);

        Recurso gasVespeno = new GasVespeno(posicion);
        Raza raza = new Raza();

        raza.recolectarMineral(1000);
        raza.recolectarGas(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion, gasVespeno, pilon, raza, pilon));
    }

    @Test
    public void test03ExtractorSePuedenConstruirSobreElGasVespeno() {
        ConstructorExtractor constructor = new ConstructorExtractor();
        Posicion posicion = new Posicion(0, 0);

        Pilon pilon = new Pilon(new Posicion(1, 1));
        pasarKTurnos(pilon, 5);

        Moho moho = new Moho(new Posicion(2, 2));

        Recurso gasVespeno = new GasVespeno(posicion);
        Raza raza = new Raza();

        raza.recolectarMineral(1000);
        raza.recolectarGas(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion, gasVespeno, moho, raza, pilon));
    }

    @Test
    public void test04NexoMineralSePuedeConstruirSobreMineral() {
        ConstructorNexoMineral constructor = new ConstructorNexoMineral();
        Posicion posicion = new Posicion(0, 0);

        Pilon pilon = new Pilon(new Posicion(1, 1));
        pasarKTurnos(pilon, 5);

        Recurso mineral = new Mineral(posicion);
        Raza raza = new Raza();

        raza.recolectarMineral(1000);
        raza.recolectarGas(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion, mineral, pilon, raza, pilon));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
