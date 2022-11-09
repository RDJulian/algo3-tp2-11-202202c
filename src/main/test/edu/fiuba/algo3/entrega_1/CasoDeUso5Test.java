package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLleno;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso5Test {

    @Test
    public void test01NoSePuedeConstruirUnaEstructuraProtossFueraDelRangoDeUnPilon() {
        Pilon pilon = new Pilon(new Posicion(0, 0));
        NexoMineral nexoMineral = new NexoMineral(new Posicion(10, 10));

        assertThrows(ConstruccionNoValida.class, () -> {
            nexoMineral.construir(pilon);
        });
    }

    @Test
    public void test02NoSePuedeConstruirUnaEstructuraZergFueraDelRangoDelMoho() {
        Moho moho = new Moho(new Posicion(0, 0));
        Criadero criadero = new Criadero(new Posicion(10, 10));

        assertThrows(ConstruccionNoValida.class, () -> {
            criadero.construir(moho);
        });
    }

    @Test
    public void test03SePuedeConstruirUnaEstructuraProtossEnElRangoDeUnPilon() {
        Pilon pilon = new Pilon(new Posicion(0, 0));
        NexoMineral nexoMineral = new NexoMineral(new Posicion(3, 3));

        assertDoesNotThrow(() -> {
            nexoMineral.construir(pilon);
        });
    }

    @Test
    public void test04SePuedeConstruirUnaEstructuraZergEnElRangoDelMoho() {
        Moho moho = new Moho(new Posicion(0, 0));
        Criadero criadero = new Criadero(new Posicion(5, 5));

        assertDoesNotThrow(() -> {
            criadero.construir(moho);
        });
    }
}
