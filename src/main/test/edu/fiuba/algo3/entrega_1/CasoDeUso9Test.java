package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;
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
        //Mockeo la raza para no depender de recursos.
        Protoss protoss = mock(Protoss.class);

        Area unaArea = new Area(0, 0);
        Area otraArea = new Area(6, 6);

        unaArea.energizar();
        otraArea.energizar();

        Pilon unPilon = new Pilon(unaArea, protoss);
        Pilon otroPilon = new Pilon(otraArea, protoss);

        pasarKTurnos(unPilon, 5);
        pasarKTurnos(otroPilon, 5);

        ArrayList<Piso> pilones = new ArrayList<>();
        pilones.add(unPilon);
        pilones.add(otroPilon);

        Area areaConstruccion = new Area(3, 3);
        Area otraAreaConstruccion = new Area(3, 3);

        areaConstruccion.actualizarEstado(pilones);
        otraAreaConstruccion.actualizarEstado(pilones);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        Acceso acceso = new Acceso(otraAreaConstruccion, protoss);
        PuertoEstelar puertoEstelar = new PuertoEstelar(areaConstruccion, protoss, estructuras);
        pasarKTurnos(acceso, 8);
        pasarKTurnos(puertoEstelar, 10);

        assertDoesNotThrow(puertoEstelar::operable);
        assertDoesNotThrow(acceso::operable);

        pilones.remove(0);

        areaConstruccion.actualizarEstado(pilones);
        otraAreaConstruccion.actualizarEstado(pilones);
        puertoEstelar.actualizarEstado();
        acceso.actualizarEstado();

        assertDoesNotThrow(puertoEstelar::operable);
        assertDoesNotThrow(acceso::operable);
    }

    @Test
    public void test02UnaEstructuraProtossQuedaInactivaSiSeDestruyeUnPilonYNoEstaEnCercaniaDeOtro() {
        //Mockeo la raza para no depender de recursos.
        Protoss protoss = mock(Protoss.class);

        Area unaArea = new Area(0, 0);
        Area otraArea = new Area(7, 7);

        unaArea.energizar();
        otraArea.energizar();

        Pilon unPilon = new Pilon(unaArea, protoss);
        Pilon otroPilon = new Pilon(otraArea, protoss);

        pasarKTurnos(unPilon, 5);
        pasarKTurnos(otroPilon, 5);

        ArrayList<Piso> pilones = new ArrayList<>();
        pilones.add(unPilon);
        pilones.add(otroPilon);

        Area areaConstruccion = new Area(3, 3);
        Area otraAreaConstruccion = new Area(3, 3);

        areaConstruccion.actualizarEstado(pilones);
        otraAreaConstruccion.actualizarEstado(pilones);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        Acceso acceso = new Acceso(otraAreaConstruccion, protoss);
        PuertoEstelar puertoEstelar = new PuertoEstelar(areaConstruccion, protoss, estructuras);
        pasarKTurnos(acceso, 8);
        pasarKTurnos(puertoEstelar, 10);

        assertDoesNotThrow(puertoEstelar::operable);
        assertDoesNotThrow(acceso::operable);

        pilones.remove(0);

        areaConstruccion.actualizarEstado(pilones);
        otraAreaConstruccion.actualizarEstado(pilones);
        puertoEstelar.actualizarEstado();
        acceso.actualizarEstado();

        assertThrows(EntidadNoOperativaException.class, puertoEstelar::operable);
        assertThrows(EntidadNoOperativaException.class, acceso::operable);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
