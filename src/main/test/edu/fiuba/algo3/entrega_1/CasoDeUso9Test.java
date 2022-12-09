package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CasoDeUso9Test {

    @Test
    public void test01UnaEstructuraProtossSigueActivaSiSeDestruyeUnPilonPeroEstaEnCercaniaDeOtro() {
        Raza raza = new Raza();
        raza.recolectarGas(1000);
        raza.recolectarMineral(1000);

        Posicion unaPosicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(6, 6);

        unaPosicion.energizar();
        otraPosicion.energizar();

        Pilon unPilon = new Pilon(unaPosicion, raza, new Nada());
        Pilon otroPilon = new Pilon(otraPosicion, raza, new Nada());

        pasarKTurnos(unPilon, 5);
        pasarKTurnos(otroPilon, 5);

        ArrayList<Pilon> pilones = new ArrayList<>();
        pilones.add(unPilon);
        pilones.add(otroPilon);

        Posicion posicionConstruccion = new Posicion(3, 3);

        for (Pilon pilon : pilones) {
            posicionConstruccion.actualizarEstado(pilon);
        }

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        PuertoEstelar puertoEstelar = new PuertoEstelar(posicionConstruccion, raza, new Nada(), estructuras);
        pasarKTurnos(puertoEstelar, 10);

        assertDoesNotThrow(puertoEstelar::operable);

        pilones.remove(0);

        for (Pilon pilon : pilones) {
            posicionConstruccion.actualizarEstado(pilon);
        }

        assertDoesNotThrow(puertoEstelar::operable);
    }

    @Test
    public void test02UnaEstructuraProtossQuedaInactivaSiSeDestruyeUnPilonYNoEstaEnCercaniaDeOtro() {
        Raza raza = new Raza();
        raza.recolectarGas(1000);
        raza.recolectarMineral(1000);

        Posicion unaPosicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(7, 7);

        unaPosicion.energizar();
        otraPosicion.energizar();

        Pilon unPilon = new Pilon(unaPosicion, raza, new Nada());
        Pilon otroPilon = new Pilon(otraPosicion, raza, new Nada());

        pasarKTurnos(unPilon, 5);
        pasarKTurnos(otroPilon, 5);

        ArrayList<Pilon> pilones = new ArrayList<>();
        pilones.add(unPilon);
        pilones.add(otroPilon);

        Posicion posicionConstruccion = new Posicion(3, 3);

        for (Pilon pilon : pilones) {
            posicionConstruccion.actualizarEstado(pilon);
        }

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        PuertoEstelar puertoEstelar = new PuertoEstelar(posicionConstruccion, raza, new Nada(), estructuras);
        pasarKTurnos(puertoEstelar, 10);

        assertDoesNotThrow(puertoEstelar::operable);

        pilones.remove(0);

        for (Pilon pilon : pilones) {
            posicionConstruccion.actualizarEstado(pilon);
        }

        assertDoesNotThrow(puertoEstelar::operable);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
