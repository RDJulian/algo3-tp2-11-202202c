package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso12Test {
    @Test
    public void test01DaniarUnaEstructuraProtossHastaQuitarleVidaDeberiaRegenerarSoloSuEscudoAlPasarTurnos() {
        Estructura estructura = new Acceso(new Posicion(0,0));
        Pilon pilon = new Pilon(new Posicion(1,1));
        pasarKTurnos(pilon, 5);
        estructura.construible(pilon);

        pasarKTurnos(estructura,8);
        estructura.daniar(555);

        assertEquals(estructura.getVida(), 445);
        assertEquals(estructura.getDefensa(), 0);

        pasarKTurnos(estructura,49);

        assertEquals(estructura.getDefensa(), 490);

        pasarKTurnos(estructura,3);

        assertEquals(estructura.getDefensa(), 500);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

}