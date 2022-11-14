package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorIncorrecto;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16Test {
    //La forma en que se resuelve estos casos no esta tan buena.
    //Supuesto, engloba al caso de uso.
    @Test
    public void test01UnaEstructuraNoSePuedeConstruirSobreOtra() {
        Posicion posicion = new Posicion(0, 0);
        Estructura unaEstructura = new Acceso();
        unaEstructura.construible(posicion);
        Estructura otraEstructura = new ReservaDeReproduccion();
        assertThrows(PosicionOcupada.class, () -> otraEstructura.construible(posicion));
    }

    @Test
    public void test02UnaEstructuraNoSePuedeConstruirSobreUnVolcanConUnaEstructura() {
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();
        Recurso gasVespeno = new GasVespeno(new Posicion(0, 0));

        asimilador.construible(gasVespeno);

        assertThrows(PosicionOcupada.class, () -> extractor.construible(gasVespeno));
    }

    @Test
    public void test03UnNexoMineralNoSePuedeConstruirSiUnZanganoEstaExtrayendo() {
        NexoMineral nexoMineral = new NexoMineral();
        Recurso mineral = new Mineral(new Posicion(0, 0));
        Zangano zangano = new Zangano();

        zangano.ocupar(mineral);

        assertThrows(PosicionOcupada.class, () -> nexoMineral.construible(mineral));
    }

    @Test
    public void test03UnZanganoNoPuedeExtraerMineralSiUnNexoMineralEstaConstruido() {
        NexoMineral nexoMineral = new NexoMineral();
        Reserva reserva = new Reserva();
        Recurso mineral = new Mineral(new Posicion(0, 0));
        Zangano zangano = new Zangano();

        nexoMineral.construible(mineral);

        assertThrows(ExtractorIncorrecto.class, () -> zangano.extraerRecurso(mineral, reserva));
    }
}
