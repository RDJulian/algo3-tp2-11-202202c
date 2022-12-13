package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CasoDeUso6Test {

    @Test
    public void test01ElMohoSeExpandeCadaDosTurnosYSePuedeConstruirEnElLuegoDeExpandirse() {
        Area areaMoho = new Area(0, 0);
        Moho moho = new Moho(areaMoho);

        Area area = new Area(6, 6);
        area.actualizarEstado(moho);

        //Mockeo la raza para no depender de recursos.
        Zerg zerg = mock(Zerg.class);

        ConstructorEstructuras constructor = new ConstructorCriadero(new ArrayList<>(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        moho.pasarTurno();
        moho.pasarTurno();

        area.actualizarEstado(moho);

        assertDoesNotThrow(() -> constructor.construir(area));
    }
}
