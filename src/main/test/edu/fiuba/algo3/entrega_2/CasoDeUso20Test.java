package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zerling;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso20Test {
    @Test
    public void test01UnaUnidadDeTierraSePuedeMoverPorUnAreaDeTierra() {
        Unidad unidad = new Zerling(new Posicion(0, 0));
        pasarKTurnos(unidad, 12);
        AreaTierra area = new AreaTierra(new Posicion(0, 0));


        assertDoesNotThrow(() -> unidad.moverse(area));
    }

    @Test
    public void test02UnaUnidadDeTierraNoSePuedeMoverPorUnAreaEspacial() {
        Unidad unidad = new Zerling(new Posicion(0, 0));
        pasarKTurnos(unidad, 12);
        AreaEspacial area = new AreaEspacial(new Posicion(0, 0));

        assertThrows(MovimientoNoValidoException.class, () -> unidad.moverse(area));
    }

    @Test
    public void test03UnaUnidadDeAireSePuedeMoverPorUnAreaDeTierra() {
        Unidad unidad = new Scout(new Posicion(0, 0));
        pasarKTurnos(unidad, 12);
        AreaTierra area = new AreaTierra(new Posicion(0, 0));

        assertDoesNotThrow(() -> unidad.moverse(area));
    }

    @Test
    public void test04UnaUnidadDeAireSePuedeMoverPorUnAreaEspacial() {
        Unidad unidad = new Scout(new Posicion(0, 0));
        pasarKTurnos(unidad, 12);
        AreaEspacial area = new AreaEspacial(new Posicion(0, 0));

        assertDoesNotThrow(() -> unidad.moverse(area));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
