package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso18Test {
    //Supuesto: Todas las estructuras se construyen en Tierra.
    @Test
    public void test01UnZanganoNoHaceDanio() {
        Estructura estructura = new NexoMineral();
        Unidad unidad = new Zangano();

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    @Test
    public void test02UnZerlingHaceElDanioEsperadoAUnaEstructura() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new Zerling(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 124);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test03UnHidraliscoHaceElDanioEsperadoAUnaEstructura() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new Hidralisco(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 49);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test04UnMutaliscoHaceElDanioEsperadoAUnaEstructura() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new Mutalisco(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 55);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test05UnGuardianHaceElDanioEsperadoAUnaEstructura() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new Guardian(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 19);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test06UnZealotHaceElDanioEsperadoAUnaEstructura() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new Zealot(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 62);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test07UnDragonHaceElDanioEsperadoAUnaEstructura() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new Dragon(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 24);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test08UnScoutHaceElDanioEsperadoAUnaEstructura() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new Scout(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 62);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test09UnZerlingHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad unidad = new Zerling(area);
        Unidad otraUnidad = new Zealot(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 39);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test10UnHidraliscoHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Zealot(area);
        Unidad unidad = new Hidralisco(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 15);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test11UnMutaliscoHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Zealot(area);
        Unidad unidad = new Mutalisco(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 17);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test12UnGuardianHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Zealot(area);
        Unidad unidad = new Guardian(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 6);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test13UnZealotHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Zerling(area);
        Unidad unidad = new Zealot(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 4);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test14UnDragonHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Zerling(area);
        Unidad unidad = new Dragon(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 1);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test15UnScoutHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Zerling(area);
        Unidad unidad = new Scout(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 4);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test16UnZerlingHaceElDanioEsperadoAUnaUnidadDeAire() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad unidad = new Zerling(area);
        Unidad otraUnidad = new Scout(areaAtacante);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test17UnHidraliscoHaceElDanioEsperadoAUnaUnidadDeAire() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Scout(area);
        Unidad unidad = new Hidralisco(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 24);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test18UnMutaliscoHaceElDanioEsperadoAUnaUnidadDeAire() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Scout(area);
        Unidad unidad = new Mutalisco(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 27);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test19UnGuardianHaceElDanioEsperadoAUnaUnidadDeAire() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Scout(area);
        Unidad unidad = new Guardian(areaAtacante);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test20UnZealotHaceElDanioEsperadoAUnaUnidadDeAire() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Mutalisco(area);
        Unidad unidad = new Zealot(areaAtacante);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test21UnDragonHaceElDanioEsperadoAUnaUnidadDeAire() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Mutalisco(area);
        Unidad unidad = new Dragon(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 5);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test22UnScoutHaceElDanioEsperadoAUnaUnidadDeAire() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Mutalisco(area);
        Unidad unidad = new Scout(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 8);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test23UnAmoSupremoNoHaceDanio() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new AmoSupremo(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    @Test
    public void test24UnDevoradorHaceElDanioEsperadoAUnaUnidadDeAire() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Scout(area);
        Unidad unidad = new Devorador(areaAtacante);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 16);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        unidad.pasarTurno();
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test25UnDevoradorHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Unidad otraUnidad = new Zealot(area);
        Unidad unidad = new Devorador(areaAtacante);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test26UnDevoradorHaceElDanioEsperadoAUnaEstructura() {
        Area area = new Area(0, 0);
        Area areaAtacante = new Area(1, 1);
        Estructura estructura = new NexoMineral(area);
        Unidad unidad = new Devorador(areaAtacante);

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    void atacarKVeces(Unidad unidad, Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacar(entidad);
            unidad.pasarTurno();
        }
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
