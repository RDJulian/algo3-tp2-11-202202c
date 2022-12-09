package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17Test {
    @Test
    public void test01GuaridaNecesitaUnaReservaDeReproduccionParaPoderConstruirse() {
        ArrayList<Estructura> estructuras = new ArrayList<>();
        Raza raza = new Raza();
        ConstructorEstructuras constructor = new ConstructorGuarida(estructuras, raza);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionConstruccion = new Posicion(1, 1);

        Estructura reservaDeReproduccion = new ReservaDeReproduccion(posicion, raza, new Nada());
        pasarKTurnos(reservaDeReproduccion, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicionConstruccion, new Nada()));

        estructuras.add(reservaDeReproduccion);

        assertDoesNotThrow(() -> constructor.construir(posicionConstruccion, new Nada()));
    }

    @Test
    public void test02EspiralNecesitaUnaGuaridaParaPoderConstruirse() {
        ArrayList<Estructura> estructuras = new ArrayList<>();
        Raza raza = new Raza();
        ConstructorEstructuras constructor = new ConstructorEspiral(estructuras, raza);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionConstruccion = new Posicion(1, 1);

        Estructura guarida = new Guarida();
        pasarKTurnos(guarida, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicionConstruccion, new Nada()));

        estructuras.add(guarida);

        assertDoesNotThrow(() -> constructor.construir(posicionConstruccion, new Nada()));
    }

    @Test
    public void test03PuertoEstelarNecesitaUnAccesoParaPoderConstruirse() {
        ArrayList<Estructura> estructuras = new ArrayList<>();
        Raza raza = new Raza();
        ConstructorEstructuras constructor = new ConstructorPuertoEstelar(estructuras, raza);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionConstruccion = new Posicion(1, 1);

        Estructura reservaDeReproduccion = new Acceso(posicion, raza, new Nada());
        pasarKTurnos(reservaDeReproduccion, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicionConstruccion, new Nada()));

        estructuras.add(reservaDeReproduccion);

        assertDoesNotThrow(() -> constructor.construir(posicionConstruccion, new Nada()));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
