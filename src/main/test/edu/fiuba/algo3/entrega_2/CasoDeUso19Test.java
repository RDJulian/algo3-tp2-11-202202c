package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso19Test {
    @Test
    public void test01UnaUnidadConAtaqueDeTierraPuedeAtacarAOtraUnidadDeTierra() {
        Unidad unaUnidad = new Zerling(new Posicion(0, 0), new Raza());
        pasarKTurnos(unaUnidad, 12);
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza());

        assertDoesNotThrow(() -> unaUnidad.atacar(otraUnidad));
    }

    @Test
    public void test02UnaUnidadConSoloAtaqueDeTierraNoPuedeAtacarAOtraUnidadDeAire() {
        Unidad unaUnidad = new Zerling(new Posicion(0, 0), new Raza());
        pasarKTurnos(unaUnidad, 12);
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza());

        assertThrows(AtaqueNoValidoException.class, () -> unaUnidad.atacar(otraUnidad));
    }

    @Test
    public void test03UnaUnidadConAtaqueDeAirePuedeAtacarAOtraUnidadDeAire() {
        Unidad unaUnidad = new Mutalisco(new Posicion(0, 0), new Raza());
        pasarKTurnos(unaUnidad, 12);
        Unidad otraUnidad = new Scout(new Posicion(0, 0), new Raza());

        assertDoesNotThrow(() -> unaUnidad.atacar(otraUnidad));
    }

    @Test
    public void test04UnaUnidadConSoloAtaqueDeAireNoPuedeAtacarAOtraUnidadDeTierra() {
        Unidad unaUnidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unaUnidad, 12);
        Unidad otraUnidad = new Zealot(new Posicion(0, 0), new Raza());

        assertThrows(AtaqueNoValidoException.class, () -> unaUnidad.atacar(otraUnidad));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
