package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Mutalisco;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso32Test {
    public ArrayList<Estructura> estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        return estructuras;
    }

    @Test
    public void test01UnJuegoContinuaSiLasDosRazasTienenConstruccionesEnSuAsentamiento() {
        Raza zerg = new Raza();
        Raza protoss = new Raza();

        Juego juego = new Juego();

        juego.registrarJugadores("Julian", "rojo", zerg, "Franco", "azul", protoss);

        zerg.registarEntidad(new Criadero(new Posicion(0, 0), zerg, new Nada()));
        zerg.registarEntidad(new Mutalisco(new Posicion(0, 0), zerg, estructuraMockeadaParaTestear()));

        protoss.registarEntidad(new Pilon(new Posicion(0, 0), protoss, new Nada()));
        protoss.registarEntidad(new Scout(new Posicion(0, 0), protoss, estructuraMockeadaParaTestear()));

        assertFalse(juego::terminarJuego);
    }

    @Test
    public void test02UnJuegoTerminaSiUnaDeLasDosRazasNoTieneConstruccionesEnSuAsentamiento() {
        Raza zerg = new Raza();
        Raza protoss = new Raza();

        Juego juego = new Juego();

        juego.registrarJugadores("Julian", "rojo", zerg, "Franco", "azul", protoss);

        zerg.registarEntidad(new Criadero(new Posicion(0, 0), zerg, new Nada()));
        zerg.registarEntidad(new Mutalisco(new Posicion(0, 0), zerg, estructuraMockeadaParaTestear()));

        Pilon pilon = new Pilon(new Posicion(0, 0), protoss, new Nada());
        protoss.registarEntidad(pilon);
        protoss.registarEntidad(new Scout(new Posicion(0, 0), protoss, estructuraMockeadaParaTestear()));

        assertFalse(juego::terminarJuego);

        pilon.destruir();

        assertTrue(juego::terminarJuego);
    }
}
