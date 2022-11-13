package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvas;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso1Test {

    @Test
    public void test01CriaderoSeIniciaConTresLarvas() {
        Estructura estructura = new Criadero(new Posicion(0, 0));
        pasarKTurnos(estructura, 4);
        operarKVeces(estructura, 3);

        assertThrows(CriaderoSinLarvas.class, estructura::operar);
    }

    @Test
    public void test02CriaderoSeIniciaConTresLarvasYNoPuedeSuperarTres() {
        Estructura estructura = new Criadero(new Posicion(0, 0));
        pasarKTurnos(estructura, 4);
        estructura.pasarTurno();
        operarKVeces(estructura, 3);

        assertThrows(CriaderoSinLarvas.class, estructura::operar);
    }

    @Test
    public void test03CriaderoSeIniciaConTresLarvasSeUsanTresPasaElTurnoYSeGeneraUna() {
        Estructura estructura = new Criadero(new Posicion(0, 0));
        pasarKTurnos(estructura, 4);
        operarKVeces(estructura, 3);

        estructura.pasarTurno();
        estructura.operar();

        assertThrows(CriaderoSinLarvas.class, estructura::operar);
    }

    @Test
    public void test04CriaderoSeIniciaConTresLarvasSeUsanTresPasanTurnosYSeGeneranDos() {
        Estructura estructura = new Criadero(new Posicion(0, 0));
        pasarKTurnos(estructura, 4);
        operarKVeces(estructura, 3);

        pasarKTurnos(estructura, 2);
        operarKVeces(estructura, 2);

        assertThrows(CriaderoSinLarvas.class, estructura::operar);
    }

    @Test
    public void test05CriaderoSeIniciaConTresLarvasSeUsanTresPasanTurnosYSeGeneranTres() {
        Estructura estructura = new Criadero(new Posicion(0, 0));
        pasarKTurnos(estructura, 4);
        operarKVeces(estructura, 3);

        pasarKTurnos(estructura, 3);
        operarKVeces(estructura, 3);

        assertThrows(CriaderoSinLarvas.class, estructura::operar);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

    public void operarKVeces(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.operar();
        }
    }

}
