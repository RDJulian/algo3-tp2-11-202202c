package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.EstadoEstructura.Operativa;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Unidad.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso18Test {

    //Supuesto: Todas las estructuras se construyen en Tierra.
    //Extender este caso de uso para que se ataquen entre unidades.

    //Buscar otra forma de probar esto para no necesitar un getter.
    @Test
    public void test01UnZanganoNoHaceDanioAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(), new Reserva());
        estructura.setEstado(new Operativa());
        Unidad unidad = new Zangano();

        unidad.atacarEstructura(estructura);

        assertEquals(estructura.getDefensa(), 250);
    }

    @Test
    public void test02UnZerlingHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(), new Reserva());
        estructura.setEstado(new Operativa());
        Unidad unidad = new Zerling();

        atacarKVeces(unidad, estructura, 124);

        assertDoesNotThrow(estructura::operable);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruidaException.class, estructura::operable);
    }

    @Test
    public void test03UnHidraliscoHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(), new Reserva());
        estructura.setEstado(new Operativa());
        Unidad unidad = new Hidralisco();

        atacarKVeces(unidad, estructura, 49);

        assertDoesNotThrow(estructura::operable);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruidaException.class, estructura::operable);
    }

    @Test
    public void test04UnMutaliscoHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(), new Reserva());
        estructura.setEstado(new Operativa());
        Unidad unidad = new Mutalisco();

        atacarKVeces(unidad, estructura, 55);

        assertDoesNotThrow(estructura::operable);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruidaException.class, estructura::operable);
    }

    @Test
    public void test05UnGuardianHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(), new Reserva());
        estructura.setEstado(new Operativa());
        Unidad unidad = new Guardian();

        atacarKVeces(unidad, estructura, 19);

        assertDoesNotThrow(estructura::operable);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruidaException.class, estructura::operable);
    }

    @Test
    public void test06UnZealotHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(), new Reserva());
        estructura.setEstado(new Operativa());
        Unidad unidad = new Zealot();

        atacarKVeces(unidad, estructura, 62);

        assertDoesNotThrow(estructura::operable);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruidaException.class, estructura::operable);
    }

    @Test
    public void test07UnDragonHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(), new Reserva());
        estructura.setEstado(new Operativa());
        Unidad unidad = new Dragon();

        atacarKVeces(unidad, estructura, 24);

        assertDoesNotThrow(estructura::operable);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruidaException.class, estructura::operable);
    }

    @Test
    public void test08UnScoutHaceElDanioEsperadoAUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(), new Reserva());
        estructura.setEstado(new Operativa());
        Unidad unidad = new Scout();

        atacarKVeces(unidad, estructura, 62);

        assertDoesNotThrow(estructura::operable);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruidaException.class, estructura::operable);
    }

    @Test
    public void test09UnZerlingHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad unidad = new Zerling();
        Unidad otraUnidad = new Zealot();

        atacarKVeces(unidad, otraUnidad, 39);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test10UnHidraliscoHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zealot();
        Unidad unidad = new Hidralisco();

        atacarKVeces(unidad, otraUnidad, 15);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test11UnMutaliscoHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zealot();
        Unidad unidad = new Mutalisco();

        atacarKVeces(unidad, otraUnidad, 17);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test12UnGuardianHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zealot();
        Unidad unidad = new Guardian();

        atacarKVeces(unidad, otraUnidad, 6);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test13UnZealotHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zerling();
        Unidad unidad = new Zealot();

        atacarKVeces(unidad, otraUnidad, 4);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test14UnDragonHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zerling();
        Unidad unidad = new Dragon();

        atacarKVeces(unidad, otraUnidad, 1);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test15UnScoutHaceElDanioEsperadoAUnaUnidadDeTierra() {
        Unidad otraUnidad = new Zerling();
        Unidad unidad = new Scout();

        atacarKVeces(unidad, otraUnidad, 4);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test16UnZerlingHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad unidad = new Zerling();
        Unidad otraUnidad = new Scout();

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test17UnHidraliscoHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Scout();
        Unidad unidad = new Hidralisco();

        atacarKVeces(unidad, otraUnidad, 24);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test18UnMutaliscoHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Scout();
        Unidad unidad = new Mutalisco();

        atacarKVeces(unidad, otraUnidad, 27);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test19UnGuardianHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Scout();
        Unidad unidad = new Guardian();

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test20UnZealotHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Mutalisco();
        Unidad unidad = new Zealot();

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test21UnDragonHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Mutalisco();
        Unidad unidad = new Dragon();

        atacarKVeces(unidad, otraUnidad, 5);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test22UnScoutHaceElDanioEsperadoAUnaUnidadDeAire() {
        Unidad otraUnidad = new Mutalisco();
        Unidad unidad = new Scout();

        atacarKVeces(unidad, otraUnidad, 8);

        assertDoesNotThrow(() -> unidad.atacarUnidad(otraUnidad));
        assertThrows(EstructuraDestruidaException.class, () -> unidad.atacarUnidad(otraUnidad));
    }

    void atacarKVeces(Unidad unidad, edu.fiuba.algo3.modelo.Estructura.Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacarEstructura(estructura);
        }
    }

    void atacarKVeces(Unidad unidad, Unidad otraUnidad, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacarUnidad(otraUnidad);
        }
    }
}
