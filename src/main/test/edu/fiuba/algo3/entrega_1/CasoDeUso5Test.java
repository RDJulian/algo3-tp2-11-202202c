package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso5Test {

    @Test
    public void test01NoSePuedeConstruirUnaEstructuraProtossFueraDelRangoDeUnPilon() {
        Pilon pilon = new Pilon(new Posicion(0, 0));
        pasarKTurnos(pilon, 5);
        Estructura estructura = new Acceso(new Posicion(10, 10));

        assertThrows(ConstruccionNoValida.class, () -> estructura.construible(pilon));
    }

    @Test
    public void test02NoSePuedeConstruirUnaEstructuraZergFueraDelRangoDelMoho() {
        Moho moho = new Moho(new Posicion(0, 0));
        Estructura estructura = new ReservaDeReproduccion(new Posicion(10, 10));

        assertThrows(ConstruccionNoValida.class, () -> estructura.construible(moho));
    }

    @Test
    public void test03SePuedeConstruirUnaEstructuraProtossEnElRangoDeUnPilon() {
        Pilon pilon = new Pilon(new Posicion(0, 0));
        pasarKTurnos(pilon, 5);
        Estructura estructura = new Acceso(new Posicion(3, 3));

        assertDoesNotThrow(() -> estructura.construible(pilon));
    }

    @Test
    public void test04SePuedeConstruirUnaEstructuraZergEnElRangoDelMoho() {
        Moho moho = new Moho(new Posicion(0, 0));
        Estructura estructura = new ReservaDeReproduccion(new Posicion(5, 5));

        assertDoesNotThrow(() -> {
            estructura.construible(moho);
        });
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
