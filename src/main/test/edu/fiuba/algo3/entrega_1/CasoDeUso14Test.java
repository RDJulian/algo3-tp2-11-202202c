package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupada;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso14Test {
    @Test
    public void test01UnaEstructuraProtossNoSePuedeConstruirSobreMoho() {
        Estructura acceso = new Acceso(new Posicion(0, 0));
        Estructura nexoMineral = new NexoMineral(new Posicion(0, 0));
        Estructura asimilador = new Asimilador(new Posicion(0, 0));
        Estructura pilon = new Pilon(new Posicion(0, 0));
        Estructura puertoEstelar = new PuertoEstelar(new Posicion(0, 0));
        Piso moho = new Moho(new Posicion(3, 3));

        assertThrows(ConstruccionNoValida.class, () -> acceso.construible(moho));
        assertThrows(ConstruccionNoValida.class, () -> nexoMineral.construible(moho));
        assertThrows(ConstruccionNoValida.class, () -> asimilador.construible(moho));
        assertThrows(ConstruccionNoValida.class, () -> pilon.construible(moho));
        assertThrows(ConstruccionNoValida.class, () -> puertoEstelar.construible(moho));
    }

    @Test
    public void test02ElMohoNoPuedeExpandirseSobreUnaPosicionConEdificacion(){
        Pilon pilon = new Pilon(new Posicion(6, 6));
        pasarKTurnos(pilon, 5);

        PuertoEstelar puertoEstelar = new PuertoEstelar(new Posicion(6, 6));
        puertoEstelar.construible(pilon);
        pasarKTurnos(puertoEstelar, 10);

        Moho moho = new Moho(new Posicion(0, 0));
        assertThrows(PosicionOcupada.class, () -> moho.expandirSobre(puertoEstelar.getPosicion()));
    }

    @Test
    public void test03ElMohoSePuedeExpandirseSobreUnaPosicionNoOcupada(){
        Pilon pilon = new Pilon(new Posicion(6, 6));
        pasarKTurnos(pilon, 5);

        PuertoEstelar puertoEstelar = new PuertoEstelar(new Posicion(6, 6));
        puertoEstelar.construible(pilon);
        pasarKTurnos(puertoEstelar, 10);

        Moho moho = new Moho(new Posicion(0, 0));
        assertDoesNotThrow( () -> moho.expandirSobre(new Posicion(6,7)));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

}
