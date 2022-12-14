package edu.fiuba.algo3.MovimientoTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zerling;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovimientoTest {
    @Test
    public void test01UnZanganoNoSePuedeMoverALaMismaPosicionOAUnAreaConLasMismasCoordenadas() {
        Area area1 = new Area(0, 0);
        Area area2 = new Area(1, 1);
        Zangano zangano = new Zangano(new Area(1, 1), new Zerg());
        zangano.pasarTurno();

        assertThrows(MovimientoNoValidoException.class, () -> zangano.moverse(area2));
        assertDoesNotThrow(() -> zangano.moverse(area1));
        assertThrows(MovimientoNoValidoException.class, () -> zangano.moverse(area1));
    }

    @Test
    public void test02UnZerlingNoSePuedeMoverALaMismaPosicionOAUnAreaConLasMismasCoordenadas() {
        Area area1 = new Area(0, 0);
        Area area2 = new Area(1, 1);
        Zerling zerling = new Zerling(new Area(1, 1));
        zerling.pasarTurno();
        zerling.pasarTurno();

        assertThrows(MovimientoNoValidoException.class, () -> zerling.moverse(area2));
        assertDoesNotThrow(() -> zerling.moverse(area1));
        assertThrows(MovimientoNoValidoException.class, () -> zerling.moverse(area1));
    }

    @Test
    public void test03UnaUnidadSoloSePuedeMoverAUnAreaEnUnRangoDeTres() {
        Area area1 = new Area(3, 3);
        Area area2 = new Area(4, 4);
        Zerling zerling = new Zerling(new Area(0, 0));
        zerling.pasarTurno();
        zerling.pasarTurno();

        assertThrows(MovimientoNoValidoException.class, () -> zerling.moverse(area2));
        assertDoesNotThrow(() -> zerling.moverse(area1));
    }

    @Test
    public void test04UnaUnidadSoloSePuedeMoverUnaVezPorTurno() {
        Area area1 = new Area(3, 3);
        Area area2 = new Area(2, 2);
        Zerling zerling = new Zerling(new Area(0, 0));
        zerling.pasarTurno();
        zerling.pasarTurno();

        assertDoesNotThrow(() -> zerling.moverse(area1));
        assertThrows(MovimientoNoValidoException.class, () -> zerling.moverse(area2));

        zerling.pasarTurno();
        assertDoesNotThrow(() -> zerling.moverse(area2));
    }
}