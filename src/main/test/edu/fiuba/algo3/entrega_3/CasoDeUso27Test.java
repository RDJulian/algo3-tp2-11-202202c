package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso27Test {

    void atacarKVeces(Unidad unidad, Entidad entidad) {
        for (int i = 0; i < 16; i++) {
            unidad.atacar(entidad);
        }
    }

    @Test
    public void test01CreoUnMutaliscoPeroNoPuedeEvolucionarPorqueLeFaltanRecursos() {
        Reserva reservaGas = new Reserva();
        Reserva reservaMineral = new Reserva();

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0));
        assertThrows(RecursoInsuficienteException.class, () -> mutalisco.evolucionarADevorador(reservaMineral, reservaGas));
    }

    @Test
    public void test02CreoUnMutaliscoYLoEvolucionoAUnDevorador() {
        Reserva reservaGas = new Reserva();
        Reserva reservaMineral = new Reserva();
        reservaGas.agregarRecurso(1000);
        reservaMineral.agregarRecurso(1000);

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0));

        assertDoesNotThrow(() -> mutalisco.evolucionarADevorador(reservaMineral, reservaGas));
    }

    @Test
    public void test03UnDevoradorAtacaAUnaUnidadVoladoraHastaMatarla() {
        Unidad unidad = new Devorador(new Posicion(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Posicion(1, 1));
        pasarKTurnos(otraUnidad, 10);

        atacarKVeces(unidad, otraUnidad);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test04UnDevoradorAtacaAUnaUnidadDeTierra() {
        Unidad unidad = new Devorador(new Posicion(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Dragon(new Posicion(1, 1));
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test05UnDevoradorAtacaAUnEdificio() {
        Unidad unidad = new Devorador(new Posicion(0, 0));
        pasarKTurnos(unidad, 10);

        Posicion posicion = new Posicion(1, 1);
        Estructura estructura = new Acceso(posicion);
        pasarKTurnos(estructura, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    @Test
    public void test06UnDevoradorAtacaAUnaUnidadFueraDeRango() {
        Unidad unidad = new Devorador(new Posicion(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Posicion(7, 7));
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));

    }

    @Test
    public void test07UnDevoradorEsAtacadoPeroEsInvisible() {
        Unidad unidad = new Devorador(new Posicion(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Posicion(1, 0));
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> otraUnidad.atacar(unidad));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}