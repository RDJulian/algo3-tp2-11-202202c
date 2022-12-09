package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Mutalisco;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso21Test {
    public ArrayList<Estructura> estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        return estructuras;
    }

    @Test
    public void test01UnGuardianNoPuedeEvolucionarSiNoSeCuentanConLosRecursos() {
        Reserva reservaMineral = new Reserva();
        Reserva reservaGas = new Reserva();

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        assertThrows(RecursoInsuficienteException.class, () -> mutalisco.evolucionarAGuardian());

        reservaMineral.agregarRecurso(1000);
        reservaGas.agregarRecurso(1000);

        assertDoesNotThrow(() -> mutalisco.evolucionarAGuardian());
    }

    @Test
    public void test02UnDevoradorNoPuedeEvolucionarSiNoSeCuentanConLosRecursos() {
        Reserva reservaMineral = new Reserva();
        Reserva reservaGas = new Reserva();

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        assertThrows(RecursoInsuficienteException.class, () -> mutalisco.evolucionarADevorador());

        reservaMineral.agregarRecurso(1000);
        reservaGas.agregarRecurso(1000);

        assertDoesNotThrow(() -> mutalisco.evolucionarADevorador());
    }
}
