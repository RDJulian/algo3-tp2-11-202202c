package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Posicion.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Posicion.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zerling;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso20Test {
    @Test
    public void test01UnaUnidadDeTierraSePuedeMoverPorUnAreaDeTierra() {
        Unidad unidad = new Zerling(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 12);
        Posicion posicion = new Posicion(0, 0);


        assertDoesNotThrow(() -> unidad.moverse(posicion));
    }

    @Test
    public void test02UnaUnidadDeTierraNoSePuedeMoverPorUnAreaEspacial() {
        Unidad unidad = new Zerling(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 12);
        Posicion posicion = new Posicion(0, 0, new AreaEspacial());

        assertThrows(MovimientoNoValidoException.class, () -> unidad.moverse(posicion));
    }

    @Test
    public void test03UnaUnidadDeAireSePuedeMoverPorUnAreaDeTierra() {
        Unidad unidad = new Scout(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 12);
        Posicion posicion = new Posicion(0, 0);

        assertDoesNotThrow(() -> unidad.moverse(posicion));
    }

    @Test
    public void test04UnaUnidadDeAireSePuedeMoverPorUnAreaEspacial() {
        Unidad unidad = new Scout(new Posicion(0, 0), new Raza());
        pasarKTurnos(unidad, 12);
        Posicion posicion = new Posicion(0, 0);

        assertDoesNotThrow(() -> unidad.moverse(posicion));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
