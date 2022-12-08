package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereAcceso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17Test {
    @Test
    public void test01GuaridaNecesitaUnaReservaDeReproduccionParaPoderConstruirse() {
        ConstructorEstructuras constructor = new ConstructorGuarida();
        Posicion posicion = new Posicion(0, 0);
        Raza raza = new Raza();

        Estructura reservaDeReproduccion = new ReservaDeReproduccion(posicion, raza);
        Estructura criadero = new Criadero(posicion, raza);
        pasarKTurnos(reservaDeReproduccion, 100);
        pasarKTurnos(criadero, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir());
        assertDoesNotThrow(() -> constructor.construir());
    }

    @Test
    public void test02EspiralNecesitaUnaGuaridaParaPoderConstruirse() {
        Posicion posicion = new Posicion(0, 0);
        Raza raza = new Raza();

        Estructura guarida = new Guarida(posicion, raza);
        Estructura criadero = new Criadero(posicion, raza);
        pasarKTurnos(guarida, 100);
        pasarKTurnos(criadero, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> new Espiral(posicion, raza, criadero));
        assertDoesNotThrow(() -> new Espiral(posicion, raza, guarida));
    }

    @Test
    public void test03PuertoEstelarNecesitaUnAccesoParaPoderConstruirse() {
        Posicion posicion = new Posicion(0, 0);
        Raza raza = new Raza();

        Estructura acceso = new Acceso(posicion, raza);
        Estructura criadero = new Criadero(posicion, raza);
        pasarKTurnos(acceso, 100);
        pasarKTurnos(criadero, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> new Guarida(posicion, raza, criadero));
        assertDoesNotThrow(() -> new Guarida(posicion, raza, acceso));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
