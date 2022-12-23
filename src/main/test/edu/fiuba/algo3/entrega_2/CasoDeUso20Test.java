package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zerling;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoSobreRecursoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso20Test {
    @Test
    public void test01UnaUnidadDeTierraSePuedeMoverPorUnAreaDeTierra() {
        Unidad unidad = new Zerling(new Area(0, 0));
        pasarKTurnos(unidad, 12);
        Area area = new Area(new Coordenada(1, 1), new AreaTierra(), new RecursoNull());

        assertDoesNotThrow(() -> unidad.moverse(area));
    }

    @Test
    public void test02UnaUnidadDeTierraNoSePuedeMoverPorUnAreaEspacial() {
        Unidad unidad = new Zerling(new Area(0, 0));
        pasarKTurnos(unidad, 12);
        Area area = new Area(new Coordenada(1, 1), new AreaEspacial(), new RecursoNull());

        assertThrows(MovimientoNoValidoException.class, () -> unidad.moverse(area));
    }

    @Test
    public void test03UnaUnidadDeAireSePuedeMoverPorUnAreaDeTierra() {
        Unidad unidad = new Scout(new Area(0, 0));
        pasarKTurnos(unidad, 12);
        Area area = new Area(new Coordenada(1, 1), new AreaTierra(), new RecursoNull());

        assertDoesNotThrow(() -> unidad.moverse(area));
    }

    @Test
    public void test04UnaUnidadDeAireSePuedeMoverPorUnAreaEspacial() {
        Unidad unidad = new Scout(new Area(0, 0));
        pasarKTurnos(unidad, 12);
        Area area = new Area(new Coordenada(1, 1), new AreaEspacial(), new RecursoNull());

        assertDoesNotThrow(() -> unidad.moverse(area));
    }

    @Test
    public void test05UnaUnidadNoSePuedeMoverPorUnAreaDeTierraConRecurso() {
        Unidad unidad = new Scout(new Area(0, 0));
        pasarKTurnos(unidad, 12);
        Area area = new Area(new Coordenada(1, 1), new AreaTierra(), new GasVespeno());

        assertThrows(MovimientoSobreRecursoException.class, () -> unidad.moverse(area));
    }

    @Test
    public void test05UnaUnidadNoSePuedeMoverPorUnAreaEspacialConRecurso() {
        Unidad unidad = new Scout(new Area(0, 0));
        pasarKTurnos(unidad, 12);
        Area area = new Area(new Coordenada(1, 1), new AreaEspacial(), new Mineral());

        assertThrows(MovimientoSobreRecursoException.class, () -> unidad.moverse(area));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
