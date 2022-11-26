package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso8Test {
    //La dependencia se movio a los Constructores particulares. Ellos preguntan a cada reserva si se puede construir
    //esa estructura en base a su costo. No probamos todos los casos por el momento porque solo cambiarian los numeros.
    @Test
    public void test01AccesoSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva();
        Reserva reservaMineral = new Reserva();

        reservaGas.agregarRecurso(149);
        reservaMineral.agregarRecurso(149);

        assertThrows(RecursoInsuficienteException.class, () -> reservaMineral.construible(150));

        reservaGas.agregarRecurso(1);
        reservaMineral.agregarRecurso(1);

        assertDoesNotThrow(() -> reservaMineral.construible(150));
    }
}