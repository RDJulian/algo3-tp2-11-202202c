package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16Test {
    //Supuesto, engloba al caso de uso.
    @Test
    public void test01UnaEstructuraNoSePuedeConstruirSobreOtra() {
        Posicion posicion = new Posicion(0, 0);
        Estructura unaEstructura = new Acceso();
        unaEstructura.construible(posicion);
        Estructura otraEstructura = new ReservaDeReproduccion();
        assertThrows(PosicionOcupada.class, () -> otraEstructura.construible(posicion));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
