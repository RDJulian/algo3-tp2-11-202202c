package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso23Test {
    //Se prueban dos cosas: los rangos de ataque y el movimiento de las unidades.
    @Test
    public void test01UnaUnidadNoPuedeAtacarAOtraSiEstaFueraDelRangoLuegoSeMueveYLaPuedeAtacar() {
        Area area = new AreaTierra(new Posicion(10, 10));
        Unidad guardian = new Guardian(new Posicion(0, 0));
        pasarKTurnos(guardian, 12);
        Unidad dragon = new Dragon(new Posicion(11, 11));

        assertThrows(AtaqueNoValidoException.class, () -> guardian.atacar(dragon));

        guardian.moverse(area);

        atacarKVeces(guardian, dragon, 7);

        assertDoesNotThrow(() -> guardian.atacar(dragon));
        assertThrows(EntidadDestruidaException.class, () -> guardian.atacar(dragon));
    }

    @Test
    public void test02UnaUnidadNoPuedeAtacarAUnaEstructuraSiEstaFueraDelRangoLuegoSeMueveYLaPuedeAtacar() {
        Area area = new AreaTierra(new Posicion(10, 10));
        Unidad guardian = new Guardian(new Posicion(0, 0));
        pasarKTurnos(guardian, 12);
        Estructura estructura = new Pilon(new Posicion(11, 11));

        assertThrows(AtaqueNoValidoException.class, () -> guardian.atacar(estructura));

        guardian.moverse(area);

        atacarKVeces(guardian, estructura, 23);

        assertDoesNotThrow(() -> guardian.atacar(estructura));
        assertThrows(EntidadDestruidaException.class, () -> guardian.atacar(estructura));
    }

    void atacarKVeces(Unidad unidad, Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacar(entidad);
        }
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
