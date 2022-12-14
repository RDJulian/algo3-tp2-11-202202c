package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPiso;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso3Test {
    @Test
    public void test01EstructuraNoSePuedeConstruirSobreRecursoSiNoEsUnaDeLasEstructurasCorrectas() {
        //Se mockea la raza para no depender de los costos.
        Zerg zerg = mock(Zerg.class);
        Protoss protoss = mock(Protoss.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorAcceso(estructuras, protoss));
        constructores.add(new ConstructorCriadero(estructuras, zerg));
        constructores.add(new ConstructorEspiral(estructuras, zerg));
        constructores.add(new ConstructorGuarida(estructuras, zerg));
        constructores.add(new ConstructorPilon(estructuras, protoss));
        constructores.add(new ConstructorPuertoEstelar(estructuras, protoss));
        constructores.add(new ConstructorReservaDeReproduccion(estructuras, zerg));

        //Se mockea el area para no depender de lo que no se prueba.
        EstadoPiso estadoPisoMock = mock(EstadoPiso.class);
        when(estadoPisoMock.construible(any(ConstruiblePiso.class))).thenReturn(true);
        Area areaConMineral = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new Mineral());
        Area areaConGasVespeno = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new GasVespeno());

        for (ConstructorEstructuras constructor : constructores) {
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaConMineral));
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaConGasVespeno));
        }
    }

    @Test
    public void test02AsimiladorSePuedeConstruirSobreElGasVespeno() {
        //Se mockea la raza para no depender de los costos.
        Protoss protoss = mock(Protoss.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorAsimilador(estructuras, protoss);

        //Se mockea el area para no depender de lo que no se prueba.
        EstadoPiso estadoPisoMock = mock(EstadoPiso.class);
        when(estadoPisoMock.construible(any(ConstruiblePiso.class))).thenReturn(true);
        Area areaConMineral = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new Mineral());
        Area areaConGasVespeno = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new GasVespeno());

        assertDoesNotThrow(() -> constructor.construir(areaConGasVespeno));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaConMineral));
    }

    @Test
    public void test03ExtractorSePuedeConstruirSobreElGasVespeno() {
        //Se mockea la raza para no depender de los costos.
        Zerg zerg = mock(Zerg.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorExtractor(estructuras, zerg);

        //Se mockea el area para no depender de lo que no se prueba.
        EstadoPiso estadoPisoMock = mock(EstadoPiso.class);
        when(estadoPisoMock.construible(any(ConstruiblePiso.class))).thenReturn(true);
        Area areaConMineral = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new Mineral());
        Area areaConGasVespeno = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new GasVespeno());

        assertDoesNotThrow(() -> constructor.construir(areaConGasVespeno));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaConMineral));
    }

    @Test
    public void test04NexoMineralSePuedeConstruirSobreMineral() {
        //Se mockea la raza para no depender de los costos.
        Protoss protoss = mock(Protoss.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorNexoMineral(estructuras, protoss);

        //Se mockea el area para no depender de lo que no se prueba.
        EstadoPiso estadoPisoMock = mock(EstadoPiso.class);
        when(estadoPisoMock.construible(any(ConstruiblePiso.class))).thenReturn(true);
        Area areaConMineral = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new Mineral());
        Area areaConGasVespeno = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new GasVespeno());

        assertDoesNotThrow(() -> constructor.construir(areaConMineral));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaConGasVespeno));
    }

    @Test
    public void test05AsimiladorNoSePuedeConstruirSobreUnAreaSinRecurso() {
        //Se mockea la raza para no depender de los costos.
        Protoss protoss = mock(Protoss.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorAsimilador(estructuras, protoss);

        //Se mockea el area para no depender de lo que no se prueba.
        EstadoPiso estadoPisoMock = mock(EstadoPiso.class);
        when(estadoPisoMock.construible(any(ConstruiblePiso.class))).thenReturn(true);
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
    }

    @Test
    public void test06NexoMineralNoSePuedeConstruirSobreUnAreaSinRecurso() {
        //Se mockea la raza para no depender de los costos.
        Protoss protoss = mock(Protoss.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorEstructuras constructor = new ConstructorNexoMineral(estructuras, protoss);

        //Se mockea el area para no depender de lo que no se prueba.
        EstadoPiso estadoPisoMock = mock(EstadoPiso.class);
        when(estadoPisoMock.construible(any(ConstruiblePiso.class))).thenReturn(true);
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, new RecursoNull());
        
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
    }
}
