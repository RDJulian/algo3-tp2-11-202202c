package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso5Test {

    @Test
    public void test01NoSePuedeConstruirUnaEstructuraProtossFueraDelRangoDeUnPilon() {
        ConstruiblePiso rangoPilon = new RangoPilon();
        Pilon pilon = new Pilon(new Posicion(0, 0));
        pasarKTurnos(pilon, 5);
        Posicion posicion = new Posicion(10, 10);

        assertThrows(ConstruccionNoValidaException.class, () -> pilon.construible(rangoPilon, posicion));
    }

    @Test
    public void test02NoSePuedeConstruirUnaEstructuraZergFueraDelRangoDelMoho() {
        ConstruiblePiso rangoMoho = new RangoMoho();
        Moho moho = new Moho(new Posicion(0, 0));
        Posicion posicion = new Posicion(10, 10);

        assertThrows(ConstruccionNoValidaException.class, () -> moho.construible(rangoMoho, posicion));
    }

    @Test
    public void test03SePuedeConstruirUnaEstructuraProtossEnElRangoDeUnPilon() {
        ConstruiblePiso rangoPilon = new RangoPilon();
        Pilon pilon = new Pilon(new Posicion(0, 0));
        pasarKTurnos(pilon, 5);
        Posicion posicion = new Posicion(3, 3);

        assertDoesNotThrow(() -> pilon.construible(rangoPilon, posicion));
    }

    @Test
    public void test04SePuedeConstruirUnaEstructuraZergEnElRangoDelMoho() {
        ConstruiblePiso rangoMoho = new RangoMoho();
        Moho moho = new Moho(new Posicion(0, 0));
        Posicion posicion = new Posicion(5, 5);

        assertDoesNotThrow(() -> moho.construible(rangoMoho, posicion));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
