package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso10Test {
    //La idea es hacer un poco de danio, luego regenerar, luego daniar hasta el punto de casi estar destruida.
    //Si la vida no se regenerase correctamente, entonces la estructura estaria destruida y no seria operable.
    @Test
    public void test01DaniarUnaEstructuraZergDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral();
        pasarKTurnos(estructura, 12);

        estructura.daniar(100);

        pasarKTurnos(estructura, 10);

        estructura.daniar(1299);

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test02DaniarUnaEstructuraZergEnConstruccionDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral();

        estructura.daniar(100);

        pasarKTurnos(estructura, 10);

        estructura.daniar(1299);

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test03DestruirUnaEstructuraZergNoDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral();
        pasarKTurnos(estructura, 12);

        estructura.daniar(1300);

        assertThrows(EntidadDestruidaException.class, estructura::operable);

        estructura.pasarTurno();

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test04DestruirUnaEstructuraZergEnConstruccionNoDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral();

        estructura.daniar(1300);

        assertThrows(EntidadDestruidaException.class, estructura::operable);

        estructura.pasarTurno();

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

}
