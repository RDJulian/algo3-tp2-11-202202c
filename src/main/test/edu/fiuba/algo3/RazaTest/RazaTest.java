package edu.fiuba.algo3.RazaTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Ocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPiso;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPisoNull;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
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
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.RazaZergSinLarvasException;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class RazaTest {
    //Se prueba que el llamado a los constructores via la raza sea correcto.
    @Test
    public void test01SeConstruyeUnZanganoParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirZangano(areaMockeada()));
    }

    @Test
    public void test02SeConstruyeUnAmoSupremoParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirAmoSupremo(areaMockeada()));
    }

    @Test
    public void test03SeConstruyeUnZerlingParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirZerling(areaMockeada()));
    }

    @Test
    public void test04SeConstruyeUnHidraliscoParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirHidralisco(areaMockeada()));
    }

    @Test
    public void test05SeConstruyeUnMutaliscoParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirMutalisco(areaMockeada()));
    }

    @Test
    public void test06SeConstruyeUnGuardianParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirGuardian(areaMockeada()));
    }

    @Test
    public void test07SeConstruyeUnDevoradorParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirDevorador(areaMockeada()));
    }

    @Test
    public void test08SeConstruyeUnCriaderoParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirCriadero(areaMockeada()));
    }

    @Test
    public void test09SeConstruyeUnaReservaParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirReservaDeReproduccion(areaMockeada()));
    }

    @Test
    public void test10SeConstruyeUnExtractorParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirExtractor(areaMockeada()));
    }

    @Test
    public void test11SeConstruyeUnaGuaridaParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirGuarida(areaMockeada()));
    }

    @Test
    public void test12SeConstruyeUnEspiralParaLosZerg() {
        Zerg zerg = new Zerg(300, 300);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> zerg.construirEspiral(areaMockeada()));
    }

    @Test
    public void test13SeConstruyeUnNexoMineralParaLosProtoss() {
        Protoss protoss = new Protoss(300, 300);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> protoss.construirNexoMineral(areaMockeada()));
    }

    @Test
    public void test14SeConstruyeUnPilonParaLosProtoss() {
        Protoss protoss = new Protoss(300, 300);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> protoss.construirPilon(areaMockeada()));
    }

    @Test
    public void test15SeConstruyeUnAsimiladorParaLosProtoss() {
        Protoss protoss = new Protoss(300, 300);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> protoss.construirAsimilador(areaMockeada()));
    }

    @Test
    public void test16SeConstruyeUnAccesoParaLosProtoss() {
        Protoss protoss = new Protoss(300, 300);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> protoss.construirAcceso(areaMockeada()));
    }

    @Test
    public void test17SeConstruyeUnPuertoEstelarParaLosProtoss() {
        Protoss protoss = new Protoss(300, 300);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> protoss.construirPuertoEstelar(areaMockeada()));
    }

    @Test
    public void test18SeConstruyeUnZealotParaLosProtoss() {
        Protoss protoss = new Protoss(300, 300);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> protoss.construirZealot(areaMockeada()));
    }

    @Test
    public void test19SeConstruyeUnDragonParaLosProtoss() {
        Protoss protoss = new Protoss(300, 300);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> protoss.construirDragon(areaMockeada()));
    }

    @Test
    public void test20SeConstruyeUnScoutParaLosProtoss() {
        Protoss protoss = new Protoss(300, 300);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        assertDoesNotThrow(() -> protoss.construirScout(areaMockeada()));
    }

    public Area areaMockeada() {
        EstadoPiso estadoPisoMock = mock(EstadoPiso.class);
        when(estadoPisoMock.construible(any(ConstruiblePiso.class))).thenReturn(true);
        Recurso recursoMock = mock(Recurso.class);
        when(recursoMock.construible(any())).thenReturn(true);
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), estadoPisoMock, recursoMock);
    }

    public Criadero estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Criadero estructuraMock = mock(Criadero.class);
        when(estructuraMock.construible(any())).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);
        doNothing().when(estructuraMock).usarLarva();

        return estructuraMock;
    }
}