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
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorPilon;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorAmoSupremo;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorUnidades;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorZealot;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConstructorTest {
    //Se prueban solamente las condiciones que modifican otros objetos.
    @Test
    public void test01UnaReservaNoDeberiaGastarseSiUnaEntidadNoPuedeConstruirse() {
        Raza raza = new Raza();
        raza.recolectarMineral(100);

        ConstructorEstructuras constructor = new ConstructorPilon(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Ocupada(), new TieneEnergiaPilon(), new RecursoNull());
        Area areaDesocupada = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
        assertDoesNotThrow(() -> constructor.construir(areaDesocupada));
    }

    @Test
    public void test02UnAreaNoDeberiaOcuparseSiUnaEntidadNoPuedeConstruirse() {
        Raza raza = new Raza();

        ConstructorEstructuras constructor = new ConstructorPilon(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        raza.recolectarMineral(100);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test03UnaEntidadNoSePuedeConstruirSobreUnAreaEspacial() {
        Raza raza = mock(Raza.class);

        ConstructorEstructuras constructor = new ConstructorPilon(new ArrayList<>(), raza);
        ConstructorUnidades constructorUnidad = new ConstructorAmoSupremo(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaEspacial(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
        Area otraArea = new Area(new Coordenada(0, 0), new AreaEspacial(), new Desocupada(), new TieneMoho(), new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidad.construir(otraArea));
    }

    @Test
    public void test04NingunaUnidadSePuedeConstruirSobreUnRecurso() {
        Raza raza = mock(Raza.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorUnidades unConstructor = new ConstructorZealot(estructuras, raza);
        ConstructorUnidades otroConstructor = new ConstructorAmoSupremo(estructuras, raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new GasVespeno());
        Area otraArea = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new Mineral());

        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area));
        assertThrows(ConstruccionNoValidaException.class, () -> otroConstructor.construir(otraArea));
    }

    @Test
    public void test05UnaUnidadProtossSoloPuedeConstruirseSobreUnAreaEnergizada() {
        Raza raza = mock(Raza.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorUnidades unConstructor = new ConstructorZealot(estructuras, raza);

        Area area1 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
        Area area2 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
        Area area3 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new EstadoPisoNull(), new RecursoNull());

        assertDoesNotThrow(() -> unConstructor.construir(area1));
        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area2));
        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area3));
    }

    @Test
    public void test06UnaUnidadZergSoloPuedeConstruirseSobreUnAreaConMoho() {
        Raza raza = mock(Raza.class);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ConstructorUnidades unConstructor = new ConstructorAmoSupremo(estructuras, raza);

        Area area1 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
        Area area2 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
        Area area3 = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new EstadoPisoNull(), new RecursoNull());

        assertDoesNotThrow(() -> unConstructor.construir(area2));
        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area1));
        assertThrows(ConstruccionNoValidaException.class, () -> unConstructor.construir(area3));
    }
}