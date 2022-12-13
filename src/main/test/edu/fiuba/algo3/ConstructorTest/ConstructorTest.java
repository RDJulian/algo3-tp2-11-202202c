package edu.fiuba.algo3.ConstructorTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Ocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPisoNull;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorPilon;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorAmoSupremo;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorUnidades;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorZangano;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorZealot;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.RazaZergSinLarvasException;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ConstructorTest {
    @Test
    public void test01UnaReservaNoDeberiaGastarseSiUnaEntidadNoPuedeConstruirse() {
        reiniciarRazas();

        Protoss raza = Protoss.obtenerInstancia();
        raza.gastarRecursos(200, 0);

        raza.recolectarMineral(100);

        ConstructorEstructuras constructor = new ConstructorPilon(raza.getEstructuras(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Ocupada(), new TieneEnergiaPilon(), new RecursoNull());
        Area areaDesocupada = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
        assertDoesNotThrow(() -> constructor.construir(areaDesocupada));
    }

    @Test
    public void test02UnAreaNoDeberiaOcuparseSiUnaEntidadNoPuedeConstruirse() {
        reiniciarRazas();

        Protoss raza = Protoss.obtenerInstancia();
        raza.gastarRecursos(200, 0);

        ConstructorEstructuras constructor = new ConstructorPilon(raza.getEstructuras(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        raza.recolectarMineral(100);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test03UnaEntidadNoSePuedeConstruirSobreUnAreaEspacial() {
        reiniciarRazas();

        Protoss protoss = Protoss.obtenerInstancia();
        Zerg zerg = Zerg.obtenerInstancia();

        Criadero criadero = mock(Criadero.class);
        doNothing().when(criadero).usarLarva();
        zerg.registrarEntidad(criadero);

        ConstructorEstructuras constructor = new ConstructorPilon(protoss.getEstructuras(), protoss);
        ConstructorUnidades constructorUnidad = new ConstructorAmoSupremo(zerg.getEstructuras(), zerg);

        Area area = new Area(new Coordenada(0, 0), new AreaEspacial(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
        Area otraArea = new Area(new Coordenada(0, 0), new AreaEspacial(), new Desocupada(), new TieneMoho(), new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidad.construir(otraArea));
    }

    @Test
    public void test04NingunaUnidadSePuedeConstruirSobreUnRecurso() {
        reiniciarRazas();

        Protoss protoss = Protoss.obtenerInstancia();
        Zerg zerg = Zerg.obtenerInstancia();

        Estructura estructura = mock(Estructura.class);
        when(estructura.afectarSuministro(any(int.class))).thenReturn(200);
        when(estructura.construible(any())).thenReturn(true);

        Criadero criadero = mock(Criadero.class);
        doNothing().when(criadero).usarLarva();
        zerg.registrarEntidad(criadero);

        zerg.registrarEntidad(estructura);
        protoss.registrarEntidad(estructura);

        ConstructorUnidades unConstructor = new ConstructorZealot(protoss.getEstructuras(), protoss);
        ConstructorUnidades otroConstructor = new ConstructorAmoSupremo(zerg.getEstructuras(), zerg);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new GasVespeno());
        Area otraArea = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new Mineral());

        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area));
        assertThrows(ConstruccionNoValidaException.class, () -> otroConstructor.construir(otraArea));
    }

    @Test
    public void test05UnaUnidadProtossSoloPuedeConstruirseSobreUnAreaEnergizada() {
        reiniciarRazas();

        Protoss protoss = Protoss.obtenerInstancia();

        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);

        protoss.registrarEntidad(estructuraMock);

        ConstructorUnidades unConstructor = new ConstructorZealot(protoss.getEstructuras(), protoss);

        Area area1 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
        Area area2 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
        Area area3 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new EstadoPisoNull(), new RecursoNull());

        assertDoesNotThrow(() -> unConstructor.construir(area1));
        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area2));
        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area3));
    }

    @Test
    public void test06UnaUnidadZergSoloPuedeConstruirseSobreUnAreaConMoho() {
        reiniciarRazas();

        Zerg zerg = Zerg.obtenerInstancia();

        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);

        zerg.registrarEntidad(estructuraMock);

        Criadero criadero = mock(Criadero.class);
        doNothing().when(criadero).usarLarva();
        zerg.registrarEntidad(criadero);

        ConstructorUnidades unConstructor = new ConstructorAmoSupremo(zerg.getEstructuras(), zerg);

        Area area1 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
        Area area2 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
        Area area3 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new EstadoPisoNull(), new RecursoNull());

        assertDoesNotThrow(() -> unConstructor.construir(area2));
        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area1));
        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area3));
    }

    @Test
    public void test07UnaUnidadZergNoDeberiaGastarUnaLarvaSiNoPuedeConstruirse() {
        reiniciarRazas();

        Zerg zerg = Zerg.obtenerInstancia();

        ConstructorEstructuras constructor = new ConstructorCriadero(zerg.getEstructuras(), zerg);
        Area unArea = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
        constructor.construir(unArea);

        pasarKTurnos(zerg, 4);

        ConstructorUnidades unConstructor = new ConstructorZangano(zerg.getEstructuras(), zerg);
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area));

        zerg.usarLarva();
        zerg.usarLarva();
        zerg.usarLarva();

        assertThrows(RazaZergSinLarvasException.class, zerg::usarLarva);
    }

    @Test
    public void test08UnaUnidadZergNoDeberiaGastarRecursosNiOcuparUnaPosicionSiNoTieneLarvasParaConstruirse() {
        reiniciarRazas();

        Zerg zerg = Zerg.obtenerInstancia();

        ConstructorEstructuras constructor = new ConstructorCriadero(zerg.getEstructuras(), zerg);
        Area unArea = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
        constructor.construir(unArea);

        pasarKTurnos(zerg, 4);

        zerg.usarLarva();
        zerg.usarLarva();
        zerg.usarLarva();

        ConstructorUnidades unConstructor = new ConstructorZangano(zerg.getEstructuras(), zerg);
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());

        zerg.recolectarMineral(25);

        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area));

        zerg.pasarTurno();

        assertDoesNotThrow(() -> unConstructor.construir(area));
    }

    public void reiniciarRazas() {
        Protoss.obtenerInstancia().reiniciar();
        Zerg.obtenerInstancia().reiniciar();
    }

    public void pasarKTurnos(Raza raza, int k) {
        for (int i = 0; i < k; i++) {
            raza.pasarTurno();
        }
    }
}