package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso19Test {
    @Test
    public void test01UnaUnidadConAtaqueDeTierraPuedeAtacarAOtraUnidadDeTierra() {
        Unidad unaUnidad = new Zerling(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unaUnidad, 12);
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());

        assertDoesNotThrow(() -> unaUnidad.atacar(otraUnidad));
    }

    @Test
    public void test02UnaUnidadConSoloAtaqueDeTierraNoPuedeAtacarAOtraUnidadDeAire() {
        Unidad unaUnidad = new Zerling(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unaUnidad, 12);
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());

        assertThrows(AtaqueNoValidoException.class, () -> unaUnidad.atacar(otraUnidad));
    }

    @Test
    public void test03UnaUnidadConAtaqueDeAirePuedeAtacarAOtraUnidadDeAire() {
        Unidad unaUnidad = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(unaUnidad, 12);
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());

        assertDoesNotThrow(() -> unaUnidad.atacar(otraUnidad));
    }

    @Test
    public void test04UnaUnidadConSoloAtaqueDeAireNoPuedeAtacarAOtraUnidadDeTierra() {
        Unidad unaUnidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unaUnidad, 12);
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());

        assertThrows(AtaqueNoValidoException.class, () -> unaUnidad.atacar(otraUnidad));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    public ArrayList<Estructura> estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        return estructuras;
    }
}
