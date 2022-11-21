package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso11Test {
    @Test
    public void test01DaniarUnaEstructuraProtossDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Rango rango = new Rango(new Posicion(0, 0), 1);
        Estructura estructura = new PuertoEstelar(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.daniar(100, 0, rango);
        //500 Escudo 600 Vida

        pasarKTurnos(estructura, 10);

        //600 E 600 V

        estructura.daniar(1199, 0, rango);
        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test02DaniarUnaEstructuraProtossEnConstruccionDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Rango rango = new Rango(new Posicion(0, 0), 1);
        Estructura estructura = new PuertoEstelar(new Posicion(0, 0));
        estructura.daniar(100, 0, rango);
        //500 Escudo 600 Vida

        pasarKTurnos(estructura, 10);

        //600 E 600 V

        estructura.daniar(1199, 0, rango);
        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test03DestruirUnaEstructuraProtossNoDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Rango rango = new Rango(new Posicion(0, 0), 1);
        Estructura estructura = new PuertoEstelar(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.daniar(1200, 0, rango);

        assertThrows(EntidadDestruidaException.class, estructura::operable);

        pasarKTurnos(estructura, 20);

        assertThrows(EntidadDestruidaException.class, estructura::operable);
    }

    @Test
    public void test04DestruirUnaEstructuraProtossEnConstruccionNoDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Rango rango = new Rango(new Posicion(0, 0), 1);
        Estructura estructura = new PuertoEstelar(new Posicion(0, 0));
        estructura.daniar(1200, 0, rango);

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
