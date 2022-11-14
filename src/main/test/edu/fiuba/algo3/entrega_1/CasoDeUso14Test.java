package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupada;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso14Test {
    @Test
    public void test01UnaEstructuraProtossNoSePuedeConstruirSobreMoho() {
        Estructura acceso = new Acceso();
        Estructura nexoMineral = new NexoMineral();
        Estructura asimilador = new Asimilador();
        Estructura pilon = new Pilon();
        Estructura puertoEstelar = new PuertoEstelar();
        acceso.construible(new Posicion(0, 0));
        nexoMineral.construible(new Posicion(0, 0));
        asimilador.construible(new Posicion(0, 0));
        pilon.construible(new Posicion(0, 0));
        puertoEstelar.construible(new Posicion(0, 0));
        Piso moho = new Moho(new Posicion(3, 3));

        assertThrows(ConstruccionNoValida.class, () -> acceso.construiblePiso(moho));
        assertThrows(ConstruccionNoValida.class, () -> nexoMineral.construiblePiso(moho));
        assertThrows(ConstruccionNoValida.class, () -> asimilador.construiblePiso(moho));
        assertThrows(ConstruccionNoValida.class, () -> pilon.construiblePiso(moho));
        assertThrows(ConstruccionNoValida.class, () -> puertoEstelar.construiblePiso(moho));
    }

    @Test
    public void test02ElMohoNoPuedeExpandirseSobreUnaPosicionConEdificacion() {
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        puertoEstelar.construible(new Posicion(6, 6));

        Moho moho = new Moho(new Posicion(0, 0));
        assertThrows(PosicionOcupada.class, () -> moho.expandibleSobre(puertoEstelar));
    }

    @Test
    public void test03ElMohoSePuedeExpandirseSobreUnaPosicionNoOcupada() {
        Moho moho = new Moho(new Posicion(0, 0));
        assertDoesNotThrow(() -> moho.expandibleSobre(new Posicion(6, 7)));
    }
}
