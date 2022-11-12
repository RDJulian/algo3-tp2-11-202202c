package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10Test {
    @Test
    public void test01DaniarUnaEstructuraZergDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        Moho moho = new Moho(new Posicion(1, 1));
        estructura.construible(moho);

        pasarKTurnos(estructura, 10);
        estructura.daniar(105);

        assertEquals(estructura.getVida(), 1195);

        pasarKTurnos(estructura, 10);

        assertEquals(estructura.getVida(), 1295);

        estructura.pasarTurno();

        assertEquals(estructura.getVida(), 1300);
    }

    @Test
    public void test02DaniarUnaEstructuraZergEnConstruccionDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        Moho moho = new Moho(new Posicion(1, 1));
        estructura.construible(moho);

        estructura.daniar(200);

        pasarKTurnos(estructura, 10);

        assertEquals(estructura.getVida(), 1200);
    }

    @Test
    public void test03DestruirUnaEstructuraZergNoDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        Moho moho = new Moho(new Posicion(1, 1));
        estructura.construible(moho);

        pasarKTurnos(estructura, 10);
        estructura.daniar(1300);

        assertEquals(estructura.getVida(), 0);

        pasarKTurnos(estructura, 20);

        assertEquals(estructura.getVida(), 0);
    }

    @Test
    public void test04DestruirUnaEstructuraZergEnConstruccionNoDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        Moho moho = new Moho(new Posicion(1, 1));
        estructura.construible(moho);

        estructura.daniar(1300);

        assertEquals(estructura.getVida(), 0);

        pasarKTurnos(estructura, 20);

        assertEquals(estructura.getVida(), 0);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

}
