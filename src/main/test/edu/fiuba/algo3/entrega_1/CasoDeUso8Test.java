package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso8Test {
    //La dependencia se movio a los Constructores particulares. Ellos preguntan a cada reserva si se puede construir
    //esa estructura en base a su costo. No es necesario probar todos los casos porque solo cambiarian los numeros.
    @Test
    public void test01AccesoSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Reserva reservaGas = new Reserva(0);
        Reserva reservaMineral = new Reserva(0);

        assertThrows(RecursoInsuficienteException.class, () -> reservaMineral.construible(150));

        reservaGas.agregarRecurso(200);
        reservaMineral.agregarRecurso(200);

        assertDoesNotThrow(() -> reservaMineral.construible(150));
    }
}