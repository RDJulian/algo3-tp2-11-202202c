package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorAcceso;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorAsimilador;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorExtractor;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorNexoMineral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {
    @Test
    public void test01EstructuraNoSePuedeConstruirSobreRecursoSiNoEsUnaDeLasEstructurasCorrectas() {
        ConstructorAcceso constructor = new ConstructorAcceso();
        Posicion posicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(1, 1);
        Pilon pilon = new Pilon(posicion);
        pasarKTurnos(pilon, 5);
        Recurso gasVespeno = new GasVespeno();
        Recurso mineral = new Mineral();
        Reserva reservaGas = new Reserva(10000);
        Reserva reservaMineral = new Reserva(10000);
        Raza raza = new Raza(reservaMineral, reservaGas);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(otraPosicion, gasVespeno, pilon, raza, pilon));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(otraPosicion, mineral, pilon, raza, pilon));
    }

    @Test
    public void test02AsimiladorSePuedenConstruirSobreElGasVespeno() {
        ConstructorAsimilador constructor = new ConstructorAsimilador();

        Posicion posicion = new Posicion(1, 1);
        Pilon pilon = new Pilon(new Posicion(2, 2));
        pasarKTurnos(pilon, 10);
        Recurso gasVespeno = new GasVespeno();
        Reserva reservaGas = new Reserva(10000);
        Reserva reservaMineral = new Reserva(10000);
        Estructura estructura = new Pilon(new Posicion(0, 0));
        Raza raza = new Raza(reservaMineral, reservaGas);

        assertDoesNotThrow(() -> constructor.construir(posicion, gasVespeno, pilon, raza, estructura));
    }

    @Test
    public void test03ExtractorSePuedenConstruirSobreElGasVespeno() {
        ConstructorExtractor constructor = new ConstructorExtractor();

        Posicion posicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(1, 1);
        Piso moho = new Moho(posicion);
        Recurso gasVespeno = new GasVespeno();
        Reserva reservaGas = new Reserva(10000);
        Reserva reservaMineral = new Reserva(10000);
        Estructura estructura = new Pilon(new Posicion(0, 0));
        Raza raza = new Raza(reservaMineral, reservaGas);

        assertDoesNotThrow(() -> constructor.construir(otraPosicion, gasVespeno, moho, raza, estructura));
    }

    @Test
    public void test04NexoMineralSePuedeConstruirSobreMineral() {
        ConstructorNexoMineral constructor = new ConstructorNexoMineral();
        Posicion posicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(1, 1);
        Pilon pilon = new Pilon(posicion);
        pasarKTurnos(pilon, 5);
        Recurso mineral = new Mineral();
        Reserva reservaGas = new Reserva(10000);
        Reserva reservaMineral = new Reserva(10000);
        Raza raza = new Raza(reservaMineral, reservaGas);

        assertDoesNotThrow(() -> constructor.construir(otraPosicion, mineral, pilon, raza, pilon));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
