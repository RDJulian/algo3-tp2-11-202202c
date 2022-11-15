package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.EstadoEstructura.Operativo;
import edu.fiuba.algo3.modelo.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraDestruida;
import edu.fiuba.algo3.modelo.Unidad.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso18Test {

    //Supuesto: Todas las estructuras se construyen en Tierra.

    //Buscar otra forma de probar esto para no necesitar un getter.
    @Test
    public void test01UnZanganoNoHaceDanioAUnaEstructura() {
        Estructura estructura = new NexoMineral();
        estructura.setEstadoOperativo(new Operativo());
        Unidad unidad = new Zangano();

        unidad.atacarEstructura(estructura);

        assertEquals(estructura.getDefensa(), 250);
    }

    @Test
    public void test02UnZerlingHaceElDanioEsperadoAUnaEstructura() {
        Estructura estructura = new NexoMineral();
        estructura.setEstadoOperativo(new Operativo());
        Unidad unidad = new Zerling();

        atacarKVeces(unidad, estructura, 124);

        assertDoesNotThrow(estructura::operar);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruida.class, estructura::operar);
    }

    @Test
    public void test03UnHidraliscoHaceElDanioEsperadoAUnaEstructura() {
        Estructura estructura = new NexoMineral();
        estructura.setEstadoOperativo(new Operativo());
        Unidad unidad = new Hidralisco();

        atacarKVeces(unidad, estructura, 49);

        assertDoesNotThrow(estructura::operar);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruida.class, estructura::operar);
    }

    @Test
    public void test04UnMutaliscoHaceElDanioEsperadoAUnaEstructura() {
        Estructura estructura = new NexoMineral();
        estructura.setEstadoOperativo(new Operativo());
        Unidad unidad = new Mutalisco();

        atacarKVeces(unidad, estructura, 55);

        assertDoesNotThrow(estructura::operar);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruida.class, estructura::operar);
    }

    @Test
    public void test05UnGuardianHaceElDanioEsperadoAUnaEstructura() {
        Estructura estructura = new NexoMineral();
        estructura.setEstadoOperativo(new Operativo());
        Unidad unidad = new Guardian();

        atacarKVeces(unidad, estructura, 19);

        assertDoesNotThrow(estructura::operar);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruida.class, estructura::operar);
    }

    @Test
    public void test06UnZealotHaceElDanioEsperadoAUnaEstructura() {
        Estructura estructura = new Criadero();
        estructura.setEstadoOperativo(new Operativo());
        Unidad unidad = new Zealot();

        atacarKVeces(unidad, estructura, 62);

        assertDoesNotThrow(estructura::operar);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruida.class, estructura::operar);
    }

    @Test
    public void test07UnDragonHaceElDanioEsperadoAUnaEstructura() {
        Estructura estructura = new Criadero();
        estructura.setEstadoOperativo(new Operativo());
        Unidad unidad = new Dragon();

        atacarKVeces(unidad, estructura, 24);

        assertDoesNotThrow(estructura::operar);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruida.class, estructura::operar);
    }

    @Test
    public void test08UnScoutHaceElDanioEsperadoAUnaEstructura() {
        Estructura estructura = new Criadero();
        estructura.setEstadoOperativo(new Operativo());
        Unidad unidad = new Scout();

        atacarKVeces(unidad, estructura, 62);

        assertDoesNotThrow(estructura::operar);

        unidad.atacarEstructura(estructura);

        assertThrows(EstructuraDestruida.class, estructura::operar);
    }

    void atacarKVeces(Unidad unidad, Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacarEstructura(estructura);
        }
    }
}
