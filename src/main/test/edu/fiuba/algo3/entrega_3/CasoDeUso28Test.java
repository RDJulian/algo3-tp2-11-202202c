package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Area.Area;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso28Test {

    @Test
    public void test01UnZealotMataADosUnidadesYPuedeSerAtacado() {
        Unidad unidad = new Zealot(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad unidad2 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad2, 10);

        Unidad unidad3 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad3, 10);

        Unidad unidad4 = new Hidralisco(new Area(1, 1));
        pasarKTurnos(unidad4, 10);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);

        assertDoesNotThrow(() -> unidad4.atacar(unidad));
    }

    @Test
    public void test02UnZealotMataATresUnidadesSeVuelveInvisibleYNoPuedeSerAtacado() {
        Unidad unidad = new Zealot(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad unidad2 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad2, 10);

        Unidad unidad3 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad3, 10);

        Unidad unidad4 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad4, 10);

        Unidad unidad5 = new Hidralisco(new Area(1, 1));
        pasarKTurnos(unidad5, 10);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, unidad4, 5);

        assertThrows(AtaqueNoValidoException.class, () -> unidad5.atacar(unidad));
    }

    @Test
    public void test03UnZealotMataATresUnidadesSeVuelveInvisibleYPuedeSerAtacado() {
        Zealot unidad = new Zealot(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad unidad2 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad2, 10);

        Unidad unidad3 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad3, 10);

        Unidad unidad4 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad4, 10);

        Unidad unidad5 = new Hidralisco(new Area(1, 1));
        pasarKTurnos(unidad5, 10);

        AmoSupremo unidad6 = new AmoSupremo(new Area(1, 0));
        pasarKTurnos(unidad6, 10);

        ArrayList<RevelaEntidades> amosSupremos = new ArrayList<>();
        amosSupremos.add(unidad6);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, unidad4, 5);

        unidad.actualizarEstado(amosSupremos);

        assertDoesNotThrow(() -> unidad5.atacar(unidad));
    }

    @Test
    public void test04UnZealotMataAUnaUnidadYDestruyeUnaEstructuraYPuedeSerAtacado() {
        Unidad unidad = new Zealot(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad unidad2 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad2, 10);

        Estructura espiral = new ReservaDeReproduccion(new Area(0, 1));
        pasarKTurnos(espiral, 12);

        Unidad unidad3 = new Hidralisco(new Area(1, 1));
        pasarKTurnos(unidad3, 10);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, espiral, 125);

        assertDoesNotThrow(() -> unidad3.atacar(unidad));
    }

    @Test
    public void test05UnZealotMataADosUnidadedYDestruyeUnaEstructuraSeConvienrteEnInvisibleYNoPuedeSerAtacado() {
        Zealot unidad = new Zealot(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad unidad2 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad2, 10);

        Unidad unidad3 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad3, 10);

        Estructura espiral = new ReservaDeReproduccion(new Area(0, 1));
        pasarKTurnos(espiral, 10);

        Unidad unidad4 = new Hidralisco(new Area(1, 1));
        pasarKTurnos(unidad4, 10);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, espiral, 125);

        assertThrows(AtaqueNoValidoException.class, () -> unidad4.atacar(unidad));
    }

    @Test
    public void test06UnZealotMataADosUnidadesYUnaEstructuraSeVuelveInvisibleYPuedeSerAtacado() {
        Zealot unidad = new Zealot(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad unidad2 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad2, 10);

        Unidad unidad3 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad3, 10);

        Estructura espiral = new ReservaDeReproduccion(new Area(0, 1));
        pasarKTurnos(espiral, 10);

        Unidad unidad4 = new Hidralisco(new Area(1, 1));
        pasarKTurnos(unidad4, 10);

        AmoSupremo unidad5 = new AmoSupremo(new Area(1, 0));
        pasarKTurnos(unidad5, 10);

        ArrayList<RevelaEntidades> amosSupremos = new ArrayList<>();
        amosSupremos.add(unidad5);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, espiral, 125);

        unidad.actualizarEstado(amosSupremos);

        assertDoesNotThrow(() -> unidad4.atacar(unidad));
    }

    @Test
    public void test07UnZealotMataATresUnidadesSeVuelveInvisibleYPuedeSerAtacadoLuegoSeMueveYEsInvisible() {
        Zealot unidad = new Zealot(new Area(0, 0));
        pasarKTurnos(unidad, 10);

        Unidad unidad2 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad2, 10);

        Unidad unidad3 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad3, 10);

        Unidad unidad4 = new Zerling(new Area(0, 1));
        pasarKTurnos(unidad4, 10);

        Unidad unidad5 = new Hidralisco(new Area(1, 1));
        pasarKTurnos(unidad5, 10);

        AmoSupremo unidad6 = new AmoSupremo(new Area(1, 0));
        pasarKTurnos(unidad6, 10);

        ArrayList<RevelaEntidades> amosSupremos = new ArrayList<>();
        amosSupremos.add(unidad6);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, unidad4, 5);

        unidad.actualizarEstado(amosSupremos);

        assertDoesNotThrow(() -> unidad5.atacar(unidad));
        unidad5.pasarTurno();

        unidad.moverse(new Area(10, 10));
        unidad.actualizarEstado(amosSupremos);

        assertThrows(AtaqueNoValidoException.class, () -> unidad5.atacar(unidad));
    }

    void atacarKVeces(Unidad unidad, Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacar(entidad);
            unidad.pasarTurno();
        }
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
