package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Posicion.Area.Area;
import edu.fiuba.algo3.modelo.Posicion.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso23Test {
    //Se prueban dos cosas: los rangos de ataque y el movimiento de las unidades.
    @Test
    public void test01UnaUnidadNoPuedeAtacarAOtraSiEstaFueraDelRangoLuegoSeMueveYLaPuedeAtacar() {
        Posicion posicion = new Posicion(10, 10);
        Unidad guardian = new Guardian(new Posicion(0, 0), new Raza());
        pasarKTurnos(guardian, 12);
        Unidad dragon = new Dragon(new Posicion(11, 11), new Raza(), estructuraMockeadaParaTestear());

        assertThrows(AtaqueNoValidoException.class, () -> guardian.atacar(dragon));

        guardian.moverse(posicion);

        atacarKVeces(guardian, dragon, 7);

        assertDoesNotThrow(() -> guardian.atacar(dragon));
        assertThrows(EntidadDestruidaException.class, () -> guardian.atacar(dragon));
    }

    @Test
    public void test02UnaUnidadNoPuedeAtacarAUnaEstructuraSiEstaFueraDelRangoLuegoSeMueveYLaPuedeAtacar() {
        Posicion posicion = new Posicion(10, 10);
        Unidad guardian = new Guardian(new Posicion(0, 0), new Raza());
        pasarKTurnos(guardian, 12);
        Estructura estructura = new Pilon(new Posicion(11, 11), new Raza(), new Nada());

        assertThrows(AtaqueNoValidoException.class, () -> guardian.atacar(estructura));

        guardian.moverse(posicion);

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

    public ArrayList<Estructura> estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        return estructuras;
    }
}
