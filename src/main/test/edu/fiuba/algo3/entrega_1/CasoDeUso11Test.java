package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso11Test {
    @Test
    public void test01DaniarUnaEstructuraProtossDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new PuertoEstelar(posicion);
        pasarKTurnos(estructura, 12);

        estructura.daniar(100, 0, posicion, 1, new Guardian(posicion));
        //500 Escudo 600 Vida

        pasarKTurnos(estructura, 10);
        //600 E 600 V

        estructura.daniar(1199, 0, posicion, 1, new Guardian(posicion));

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test02DaniarUnaEstructuraProtossEnConstruccionDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new PuertoEstelar(posicion);

        estructura.daniar(100, 0, posicion, 1, new Guardian(posicion));
        //500 Escudo 600 Vida

        pasarKTurnos(estructura, 10);
        //600 E 600 V

        estructura.daniar(1199, 0, posicion, 1, new Guardian(posicion));

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test03DestruirUnaEstructuraProtossNoDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new PuertoEstelar(posicion);
        pasarKTurnos(estructura, 12);

        estructura.daniar(1200, 0, posicion, 1, new Guardian(posicion));

        assertThrows(EntidadDestruidaException.class, estructura::operable);

        pasarKTurnos(estructura, 20);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test04DestruirUnaEstructuraProtossEnConstruccionNoDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new PuertoEstelar(posicion);

        estructura.daniar(1200, 0, posicion, 1, new Guardian(posicion));

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
