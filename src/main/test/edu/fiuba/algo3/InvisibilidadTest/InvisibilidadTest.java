package edu.fiuba.algo3.InvisibilidadTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zealot;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class InvisibilidadTest {
    @Test
    public void test01UnZealotSeHaceInvisibleSeAcercaAUnAmoSupremoYEsAtacable() {
        Protoss protoss = new Protoss(1000, 1000);
        Zerg zerg = new Zerg(1000, 1000);
        protoss.asignarContrincante(zerg);
        zerg.asignarContrincante(protoss);

        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.registrarEntidad(estructuraMockeadaParaTestear());

        Zealot zealot = new Zealot(areaProtoss(), protoss.getEstructuras(), protoss);
        pasarKTurnos(zealot, 4);
        zealot.sumarBaja();
        zealot.sumarBaja();
        zealot.sumarBaja();

        AmoSupremo amoSupremo = new AmoSupremo(new Area(10, 10));
        pasarKTurnos(amoSupremo, 5);

        Area areaAMover = new Area(3, 3);

        protoss.registrarEntidad(zealot);
        zerg.registrarEntidad(amoSupremo);

        zealot.moverse(areaAMover);
        zealot.pasarTurno();
        zealot.moverse(new Area(6, 6));

        Guardian guardian = new Guardian(new Area(1, 1));
        pasarKTurnos(guardian, 4);

        assertDoesNotThrow(() -> guardian.atacar(zealot));
    }

    @Test
    public void test02UnScoutSeAcercaAUnCriaderoYLoRevela() {
        Protoss protoss = new Protoss(1000, 1000);
        Zerg zerg = new Zerg(1000, 1000);
        protoss.asignarContrincante(zerg);
        zerg.asignarContrincante(protoss);

        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.registrarEntidad(estructuraMockeadaParaTestear());

        Scout scout = new Scout(areaProtoss(), protoss.getEstructuras(), protoss);
        pasarKTurnos(scout, 9);

        Criadero criadero = new Criadero(new Area(10, 10));

        Area areaAMover = new Area(3, 3);

        zerg.registrarEntidad(criadero);

        scout.moverse(areaAMover);
        scout.pasarTurno();
        scout.moverse(new Area(6, 6));

        assertDoesNotThrow(() -> scout.atacar(criadero));
    }

    @Test
    public void test03UnScoutSeAcercaAUnAmoSupremoYLoRevela() {
        Protoss protoss = new Protoss(1000, 1000);
        Zerg zerg = new Zerg(1000, 1000);
        protoss.asignarContrincante(zerg);
        zerg.asignarContrincante(protoss);

        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.registrarEntidad(estructuraMockeadaParaTestear());

        Scout scout = new Scout(areaProtoss(), protoss.getEstructuras(), protoss);
        pasarKTurnos(scout, 9);

        AmoSupremo amoSupremo = new AmoSupremo(new Area(10, 10));

        Area areaAMover = new Area(3, 3);

        zerg.registrarEntidad(amoSupremo);

        scout.moverse(areaAMover);
        scout.pasarTurno();
        scout.moverse(new Area(6, 6));

        assertDoesNotThrow(() -> scout.atacar(amoSupremo));
    }

    @Test
    public void test04UnAmoSupremoSeMueveCercaDeUnZealotInvisibleYUnScoutYAmbosSeRevelan() {
        Protoss protoss = new Protoss(1000, 1000);
        Zerg zerg = new Zerg(1000, 1000);
        protoss.asignarContrincante(zerg);
        zerg.asignarContrincante(protoss);

        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.registrarEntidad(estructuraMockeadaParaTestear());

        AmoSupremo amoSupremo = new AmoSupremo(areaZerg(), zerg);
        pasarKTurnos(amoSupremo, 5);

        Zealot zealot = new Zealot(new Area(10, 10));
        pasarKTurnos(zealot, 4);
        zealot.sumarBaja();
        zealot.sumarBaja();
        zealot.sumarBaja();

        Scout scout = new Scout(new Area(10, 9));
        pasarKTurnos(scout, 9);

        Area areaAMover = new Area(9, 9);

        protoss.registrarEntidad(zealot);
        protoss.registrarEntidad(scout);
        zerg.registrarEntidad(amoSupremo);

        amoSupremo.moverse(new Area(3, 3));
        amoSupremo.pasarTurno();
        amoSupremo.moverse(new Area(6, 6));
        amoSupremo.pasarTurno();
        amoSupremo.moverse(areaAMover);

        Guardian guardian = new Guardian(new Area(1, 1));
        pasarKTurnos(guardian, 4);

        assertDoesNotThrow(() -> guardian.atacar(zealot));
        assertDoesNotThrow(() -> scout.atacar(amoSupremo));
    }

    @Test
    public void test05UnScoutSeHaceInvisibleEnElRangoDeUnAmoSupremoYSigueSiendoAtacable() {
        Protoss protoss = new Protoss(1000, 1000);
        Zerg zerg = new Zerg(1000, 1000);
        protoss.asignarContrincante(zerg);
        zerg.asignarContrincante(protoss);

        protoss.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.registrarEntidad(estructuraMockeadaParaTestear());

        AmoSupremo amoSupremo = new AmoSupremo(areaZerg(), zerg);
        Zealot zealot = new Zealot(areaProtoss(), protoss.getEstructuras(), protoss);

        protoss.registrarEntidad(zealot);
        zerg.registrarEntidad(amoSupremo);

        pasarKTurnos(amoSupremo, 5);
        pasarKTurnos(zealot, 4);

        zealot.sumarBaja();
        zealot.sumarBaja();
        zealot.sumarBaja();

        Guardian guardian = new Guardian(new Area(1, 1));
        pasarKTurnos(guardian, 4);

        assertDoesNotThrow(() -> guardian.atacar(zealot));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    public Area areaProtoss() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
    }

    public Area areaZerg() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
    }

    public Criadero estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        //Ni del suministro
        Criadero estructuraMock = mock(Criadero.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);
        doNothing().when(estructuraMock).usarLarva();

        return estructuraMock;
    }
}