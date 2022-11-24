package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereAcceso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17Test {
    @Test
    public void test01GuaridaNecesitaUnaReservaDeReproduccionParaPoderConstruirse() {
        ConstruibleEstructura requiereReservaDeReproduccion = new RequiereReservaDeReproduccion();
        Estructura reservaDeReproduccion = new ReservaDeReproduccion(new Posicion(0, 0));
        Estructura criadero = new Criadero(new Posicion(0, 0));
        pasarKTurnos(reservaDeReproduccion,100);
        pasarKTurnos(criadero,100);

        assertThrows(ConstruccionNoValidaException.class, () -> criadero.construible(requiereReservaDeReproduccion));
        assertDoesNotThrow(() -> reservaDeReproduccion.construible(requiereReservaDeReproduccion));
    }

    @Test
    public void test02EspiralNecesitaUnaGuaridaParaPoderConstruirse() {
        ConstruibleEstructura requiereGuarida = new RequiereGuarida();
        Estructura criadero = new Criadero(new Posicion(0, 0));
        Estructura guarida = new Guarida(new Posicion(0, 0));
        pasarKTurnos(guarida,100);
        pasarKTurnos(criadero,100);

        assertThrows(ConstruccionNoValidaException.class, () -> criadero.construible(requiereGuarida));
        assertDoesNotThrow(() -> guarida.construible(requiereGuarida));
    }

    @Test
    public void test03PuertoEstelarNecesitaUnAccesoParaPoderConstruirse() {
        ConstruibleEstructura requiereAcceso = new RequiereAcceso();
        Estructura pilon = new Pilon(new Posicion(0, 0));
        Estructura acceso = new Acceso(new Posicion(0, 0));
        pasarKTurnos(acceso,100);
        pasarKTurnos(pilon,100);

        assertThrows(ConstruccionNoValidaException.class, () -> pilon.construible(requiereAcceso));
        assertDoesNotThrow(() -> acceso.construible(requiereAcceso));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
