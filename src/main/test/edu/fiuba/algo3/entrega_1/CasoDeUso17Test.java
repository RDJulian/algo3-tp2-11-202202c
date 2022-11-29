package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereAcceso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17Test {
    @Test
    public void test01GuaridaNecesitaUnaReservaDeReproduccionParaPoderConstruirse() {
        Posicion posicion = new Posicion(0, 0);
        ConstruibleEstructura requiereReservaDeReproduccion = new RequiereReservaDeReproduccion();

        Estructura reservaDeReproduccion = new ReservaDeReproduccion(posicion, new Raza());
        Estructura criadero = new Criadero(posicion, new Raza());
        pasarKTurnos(reservaDeReproduccion, 100);
        pasarKTurnos(criadero, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> criadero.construible(requiereReservaDeReproduccion));
        assertDoesNotThrow(() -> reservaDeReproduccion.construible(requiereReservaDeReproduccion));
    }

    @Test
    public void test02EspiralNecesitaUnaGuaridaParaPoderConstruirse() {
        Posicion posicion = new Posicion(0, 0);
        ConstruibleEstructura requiereGuarida = new RequiereGuarida();

        Estructura criadero = new Criadero(posicion, new Raza());
        Estructura guarida = new Guarida(posicion, new Raza());
        pasarKTurnos(guarida, 100);
        pasarKTurnos(criadero, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> criadero.construible(requiereGuarida));
        assertDoesNotThrow(() -> guarida.construible(requiereGuarida));
    }

    @Test
    public void test03PuertoEstelarNecesitaUnAccesoParaPoderConstruirse() {
        Posicion posicion = new Posicion(0, 0);
        ConstruibleEstructura requiereAcceso = new RequiereAcceso();

        Estructura pilon = new Pilon(posicion, new Raza());
        Estructura acceso = new Acceso(posicion, new Raza());
        pasarKTurnos(acceso, 100);
        pasarKTurnos(pilon, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> pilon.construible(requiereAcceso));
        assertDoesNotThrow(() -> acceso.construible(requiereAcceso));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
