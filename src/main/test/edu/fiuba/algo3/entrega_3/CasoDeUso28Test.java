package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso28Test {

    void atacarKVeces(UnidadAtacante unidad, Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacar(entidad);
        }
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    @Test
    public void test01UnZealotMataADosUnidadesYPuedeSerAtacado() {
        UnidadAtacante unidad = new Zealot(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        UnidadAtacante unidad2 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad2, 10);

        UnidadAtacante unidad3 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad3, 10);

        UnidadAtacante unidad4 = new Hidralisco(new Posicion(1, 1), new Raza());
        pasarKTurnos(unidad4, 10);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);

        assertDoesNotThrow(() -> unidad4.atacar(unidad));
    }

    @Test
    public void test02UnZealotMataATresUnidadesSeVuelveInvisibleYNoPuedeSerAtacado() {
        UnidadAtacante unidad = new Zealot(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        UnidadAtacante unidad2 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad2, 10);

        UnidadAtacante unidad3 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad3, 10);

        UnidadAtacante unidad4 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad4, 10);

        UnidadAtacante unidad5 = new Hidralisco(new Posicion(1, 1), new Raza());
        pasarKTurnos(unidad5, 10);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, unidad4, 5);

        assertThrows(AtaqueNoValidoException.class, () -> unidad5.atacar(unidad));
    }

    @Test
    public void test03UnZealotMataATresUnidadesSeVuelveInvisibleYPuedeSerAtacado() {
        Zealot unidad = new Zealot(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        UnidadAtacante unidad2 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad2, 10);

        UnidadAtacante unidad3 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad3, 10);

        UnidadAtacante unidad4 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad4, 10);

        UnidadAtacante unidad5 = new Hidralisco(new Posicion(1, 1), new Raza());
        pasarKTurnos(unidad5, 10);

        AmoSupremo unidad6 = new AmoSupremo(new Posicion(1, 0), new Raza());
        pasarKTurnos(unidad6, 10);

        ArrayList<AmoSupremo> AmosSupremos = new ArrayList<>();
        AmosSupremos.add(unidad6);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, unidad4, 5);

        unidad.revisarInvisibilidad(AmosSupremos);

        assertDoesNotThrow(() -> unidad5.atacar(unidad));
    }

    @Test
    public void test04UnZealotMataAUnaUnidadYDestruyeUnaEstructuraYPuedeSerAtacado() {
        UnidadAtacante unidad = new Zealot(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        UnidadAtacante unidad2 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad2, 10);

        Estructura espiral = new ReservaDeReproduccion(new Posicion(0, 1), new Raza());
        pasarKTurnos(espiral, 12);

        UnidadAtacante unidad3 = new Hidralisco(new Posicion(1, 1), new Raza());
        pasarKTurnos(unidad3, 10);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, espiral, 125);

        assertDoesNotThrow(() -> unidad3.atacar(unidad));
    }

    @Test
    public void test05UnZealotMataADosUnidadedYDestruyeUnaEstructuraSeConvienrteEnInvisibleYNoPuedeSerAtacado() {
        Zealot unidad = new Zealot(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        UnidadAtacante unidad2 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad2, 10);

        UnidadAtacante unidad3 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad3, 10);

        Estructura espiral = new ReservaDeReproduccion(new Posicion(0, 1), new Raza());
        pasarKTurnos(espiral, 10);

        UnidadAtacante unidad4 = new Hidralisco(new Posicion(1, 1), new Raza());
        pasarKTurnos(unidad4, 10);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, espiral, 125);

        assertThrows(AtaqueNoValidoException.class, () -> unidad4.atacar(unidad));
    }

    @Test
    public void test06UnZealotMataADosUnidadesYUnaEstructuraSeVuelveInvisibleYPuedeSerAtacado() {
        Zealot unidad = new Zealot(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 10);

        UnidadAtacante unidad2 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad2, 10);

        UnidadAtacante unidad3 = new Zerling(new Posicion(0, 1), new Raza());
        pasarKTurnos(unidad3, 10);

        Estructura espiral = new ReservaDeReproduccion(new Posicion(0, 1), new Raza());
        pasarKTurnos(espiral, 10);

        UnidadAtacante unidad4 = new Hidralisco(new Posicion(1, 1), new Raza());
        pasarKTurnos(unidad4, 10);

        AmoSupremo unidad5 = new AmoSupremo(new Posicion(1, 0), new Raza());
        pasarKTurnos(unidad5, 10);

        ArrayList<AmoSupremo> AmosSupremos = new ArrayList<>();
        AmosSupremos.add(unidad5);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, espiral, 125);

        unidad.revisarInvisibilidad(AmosSupremos);

        assertDoesNotThrow(() -> unidad4.atacar(unidad));
    }
}
