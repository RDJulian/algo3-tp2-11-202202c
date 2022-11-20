package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.RangoMoho;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso13Test {
    @Test
    public void test01UnCriaderoSeConstruyeCreaMohoLuegoEsDestruidaPeroElMohoSigueEstando() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        Construible sobreMoho = new RangoMoho();

        //Idealmente se ejecuta junto a la construccion.
        Piso nuevoMoho = criadero.generarMoho();
        pasarKTurnos(criadero, 4);

        criadero.daniar(600, 0);

        assertThrows(EntidadDestruidaException.class, criadero::operable);

        assertDoesNotThrow(() -> nuevoMoho.construible(sobreMoho, new Posicion(-3, -3)));

    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
