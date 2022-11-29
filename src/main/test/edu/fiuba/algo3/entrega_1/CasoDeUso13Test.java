package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso13Test {
    @Test
    public void test01UnCriaderoSeConstruyeCreaMohoLuegoEsDestruidaPeroElMohoSigueEstando() {
        Posicion posicion = new Posicion(0, 0);
        Criadero criadero = new Criadero(posicion, new Raza());
        ConstruiblePiso sobreMoho = new RangoMoho();

        //Idealmente se ejecuta junto a la construccion.
        Piso nuevoMoho = criadero.generarMoho();

        criadero.daniar(600, 0, posicion, 1, new Guardian(posicion, new Raza()));

        assertThrows(EntidadDestruidaException.class, criadero::operable);

        assertDoesNotThrow(() -> nuevoMoho.construible(sobreMoho, new Posicion(-3, -3)));

    }
}
