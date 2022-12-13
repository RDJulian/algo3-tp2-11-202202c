package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.EstadoOcupacion;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPiso;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPisoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso5Test {
    @Test
    public void test01NoSePuedeConstruirUnaEstructuraProtossFueraDelRangoDeUnPilon() {
        //Se crea un area y se energiza manualmente.
        Area areaEnergizada = new Area(0, 0);
        areaEnergizada.energizar();

        //Mockeo la raza para no depender de recursos.
        Protoss protoss = mock(Protoss.class);

        Pilon pilon = new Pilon(areaEnergizada, protoss);
        pasarKTurnos(pilon, 5);

        //Se mockea el area para no depender de lo que no se prueba.
        Recurso recurso = mock(Recurso.class);
        when(recurso.construible(any(ConstruibleRecurso.class))).thenReturn(true);
        Area area = new Area(new Coordenada(4, 4), new AreaTierra(), new Desocupada(), new EstadoPisoNull(), recurso);
        area.actualizarEstado(pilon);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorNexoMineral(estructuras, protoss));
        constructores.add(new ConstructorPilon(estructuras, protoss));
        constructores.add(new ConstructorAsimilador(estructuras, protoss));
        constructores.add(new ConstructorAcceso(estructuras, protoss));
        constructores.add(new ConstructorPuertoEstelar(estructuras, protoss));

        for (ConstructorEstructuras constructor : constructores) {
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
        }
    }

    @Test
    public void test02NoSePuedeConstruirUnaEstructuraZergFueraDelRangoDelMoho() {
        //Se crea moho.
        Area areaConMoho = new Area(0, 0);
        Moho moho = new Moho(areaConMoho);

        //Mockeo la raza para no depender de recursos.
        Zerg zerg = mock(Zerg.class);

        //Se mockea el area para no depender de lo que no se prueba.
        Recurso recurso = mock(Recurso.class);
        when(recurso.construible(any(ConstruibleRecurso.class))).thenReturn(true);
        Area area = new Area(new Coordenada(6, 6), new AreaTierra(), new Desocupada(), new EstadoPisoNull(), recurso);
        area.actualizarEstado(moho);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorCriadero(estructuras, zerg));
        constructores.add(new ConstructorReservaDeReproduccion(estructuras, zerg));
        constructores.add(new ConstructorExtractor(estructuras, zerg));
        constructores.add(new ConstructorGuarida(estructuras, zerg));
        constructores.add(new ConstructorEspiral(estructuras, zerg));

        for (ConstructorEstructuras constructor : constructores) {
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
        }
    }

    @Test
    public void test03SePuedeConstruirUnaEstructuraProtossEnElRangoDeUnPilon() {
        //Se crea un area y se energiza manualmente.
        Area areaEnergizada = new Area(0, 0);
        areaEnergizada.energizar();

        //Mockeo la raza para no depender de recursos.
        Protoss protoss = mock(Protoss.class);

        Pilon pilon = new Pilon(areaEnergizada, protoss);
        pasarKTurnos(pilon, 5);

        //Se mockea el area para no depender de lo que no se prueba.
        Recurso recurso = mock(Recurso.class);
        when(recurso.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        EstadoOcupacion estadoOcupacionMock = mock(EstadoOcupacion.class);
        when(estadoOcupacionMock.ocupar()).thenReturn(estadoOcupacionMock);

        Area area = new Area(new Coordenada(3, 3), new AreaTierra(), estadoOcupacionMock, new EstadoPisoNull(), recurso);
        area.actualizarEstado(pilon);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorNexoMineral(estructuras, protoss));
        constructores.add(new ConstructorPilon(estructuras, protoss));
        constructores.add(new ConstructorAsimilador(estructuras, protoss));
        constructores.add(new ConstructorAcceso(estructuras, protoss));
        constructores.add(new ConstructorPuertoEstelar(estructuras, protoss));

        for (ConstructorEstructuras constructor : constructores) {
            assertDoesNotThrow(() -> constructor.construir(area));
        }
    }

    @Test
    public void test04SePuedeConstruirUnaEstructuraZergEnElRangoDelMoho() {
        //Se crea moho.
        Area areaConMoho = new Area(0, 0);
        Moho moho = new Moho(areaConMoho);

        //Mockeo la raza para no depender de recursos.
        Zerg zerg = mock(Zerg.class);

        //Se mockea el area para no depender de lo que no se prueba.
        Recurso recurso = mock(Recurso.class);
        when(recurso.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        EstadoOcupacion estadoOcupacionMock = mock(Desocupada.class);
        when(estadoOcupacionMock.ocupar()).thenReturn(estadoOcupacionMock);
        when(estadoOcupacionMock.cubrirConMoho(any(EstadoPiso.class))).thenCallRealMethod();

        Area area = new Area(new Coordenada(5, 5), new AreaTierra(), estadoOcupacionMock, new EstadoPisoNull(), recurso);
        area.actualizarEstado(moho);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorCriadero(estructuras, zerg));
        constructores.add(new ConstructorReservaDeReproduccion(estructuras, zerg));
        constructores.add(new ConstructorExtractor(estructuras, zerg));
        constructores.add(new ConstructorGuarida(estructuras, zerg));
        constructores.add(new ConstructorEspiral(estructuras, zerg));

        for (ConstructorEstructuras constructor : constructores) {
            assertDoesNotThrow(() -> constructor.construir(area));
        }
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
