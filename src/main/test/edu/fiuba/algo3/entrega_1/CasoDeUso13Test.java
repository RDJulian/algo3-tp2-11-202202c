package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRango;
import edu.fiuba.algo3.modelo.Construible.RangoMoho;
import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraDestruidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso13Test {
    @Test
    public void test01UnCriaderoSeConstruyeCreaMohoLuegoEsDestruidaPeroElMohoSigueEstando() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        ConstruibleSobreRango sobreMoho = new RangoMoho();

        //Idealmente se ejecuta junto a la construccion.
        Piso nuevoMoho = criadero.generarMoho();
        pasarKTurnos(criadero, 4);

        criadero.daniar(600);

        assertThrows(EstructuraDestruidaException.class, criadero::operable);

        assertDoesNotThrow(() -> nuevoMoho.construible(sobreMoho, new Posicion(-3, -3)));

    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
