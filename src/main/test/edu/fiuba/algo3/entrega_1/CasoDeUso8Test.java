package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso8Test {
    @Test
    public void test01AccesoSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(149);
        raza.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorAcceso(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test02AsimiladorSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(99);
        raza.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorAsimilador(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test03EspiralSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(149);
        raza.recolectarGas(99);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorEspiral(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test04GuaridaSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(199);
        raza.recolectarGas(99);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorGuarida(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test05NexoMineralSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(49);
        raza.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorNexoMineral(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test06PilonSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(99);
        raza.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorPilon(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test07PuertoEstelarSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(149);
        raza.recolectarGas(149);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorPuertoEstelar(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test08ReservaDeReproduccionSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(149);
        raza.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorReservaDeReproduccion(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test09CriaderoSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(199);
        raza.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorCriadero(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);
        when(area.ocupar()).thenReturn(area);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test10ExtractorSoloSePuedeConstruirSiLasReservasTienenElRecursoSuficiente() {
        Raza raza = new Raza();
        raza.recolectarMineral(99);
        raza.recolectarGas(0);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorExtractor(estructuras, raza);

        //Se mockea el area porque no afecta en nada en este test.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(area));

        raza.recolectarMineral(1);
        raza.recolectarGas(1);

        assertDoesNotThrow(() -> constructor.construir(area));
    }
}