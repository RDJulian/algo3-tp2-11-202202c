package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Entidad.Unidad.Mutalisco;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso21Test {
    @Test
    public void test01UnGuardianNoPuedeEvolucionarSiNoSeCuentanConLosRecursos() {
        Reserva reservaMineral = new Reserva();
        Reserva reservaGas = new Reserva();

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0), new Raza());
        assertThrows(RecursoInsuficienteException.class, () -> mutalisco.evolucionarAGuardian(reservaMineral, reservaGas));

        reservaMineral.agregarRecurso(1000);
        reservaGas.agregarRecurso(1000);

        assertDoesNotThrow(() -> mutalisco.evolucionarAGuardian(reservaMineral, reservaGas));
    }

    @Test
    public void test02UnDevoradorNoPuedeEvolucionarSiNoSeCuentanConLosRecursos() {
        Reserva reservaMineral = new Reserva();
        Reserva reservaGas = new Reserva();

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0), new Raza());
        assertThrows(RecursoInsuficienteException.class, () -> mutalisco.evolucionarADevorador(reservaMineral, reservaGas));

        reservaMineral.agregarRecurso(1000);
        reservaGas.agregarRecurso(1000);

        assertDoesNotThrow(() -> mutalisco.evolucionarADevorador(reservaMineral, reservaGas));
    }
}
