package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso12Test {
    @Test
    public void test01DaniarUnaEstructuraProtossHastaQuitarleVidaDeberiaRegenerarSoloSuEscudoAlPasarTurnos() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new Acceso(posicion);
        pasarKTurnos(estructura, 12);

        estructura.daniar(600, 0, posicion, 1, new Guardian(posicion));
        //0 E 400 V

        pasarKTurnos(estructura, 50);
        //500 E 400V

        estructura.daniar(900, 0, posicion, 1, new Guardian(posicion));
        //Si regenerase vida, aguantaria el golpe.

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
