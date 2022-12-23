package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso22Test {
    //Supuesto: todas las unidades Zerg (exceptuando evoluciones) deben tener un criadero con larva.
    //AmoSupremo no requiere ninguna otra estructura para funcionar.

    @Test
    public void test01UnAmoSupremoSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);
        zerg.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorAmoSupremo(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidades.construir(areaZerg()));

        Criadero criadero = new Criadero();
        pasarKTurnos(criadero, 4);
        zerg.registrarEntidad(criadero);

        Unidad unidad = constructorUnidades.construir(areaZerg());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 5);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test02UnDevoradorSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);
        zerg.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorDevorador(zerg.getEstructuras(), zerg);

        Unidad unidad = constructorUnidades.construir(areaZerg());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 4);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test03UnDragonSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Protoss protoss = new Protoss();
        protoss.recolectarMineral(1000);
        protoss.recolectarGas(1000);
        protoss.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorDragon(protoss.getEstructuras(), protoss);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidades.construir(areaProtoss()));

        Acceso acceso = new Acceso();
        pasarKTurnos(acceso, 8);
        protoss.registrarEntidad(acceso);

        Unidad unidad = constructorUnidades.construir(areaProtoss());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 6);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test04UnGuardianSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);
        zerg.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorGuardian(zerg.getEstructuras(), zerg);

        Unidad unidad = constructorUnidades.construir(areaZerg());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 4);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test05UnHidraliscoSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);
        zerg.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorHidralisco(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidades.construir(areaZerg()));

        Criadero criadero = new Criadero();
        pasarKTurnos(criadero, 4);
        zerg.registrarEntidad(criadero);

        Guarida guarida = new Guarida();
        pasarKTurnos(guarida, 12);
        zerg.registrarEntidad(guarida);

        Unidad unidad = constructorUnidades.construir(areaZerg());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 4);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test06UnMutaliscoSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);
        zerg.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorMutalisco(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidades.construir(areaZerg()));

        Criadero criadero = new Criadero();
        pasarKTurnos(criadero, 4);
        zerg.registrarEntidad(criadero);

        Espiral espiral = new Espiral();
        pasarKTurnos(espiral, 10);
        zerg.registrarEntidad(espiral);

        Unidad unidad = constructorUnidades.construir(areaZerg());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 7);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test07UnScoutSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Protoss protoss = new Protoss();
        protoss.recolectarMineral(1000);
        protoss.recolectarGas(1000);
        protoss.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorScout(protoss.getEstructuras(), protoss);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidades.construir(areaProtoss()));

        PuertoEstelar puertoEstelar = new PuertoEstelar();
        pasarKTurnos(puertoEstelar, 10);
        protoss.registrarEntidad(puertoEstelar);

        Unidad unidad = constructorUnidades.construir(areaProtoss());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 9);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test08UnZanganoSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);
        zerg.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorZangano(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidades.construir(areaZerg()));

        Criadero criadero = new Criadero();
        pasarKTurnos(criadero, 4);
        zerg.registrarEntidad(criadero);

        Unidad unidad = constructorUnidades.construir(areaZerg());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 1);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test09UnZealotSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Protoss protoss = new Protoss();
        protoss.recolectarMineral(1000);
        protoss.recolectarGas(1000);
        protoss.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorZealot(protoss.getEstructuras(), protoss);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidades.construir(areaProtoss()));

        Acceso acceso = new Acceso();
        pasarKTurnos(acceso, 8);
        protoss.registrarEntidad(acceso);

        Unidad unidad = constructorUnidades.construir(areaProtoss());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 4);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test10UnZerlingSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);
        zerg.registrarEntidad(estructuraMockeadaParaSuministro());

        ConstructorUnidades constructorUnidades = new ConstructorZerling(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorUnidades.construir(areaZerg()));

        Criadero criadero = new Criadero();
        pasarKTurnos(criadero, 4);
        zerg.registrarEntidad(criadero);

        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        pasarKTurnos(reservaDeReproduccion, 12);
        zerg.registrarEntidad(reservaDeReproduccion);

        Unidad unidad = constructorUnidades.construir(areaZerg());

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 2);

        assertDoesNotThrow(unidad::operable);
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

    public Estructura estructuraMockeadaParaSuministro() {
        Estructura estructura = mock(Estructura.class);
        when(estructura.afectarSuministro(any(int.class))).thenReturn(200);
        return estructura;
    }
}
