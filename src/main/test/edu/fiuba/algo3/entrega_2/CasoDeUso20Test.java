package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zerling;
import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso20Test { //Plantear relacion Posicion/Area
    @Test
    public void test01UnaUnidadDeTierraSePuedeMoverPorUnAreaDeTierra() {
        Unidad unidad = new Zerling();
        unidad.setEstado(new Operativa());
        AreaTierra area = new AreaTierra();


        assertDoesNotThrow(() -> unidad.moverse(area));
    }

    @Test
    public void test02UnaUnidadDeTierraNoSePuedeMoverPorUnAreaEspacial() {
        Unidad unidad = new Zerling();
        unidad.setEstado(new Operativa());
        AreaEspacial area = new AreaEspacial();

        assertThrows(MovimientoNoValidoException.class, () -> unidad.moverse(area));
    }

    @Test
    public void test03UnaUnidadDeAireSePuedeMoverPorUnAreaDeTierra() {
        Unidad unidad = new Scout();
        unidad.setEstado(new Operativa());
        AreaTierra area = new AreaTierra();

        assertDoesNotThrow(() -> unidad.moverse(area));
    }

    @Test
    public void test04UnaUnidadDeAireSePuedeMoverPorUnAreaEspacial() {
        Unidad unidad = new Scout();
        unidad.setEstado(new Operativa());
        AreaEspacial area = new AreaEspacial();

        assertDoesNotThrow(() -> unidad.moverse(area));
    }
}
