package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17Test {
    @Test
    public void test01GuaridaNecesitaUnaReservaDeReproduccionParaPoderConstruirse() {
        Estructura reservaDeReproduccion = new ReservaDeReproduccion();
        Estructura criadero = new Criadero();
        Estructura guarida = new Guarida();

        assertThrows(ConstruccionNoValida.class, () -> guarida.construible(criadero));
        assertDoesNotThrow(() -> guarida.construible(reservaDeReproduccion));
    }

    @Test
    public void test02EspiralNecesitaUnaGuaridaParaPoderConstruirse() {
        Estructura espiral = new Espiral();
        Estructura criadero = new Criadero();
        Estructura guarida = new Guarida();

        assertThrows(ConstruccionNoValida.class, () -> espiral.construible(criadero));
        assertDoesNotThrow(() -> espiral.construible(guarida));
    }

    @Test
    public void test03PuertoEstelarNecesitaUnAccesoParaPoderConstruirse() {
        Estructura reservaDeReproduccion = new ReservaDeReproduccion();
        Estructura criadero = new Criadero();
        Estructura guarida = new Guarida();

        assertThrows(ConstruccionNoValida.class, () -> guarida.construible(criadero));
        assertDoesNotThrow(() -> guarida.construible(reservaDeReproduccion));
    }
}
