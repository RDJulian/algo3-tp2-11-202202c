package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso6Test {

    @Test
    public void test01ElMohoSeExpandeCadaDosTurnosYSePuedeConstruirEnElLuegoDeExpandirse() {
        ConstruiblePiso rangoMoho = new RangoMoho();
        Moho moho = new Moho(new Posicion(0, 0));
        Posicion posicion = new Posicion(6, 6);

        assertThrows(ConstruccionNoValidaException.class, () -> moho.construible(rangoMoho, posicion));

        moho.pasarTurno();
        moho.pasarTurno();

        assertDoesNotThrow(() -> moho.construible(rangoMoho, posicion));
    }
}
