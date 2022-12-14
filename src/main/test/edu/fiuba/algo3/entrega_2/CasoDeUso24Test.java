package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.BaseNoOpuestaException;
import edu.fiuba.algo3.modelo.Mapa.Base;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso24Test {
    //Simulamos la comparacion de las bases, que eventualmente se hara en una potencial clase Juego
    @Test
    public void test01UnaPartidaNoPuedeArrancarSiLosDosJugadoresNoEmpiezanEnBasesOpuestas() {
        Base unaBase = new Base(20, 20);
        Base otraBase = new Base(-20, -20);
        Base baseNoOpuesta = new Base(20, -20);

        assertThrows(BaseNoOpuestaException.class, () -> unaBase.opuesta(baseNoOpuesta));
        assertDoesNotThrow(() -> unaBase.opuesta(otraBase));
    }
}