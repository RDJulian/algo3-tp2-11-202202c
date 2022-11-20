package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.RequiereAcceso;
import edu.fiuba.algo3.modelo.Construible.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.RequiereReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17Test {
    @Test
    public void test01GuaridaNecesitaUnaReservaDeReproduccionParaPoderConstruirse() {
        Construible requiereReservaDeReproduccion = new RequiereReservaDeReproduccion();
        Estructura reservaDeReproduccion = new ReservaDeReproduccion(new Posicion(0, 0));
        Estructura criadero = new Criadero(new Posicion(0, 0));

        assertThrows(ConstruccionNoValidaException.class, () -> criadero.construible(requiereReservaDeReproduccion));
        assertDoesNotThrow(() -> reservaDeReproduccion.construible(requiereReservaDeReproduccion));
    }

    @Test
    public void test02EspiralNecesitaUnaGuaridaParaPoderConstruirse() {
        Construible requiereGuarida = new RequiereGuarida();
        Estructura criadero = new Criadero(new Posicion(0, 0));
        Estructura guarida = new Guarida(new Posicion(0, 0));

        assertThrows(ConstruccionNoValidaException.class, () -> criadero.construible(requiereGuarida));
        assertDoesNotThrow(() -> guarida.construible(requiereGuarida));
    }

    @Test
    public void test03PuertoEstelarNecesitaUnAccesoParaPoderConstruirse() {
        Construible requiereAcceso = new RequiereAcceso();
        Estructura nexoMineral = new Pilon(new Posicion(0, 0));
        Estructura acceso = new Acceso(new Posicion(0, 0));

        assertThrows(ConstruccionNoValidaException.class, () -> nexoMineral.construible(requiereAcceso));
        assertDoesNotThrow(() -> acceso.construible(requiereAcceso));
    }
}
