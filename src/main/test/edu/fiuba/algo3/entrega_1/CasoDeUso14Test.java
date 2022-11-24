package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
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
        ConstruiblePiso rangoPilon = new RangoPilon();
        Posicion posicion = new Posicion(0, 0);
        Moho moho = new Moho(posicion);

        assertThrows(ConstruccionNoValidaException.class, () -> moho.construible(rangoPilon, posicion));
    }

    @Test
    public void test02ElMohoNoPuedeExpandirseSobreUnaPosicionConEdificacion() {
        Posicion posicion = new Posicion(6, 6);
        new PuertoEstelar(posicion);

        Moho moho = new Moho(new Posicion(0, 0));
        assertThrows(PosicionOcupadaException.class, () -> moho.expandible(posicion));
    }

    @Test
    public void test03ElMohoSePuedeExpandirseSobreUnaPosicionNoOcupada() {
        Moho moho = new Moho(new Posicion(0, 0));
        assertDoesNotThrow(() -> moho.expandible(new Posicion(6, 7)));
    }
}
