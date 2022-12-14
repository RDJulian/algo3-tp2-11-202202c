package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CasoDeUso26Test {
    @Test
    public void test01UnZanganoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(criaderoMockeadoParaTestear());

        ConstructorUnidades constructor = new ConstructorZangano(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaZerg()));

        zerg.recolectarGas(0);
        zerg.recolectarMineral(25);

        assertDoesNotThrow(() -> constructor.construir(areaZerg()));
    }

    @Test
    public void test02UnAmoSupremoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(criaderoMockeadoParaTestear());

        ConstructorUnidades constructor = new ConstructorAmoSupremo(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaZerg()));

        zerg.recolectarGas(0);
        zerg.recolectarMineral(50);

        assertDoesNotThrow(() -> constructor.construir(areaZerg()));
    }

    @Test
    public void test03UnDevoradorNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(criaderoMockeadoParaTestear());

        ConstructorUnidades constructor = new ConstructorDevorador(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaZerg()));

        zerg.recolectarGas(50);
        zerg.recolectarMineral(150);

        assertDoesNotThrow(() -> constructor.construir(areaZerg()));
    }

    @Test
    public void test04UnDragonNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Protoss protoss = new Protoss(0, 0);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());

        ConstructorUnidades constructor = new ConstructorDragon(protoss.getEstructuras(), protoss);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaProtoss()));

        protoss.recolectarGas(50);
        protoss.recolectarMineral(125);

        assertDoesNotThrow(() -> constructor.construir(areaProtoss()));
    }

    @Test
    public void test05UnGuardianNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(criaderoMockeadoParaTestear());

        ConstructorUnidades constructor = new ConstructorGuardian(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaZerg()));

        zerg.recolectarGas(100);
        zerg.recolectarMineral(50);

        assertDoesNotThrow(() -> constructor.construir(areaZerg()));
    }

    @Test
    public void test06UnHidraliscoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(criaderoMockeadoParaTestear());

        ConstructorUnidades constructor = new ConstructorHidralisco(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaZerg()));

        zerg.recolectarGas(25);
        zerg.recolectarMineral(75);

        assertDoesNotThrow(() -> constructor.construir(areaZerg()));
    }

    @Test
    public void test07UnMutaliscoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(criaderoMockeadoParaTestear());

        ConstructorUnidades constructor = new ConstructorMutalisco(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaZerg()));

        zerg.recolectarGas(100);
        zerg.recolectarMineral(100);

        assertDoesNotThrow(() -> constructor.construir(areaZerg()));
    }

    @Test
    public void test08UnZealotNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Protoss protoss = new Protoss(0, 0);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());

        ConstructorUnidades constructor = new ConstructorZealot(protoss.getEstructuras(), protoss);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaProtoss()));

        protoss.recolectarGas(0);
        protoss.recolectarMineral(100);

        assertDoesNotThrow(() -> constructor.construir(areaProtoss()));
    }

    @Test
    public void test09UnScoutNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Protoss protoss = new Protoss(0, 0);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());

        ConstructorUnidades constructor = new ConstructorScout(protoss.getEstructuras(), protoss);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaProtoss()));

        protoss.recolectarGas(150);
        protoss.recolectarMineral(300);

        assertDoesNotThrow(() -> constructor.construir(areaProtoss()));
    }

    @Test
    public void test10UnZerlingNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(criaderoMockeadoParaTestear());

        ConstructorUnidades constructor = new ConstructorZerling(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(areaZerg()));

        zerg.recolectarGas(0);
        zerg.recolectarMineral(25);

        assertDoesNotThrow(() -> constructor.construir(areaZerg()));
    }

    public Estructura estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);

        return estructuraMock;
    }

    public Criadero criaderoMockeadoParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Criadero estructuraMock = mock(Criadero.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);
        doNothing().when(estructuraMock).usarLarva();

        return estructuraMock;
    }

    public Area areaProtoss() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
    }

    public Area areaZerg() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
    }
}
