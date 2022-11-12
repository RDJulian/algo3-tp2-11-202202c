package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraDestruida;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso13Test {
    @Test
    public void test01UnCriaderoSeConstruyeCreaMohoLuegoEsDestruidaPeroElMohoSigueEstando() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        Estructura reservaDeReproduccion = new ReservaDeReproduccion(new Posicion(-3, -3));
        Moho moho = new Moho(new Posicion(2, 2));

        Piso nuevoMoho = criadero.construible(moho);
        pasarKTurnos(criadero, 4);

        criadero.daniar(600);

        assertThrows(EstructuraDestruida.class, criadero::operar);

        assertDoesNotThrow(() -> {
            reservaDeReproduccion.construible(nuevoMoho);
        });

    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
