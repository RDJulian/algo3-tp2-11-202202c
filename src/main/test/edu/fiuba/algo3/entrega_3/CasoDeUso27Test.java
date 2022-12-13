package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CasoDeUso27Test {

    @Test
    public void test01CreoUnMutaliscoPeroNoPuedeEvolucionarPorqueLeFaltanRecursos() {
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.reiniciar();
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.recolectarMineral(100);
        zerg.recolectarGas(100);

        Mutalisco mutalisco = new Mutalisco(areaZerg(), zerg.getEstructuras(), zerg);
        pasarKTurnos(mutalisco, 7);
        assertThrows(EvolucionNoValidaException.class, mutalisco::evolucionarADevorador);
    }

    @Test
    public void test02CreoUnMutaliscoYLoEvolucionoAUnDevorador() {
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.reiniciar();
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.recolectarMineral(100);
        zerg.recolectarGas(100);

        Mutalisco mutalisco = new Mutalisco(areaZerg(), zerg.getEstructuras(), zerg);
        pasarKTurnos(mutalisco, 7);

        zerg.recolectarMineral(150);
        zerg.recolectarGas(50);

        assertDoesNotThrow(mutalisco::evolucionarADevorador);
    }

    @Test
    public void test03UnDevoradorAtacaAUnaUnidadVoladoraHastaMatarla() {
        Unidad unidad = new Devorador(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Area(1, 1));
        pasarKTurnos(otraUnidad, 10);

        atacarKVeces(unidad, otraUnidad);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test04UnDevoradorAtacaAUnaUnidadDeTierra() {
        Unidad unidad = new Devorador(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Dragon(new Area(1, 1));
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test05UnDevoradorAtacaAUnEdificio() {
        Unidad unidad = new Devorador(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Estructura estructura = new Acceso(new Area(1, 1));
        pasarKTurnos(estructura, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    @Test
    public void test06UnDevoradorAtacaAUnaUnidadFueraDeRango() {
        Unidad unidad = new Devorador(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Area(7, 7));
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));

    }

    @Test
    public void test07UnDevoradorEsAtacadoPeroEsInvisible() {
        Unidad unidad = new Devorador(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Area(1, 0));
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> otraUnidad.atacar(unidad));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    public Area areaZerg() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
    }

    public Criadero estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Criadero estructuraMock = mock(Criadero.class);
        when(estructuraMock.construible(any())).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);
        doNothing().when(estructuraMock).usarLarva();

        return estructuraMock;
    }

    void atacarKVeces(Unidad unidad, Entidad entidad) {
        for (int i = 0; i < 16; i++) {
            unidad.atacar(entidad);
        }
    }
}