package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso5Test {

    @Test
    public void test01NoSePuedeConstruirUnaEstructuraProtossFueraDelRangoDeUnPilon() {
        Construible rangoPilon = new RangoPilon();
        Pilon pilon = new Pilon(new Posicion(0, 0));
        pilon.setEstado(new Operativa());
        Posicion posicion = new Posicion(10, 10);

        assertThrows(ConstruccionNoValidaException.class, () -> pilon.construible(rangoPilon, posicion));
    }

    @Test
    public void test02NoSePuedeConstruirUnaEstructuraZergFueraDelRangoDelMoho() {
        Construible rangoMoho = new RangoMoho();
        Moho moho = new Moho(new Posicion(0, 0));
        Posicion posicion = new Posicion(10, 10);

        assertThrows(ConstruccionNoValidaException.class, () -> moho.construible(rangoMoho, posicion));
    }

    @Test
    public void test03SePuedeConstruirUnaEstructuraProtossEnElRangoDeUnPilon() {
        Construible rangoPilon = new RangoPilon();
        Pilon pilon = new Pilon(new Posicion(0, 0));
        pilon.setEstado(new Operativa());
        Posicion posicion = new Posicion(3, 3);

        assertDoesNotThrow(() -> pilon.construible(rangoPilon, posicion));
    }

    @Test
    public void test04SePuedeConstruirUnaEstructuraZergEnElRangoDelMoho() {
        Construible rangoMoho = new RangoMoho();
        Moho moho = new Moho(new Posicion(0, 0));
        Posicion posicion = new Posicion(5, 5);

        assertDoesNotThrow(() -> moho.construible(rangoMoho, posicion));
    }
}
