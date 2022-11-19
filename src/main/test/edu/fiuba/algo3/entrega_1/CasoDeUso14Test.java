package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRango;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso14Test {
    @Test
    public void test01UnaEstructuraProtossNoSePuedeConstruirSobreMoho() {
        ConstruibleSobreRango rangoPilon = new RangoPilon();
        Posicion posicion = new Posicion(0, 0);
        Moho moho = new Moho(posicion);

        assertThrows(ConstruccionNoValidaException.class, () -> moho.construible(rangoPilon, posicion));
    }

    @Test
    public void test02ElMohoNoPuedeExpandirseSobreUnaPosicionConEdificacion() {
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Posicion(6, 6));

        Moho moho = new Moho(new Posicion(0, 0));
        assertThrows(PosicionOcupadaException.class, () -> moho.expandibleSobre(puertoEstelar));
    }

    @Test
    public void test03ElMohoSePuedeExpandirseSobreUnaPosicionNoOcupada() {
        Moho moho = new Moho(new Posicion(0, 0));
        assertDoesNotThrow(() -> moho.expandibleSobre(new Posicion(6, 7)));
    }
}
