package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso8Test {
    @Test
    public void test01AccesoSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Protoss protoss = new Protoss(0, 0);
        protoss.recolectarMineral(149);
        protoss.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorAcceso(estructuras, protoss);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        protoss.recolectarMineral(1);
        protoss.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test02AsimiladorSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Protoss protoss = new Protoss(0, 0);
        protoss.recolectarMineral(99);
        protoss.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorAsimilador(estructuras, protoss);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        protoss.recolectarMineral(1);
        protoss.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test03EspiralSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(149);
        zerg.recolectarGas(99);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorEspiral(estructuras, zerg);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        zerg.recolectarMineral(1);
        zerg.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test04GuaridaSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(199);
        zerg.recolectarGas(99);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorGuarida(estructuras, zerg);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        zerg.recolectarMineral(1);
        zerg.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test05NexoMineralSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Protoss protoss = new Protoss(0, 0);
        protoss.recolectarMineral(49);
        protoss.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorNexoMineral(estructuras, protoss);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        protoss.recolectarMineral(1);
        protoss.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test06PilonSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Protoss protoss = new Protoss(0, 0);
        protoss.recolectarMineral(99);
        protoss.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorPilon(estructuras, protoss);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        protoss.recolectarMineral(1);
        protoss.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test07PuertoEstelarSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Protoss protoss = new Protoss(0, 0);
        protoss.recolectarMineral(149);
        protoss.recolectarGas(149);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorPuertoEstelar(estructuras, protoss);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        protoss.recolectarMineral(1);
        protoss.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test08ReservaDeReproduccionSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(149);
        zerg.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorReservaDeReproduccion(estructuras, zerg);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        zerg.recolectarMineral(1);
        zerg.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test09CriaderoSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(199);
        zerg.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorCriadero(estructuras, zerg);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        zerg.recolectarMineral(1);
        zerg.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test10ExtractorSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(99);
        zerg.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorExtractor(estructuras, zerg);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        zerg.recolectarMineral(1);
        zerg.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }
}
