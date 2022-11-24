package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CasoDeUso9Test {

    @Test
    public void test01UnaEstructuraProtossSigueActivaSiSeDestruyeUnPilonPeroEstaEnCercaniaDeOtro() {
        Pilon unPilon = new Pilon(new Posicion(0, 0));
        Pilon otroPilon = new Pilon(new Posicion(6, 6));

        pasarKTurnos(unPilon, 5);
        pasarKTurnos(otroPilon, 5);

        Vector<Pilon> pilones = new Vector<>();
        pilones.add(unPilon);
        pilones.add(otroPilon);

        PuertoEstelar puertoEstelar = new PuertoEstelar(new Posicion(3, 3));
        pasarKTurnos(puertoEstelar, 10);

        puertoEstelar.actualizarEstado(pilones);
        assertDoesNotThrow(puertoEstelar::operable);

        pilones.remove(0);

        puertoEstelar.actualizarEstado(pilones);
        assertDoesNotThrow(puertoEstelar::operable);
    }

    @Test
    public void test02UnaEstructuraProtossQuedaInactivaSiSeDestruyeUnPilonYNoEstaEnCercaniaDeOtro() {
        Pilon unPilon = new Pilon(new Posicion(0, 0));
        Pilon otroPilon = new Pilon(new Posicion(7, 7));

        pasarKTurnos(unPilon, 5);
        pasarKTurnos(otroPilon, 5);

        Vector<Pilon> pilones = new Vector<>();
        pilones.add(unPilon);
        pilones.add(otroPilon);

        PuertoEstelar puertoEstelar = new PuertoEstelar(new Posicion(3, 3));
        pasarKTurnos(puertoEstelar, 10);

        puertoEstelar.actualizarEstado(pilones);
        assertDoesNotThrow(puertoEstelar::operable);

        pilones.remove(0);

        puertoEstelar.actualizarEstado(pilones);
        assertThrows(EntidadNoOperativaException.class, puertoEstelar::operable);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
