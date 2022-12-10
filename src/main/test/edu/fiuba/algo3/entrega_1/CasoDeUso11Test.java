package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso11Test {
    @Test
    public void test01DaniarUnaEstructuraProtossDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Estructura estructura = new PuertoEstelar();
        pasarKTurnos(estructura, 12);

        estructura.daniar(100);
        //500 Escudo 600 Vida

        pasarKTurnos(estructura, 10);
        //600 E 600 V

        estructura.daniar(1199);

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test02DaniarUnaEstructuraProtossEnConstruccionDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Estructura estructura = new PuertoEstelar();

        estructura.daniar(100);
        //500 Escudo 600 Vida

        pasarKTurnos(estructura, 10);
        //600 E 600 V

        estructura.daniar(1199);

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test03DestruirUnaEstructuraProtossNoDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Estructura estructura = new PuertoEstelar();
        pasarKTurnos(estructura, 12);

        estructura.daniar(1200);

        assertThrows(EntidadDestruidaException.class, estructura::operable);

        pasarKTurnos(estructura, 20);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test04DestruirUnaEstructuraProtossEnConstruccionNoDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Estructura estructura = new PuertoEstelar();

        estructura.daniar(1200);

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
