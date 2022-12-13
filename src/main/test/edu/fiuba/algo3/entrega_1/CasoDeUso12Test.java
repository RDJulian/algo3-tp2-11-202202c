package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso12Test {
    @Test
    public void test01DaniarUnaEstructuraProtossHastaQuitarleVidaDeberiaRegenerarSoloSuEscudoAlPasarTurnos() {
        Estructura estructura = new Acceso();
        pasarKTurnos(estructura, 12);

        estructura.daniar(600);
        //0 E 400 V

        pasarKTurnos(estructura, 50);
        //500 E 400V

        estructura.daniar(900);
        //Si regenerase vida, aguantaria el golpe.

        assertThrows(EntidadDestruidaException.class, () -> estructura.operable());
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}