package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso27Test {

    public ArrayList<Estructura> estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        return estructuras;
    }

    void atacarKVeces(Unidad unidad, Entidad entidad) {
        for (int i = 0; i < 16; i++) {
            unidad.atacar(entidad);
        }
    }

    @Test
    public void test01CreoUnMutaliscoPeroNoPuedeEvolucionarPorqueLeFaltanRecursos() {
        Reserva reservaGas = new Reserva();
        Reserva reservaMineral = new Reserva();

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());
        assertThrows(RecursoInsuficienteException.class, () -> mutalisco.evolucionarADevorador());
    }

    @Test
    public void test02CreoUnMutaliscoYLoEvolucionoAUnDevorador() {
        Reserva reservaGas = new Reserva();
        Reserva reservaMineral = new Reserva();
        reservaGas.agregarRecurso(1000);
        reservaMineral.agregarRecurso(1000);

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0), new Raza(), estructuraMockeadaParaTestear());

        assertDoesNotThrow(() -> mutalisco.evolucionarADevorador());
    }

    @Test
    public void test03UnDevoradorAtacaAUnaUnidadVoladoraHastaMatarla() {
        Unidad unidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Posicion(1, 1), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(otraUnidad, 10);

        atacarKVeces(unidad, otraUnidad);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test04UnDevoradorAtacaAUnaUnidadDeTierra() {
        Unidad unidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Dragon(new Posicion(1, 1), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test05UnDevoradorAtacaAUnEdificio() {
        Unidad unidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        Posicion posicion = new Posicion(1, 1);
        Estructura estructura = new Acceso(posicion, new Raza(), new Nada());
        pasarKTurnos(estructura, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    @Test
    public void test06UnDevoradorAtacaAUnaUnidadFueraDeRango() {
        Unidad unidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Posicion(7, 7), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));

    }

    @Test
    public void test07UnDevoradorEsAtacadoPeroEsInvisible() {
        Unidad unidad = new Devorador(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        Unidad otraUnidad = new Scout(new Posicion(1, 0), new Raza(), estructuraMockeadaParaTestear());
        pasarKTurnos(otraUnidad, 10);

        assertThrows(AtaqueNoValidoException.class, () -> otraUnidad.atacar(unidad));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}