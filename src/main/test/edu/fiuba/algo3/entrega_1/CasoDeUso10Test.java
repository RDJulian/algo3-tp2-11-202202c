package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso10Test {
    //La idea es hacer un poco de danio, luego regenerar, luego daniar hasta el punto de casi estar destruida.
    //Si la vida no se regenerase correctamente, entonces la estructura estaria destruida y no seria operable.
    @Test
    public void test01DaniarUnaEstructuraZergDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        pasarKTurnos(estructura, 12);
        estructura.daniar(100, 0, new Posicion(0, 0), 1);

        pasarKTurnos(estructura, 10);

        estructura.daniar(1299, 0, new Posicion(0, 0), 1);
        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test02DaniarUnaEstructuraZergEnConstruccionDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        estructura.daniar(100, 0, new Posicion(0, 0), 1);
        pasarKTurnos(estructura, 10);

        estructura.daniar(1299, 0, new Posicion(0, 0), 1);
        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test03DestruirUnaEstructuraZergNoDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        pasarKTurnos(estructura, 12);
        estructura.daniar(1300, 0, new Posicion(0, 0), 1);

        assertThrows(EntidadDestruidaException.class, estructura::operable);

        pasarKTurnos(estructura, 20);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test04DestruirUnaEstructuraZergEnConstruccionNoDeberiaRegenerarSuVidaAlPasarTurnos() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        estructura.daniar(1300, 0, new Posicion(0, 0), 1);

        assertThrows(EntidadDestruidaException.class, estructura::operable);

        pasarKTurnos(estructura, 20);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

}
