package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso6Test {

    @Test
    public void test01ElMohoSeExpandeCadaDosTurnosYSePuedeConstruirEnElLuegoDeExpandirse() {
        Moho moho = new Moho(new Posicion(0, 0));
        Estructura estructura = new ReservaDeReproduccion(new Posicion(6, 6));

        assertThrows(ConstruccionNoValida.class, () -> estructura.construible(moho)); //Se puede sacar.

        moho.pasarTurno();
        moho.pasarTurno();

        assertDoesNotThrow(() -> {
            estructura.construible(moho);
        });
    }
}
