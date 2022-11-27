package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso27Test {

    void atacarKVeces(Unidad unidad, Daniable entidad, int k) {
        for (int i = 0; i < k; i++) {
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
        Reserva reservaGas = new Reserva(1000);
        Reserva reservaMineral = new Reserva(1000);

        Mutalisco mutalisco = new Mutalisco(new Posicion(0, 0));

        assertDoesNotThrow(() -> mutalisco.evolucionarADevorador(reservaMineral, reservaGas));
    }

    @Test
    public void test03UnDevoradorAtacaAUnaUnidadVoladoraHastaMatarla(){
        Unidad unidad = new Devorador(new Posicion(0, 0));
        unidad.setEstado(new Operativa());

        Unidad otraUnidad = new Scout(new Posicion(1, 1));
        otraUnidad.setEstado(new Operativa());

        atacarKVeces(unidad, otraUnidad, 16);

        assertDoesNotThrow(() -> unidad.atacar(otraUnidad));
        assertThrows(EntidadDestruidaException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test04UnDevoradorAtacaAUnaUnidadDeTierra(){
        Unidad unidad = new Devorador(new Posicion(0, 0));
        unidad.setEstado(new Operativa());

        Unidad otraUnidad = new Dragon(new Posicion(1, 1));
        otraUnidad.setEstado(new Operativa());

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));
    }

    @Test
    public void test05UnDevoradorAtacaAUnEdificio(){
        Unidad unidad = new Devorador(new Posicion(0, 0));
        unidad.setEstado(new Operativa());

        Posicion posicion = new Posicion(1, 1);
        Estructura estructura = new Acceso(posicion);
        estructura.setEstado(new Operativa());

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(estructura));
    }

    @Test
    public void test06UnDevoradorAtacaAUnaUnidadFueraDeRango(){
        Unidad unidad = new Devorador(new Posicion(0, 0));
        unidad.setEstado(new Operativa());

        Unidad otraUnidad = new Scout(new Posicion(7, 7));
        otraUnidad.setEstado(new Operativa());

        assertThrows(AtaqueNoValidoException.class, () -> unidad.atacar(otraUnidad));

    }

    @Test
    public void test07UnDevoradorEsAtacadoPeroEsInvisible(){
        Unidad unidad = new Devorador(new Posicion(0, 0));
        unidad.setEstado(new Operativa());

        Unidad otraUnidad = new Scout(new Posicion(1, 0));
        otraUnidad.setEstado(new Operativa());
        assertThrows(AtaqueNoValidoException.class, () -> otraUnidad.atacar(unidad));

    }

}