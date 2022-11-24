package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.RangoMoho;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso13Test {
    @Test
    public void test01UnCriaderoSeConstruyeCreaMohoLuegoEsDestruidaPeroElMohoSigueEstando() {
        Rango rango = new Rango(new Posicion(0, 0), 1);
        Criadero criadero = new Criadero(new Posicion(0, 0));
        ConstruiblePiso sobreMoho = new RangoMoho();

        //Idealmente se ejecuta junto a la construccion.
        Piso nuevoMoho = criadero.generarMoho();
        pasarKTurnos(criadero, 4);

        criadero.daniar(600, 0, rango);

        assertThrows(EntidadDestruidaException.class, criadero::operable);

        assertDoesNotThrow(() -> nuevoMoho.construible(sobreMoho, new Posicion(-3, -3)));

    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
