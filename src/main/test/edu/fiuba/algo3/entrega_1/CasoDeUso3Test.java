package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorAcceso;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorExtractor;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorNexoMineral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
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
        pilon.setEstado(new Operativa());
        Recurso gasVespeno = new GasVespeno();
        Recurso mineral = new Mineral();
        Reserva reservaGas = new Reserva(10000);
        Reserva reservaMineral = new Reserva(10000);
        Raza raza = new Raza(reservaMineral, reservaGas);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(otraPosicion, gasVespeno, pilon, raza, pilon));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(otraPosicion, mineral, pilon, raza, pilon));
    }

    @Test
    public void test02ExtractorYAsimiladorSePuedenConstruirSobreElGasVespeno() {
        ConstructorExtractor constructor = new ConstructorExtractor();
        Posicion posicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(1, 1);
        Piso moho = new Moho(posicion);
        Recurso gasVespeno = new GasVespeno();
        Reserva reservaGas = new Reserva(10000);
        Reserva reservaMineral = new Reserva(10000);
        Estructura estructura = new Pilon(new Posicion(0, 0));
        Raza raza = new Raza(reservaMineral, reservaGas);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(otraPosicion, gasVespeno, moho, raza, estructura));
    }

    @Test
    public void test04NexoMineralSePuedeConstruirSobreMineral() {
        ConstructorNexoMineral constructor = new ConstructorNexoMineral();
        Posicion posicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(1, 1);
        Pilon pilon = new Pilon(posicion);
        pilon.setEstado(new Operativa());
        Recurso mineral = new Mineral();
        Reserva reservaGas = new Reserva(10000);
        Reserva reservaMineral = new Reserva(10000);
        Raza raza = new Raza(reservaMineral, reservaGas);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(otraPosicion, mineral, pilon, raza, pilon));
    }
}
