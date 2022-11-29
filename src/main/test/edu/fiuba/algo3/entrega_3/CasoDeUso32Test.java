package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Mutalisco;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso32Test {


    @Test
    public void test01UnJuegoContinuaSiLasDosRazasTienenConstruccionesEnSuAsentamiento() {
        Raza zerg = new Raza();
        Raza protoss = new Raza();

        Juego juego = new Juego();

        juego.registrarJugadores("Julian", "rojo", zerg, "Franco", "azul", protoss);

        zerg.registarEntidad(new Criadero(new Posicion(0, 0), zerg));
        zerg.registarEntidad(new Mutalisco(new Posicion(0, 0), zerg));

        protoss.registarEntidad(new Pilon(new Posicion(0, 0), protoss));
        protoss.registarEntidad(new Scout(new Posicion(0, 0), protoss));

        assertFalse(juego::terminarJuego);
    }

    @Test
    public void test02UnJuegoTerminaSiUnaDeLasDosRazasNoTieneConstruccionesEnSuAsentamiento() {
        Raza zerg = new Raza();
        Raza protoss = new Raza();

        Juego juego = new Juego();

        juego.registrarJugadores("Julian", "rojo", zerg, "Franco", "azul", protoss);

        zerg.registarEntidad(new Criadero(new Posicion(0, 0), zerg));
        zerg.registarEntidad(new Mutalisco(new Posicion(0, 0), zerg));

        Pilon pilon = new Pilon(new Posicion(0, 0), protoss);
        protoss.registarEntidad(pilon);
        protoss.registarEntidad(new Scout(new Posicion(0, 0), protoss));

        assertFalse(juego::terminarJuego);

        pilon.destruir();

        assertTrue(juego::terminarJuego);
    }
}
