package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso18Test {
    public ArrayList<Estructura> estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        return estructuras;
    }

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
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionAtacante = new Posicion(1, 1);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new Zerling(posicionAtacante, new Raza(), estructuraMockeadaParaTestear());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 124);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test03UnHidraliscoHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionAtacante = new Posicion(1, 1);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new Hidralisco(posicionAtacante, new Raza(), estructuraMockeadaParaTestear());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 49);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test04UnMutaliscoHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionAtacante = new Posicion(1, 1);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new Mutalisco(posicionAtacante, new Raza(), estructuraMockeadaParaTestear());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 55);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test05UnGuardianHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionAtacante = new Posicion(1, 1);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new Guardian(posicionAtacante, new Raza());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 19);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test06UnZealotHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionAtacante = new Posicion(1, 1);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new Zealot(posicionAtacante, new Raza(), estructuraMockeadaParaTestear());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 62);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test07UnDragonHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionAtacante = new Posicion(1, 1);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new Dragon(posicionAtacante, new Raza(), estructuraMockeadaParaTestear());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 24);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test08UnScoutHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Posicion posicionAtacante = new Posicion(1, 1);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new Scout(posicionAtacante, new Raza(), estructuraMockeadaParaTestear());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, estructura, 62);

        assertDoesNotThrow(estructura::operable);

        unidad.atacar(estructura);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test09UnZerlingHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad unidad = new Zerling(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 39);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test10UnHidraliscoHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Hidralisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 15);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test11UnMutaliscoHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 17);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test12UnGuardianHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Guardian(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 6);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test13UnZealotHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zerling(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 4);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test14UnDragonHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zerling(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Dragon(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 1);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test15UnScoutHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zerling(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 4);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test16UnZerlingHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad unidad = new Zerling(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test17UnHidraliscoHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Hidralisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 24);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test18UnMutaliscoHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 27);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test19UnGuardianHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Guardian(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test20UnZealotHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test21UnDragonHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Dragon(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 5);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test22UnScoutHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 8);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test23UnAmoSupremoNoHaceDanio() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new AmoSupremo(posicion, new Raza());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    @Test
    public void test24UnDevoradorHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 12);

        atacarKVeces(unidad, otraUnidad, 16);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test25UnDevoradorHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        Unidad unidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test26UnDevoradorHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Raza(), new Mineral(posicion));
        Unidad unidad = new Devorador(posicion, new Raza());

        pasarKTurnos(estructura, 12);
        pasarKTurnos(unidad, 12);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    void atacarKVeces(Unidad unidad, Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacar(entidad);
        }
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
