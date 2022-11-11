package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10Test {
    @Test
    public void test01DaniarUnaEstructuraZergDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0,0));
        Moho moho = new Moho(new Posicion(1,1));
        estructura.construible(moho);

        pasarKTurnos(estructura,10);
        estructura.daniar(105);

        assertEquals(estructura.getVida(), 1195);

        pasarKTurnos(estructura,10);

        assertEquals(estructura.getVida(), 1295);

        estructura.pasarTurno();

        assertEquals(estructura.getVida(), 1300);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

}
