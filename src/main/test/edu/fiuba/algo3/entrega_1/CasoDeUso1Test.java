package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso1Test {
    @Test
    public void test01CriaderoSeIniciaConTresLarvas() {
        Criadero estructura = new Criadero();
        pasarKTurnos(estructura, 4);
        usarKLarvas(estructura, 3);

        assertThrows(CriaderoSinLarvasException.class, estructura::usarLarva);
    }

    @Test
    public void test02CriaderoSeIniciaConTresLarvasYNoPuedeSuperarTres() {
        Criadero estructura = new Criadero();
        pasarKTurnos(estructura, 4);
        estructura.pasarTurno();
        usarKLarvas(estructura, 3);

        assertThrows(CriaderoSinLarvasException.class, estructura::usarLarva);
    }

    @Test
    public void test03CriaderoSeIniciaConTresLarvasSeUsanTresPasaElTurnoYSeGeneraUna() {
        Criadero estructura = new Criadero();
        pasarKTurnos(estructura, 4);
        usarKLarvas(estructura, 3);

        estructura.pasarTurno();
        estructura.usarLarva();

        assertThrows(CriaderoSinLarvasException.class, estructura::usarLarva);
    }

    @Test
    public void test04CriaderoSeIniciaConTresLarvasSeUsanTresPasanTurnosYSeGeneranDos() {
        Criadero estructura = new Criadero();
        pasarKTurnos(estructura, 4);
        usarKLarvas(estructura, 3);

        pasarKTurnos(estructura, 2);
        usarKLarvas(estructura, 2);

        assertThrows(CriaderoSinLarvasException.class, estructura::usarLarva);
    }

    @Test
    public void test05CriaderoSeIniciaConTresLarvasSeUsanTresPasanTurnosYSeGeneranTres() {
        Criadero estructura = new Criadero();
        pasarKTurnos(estructura, 4);
        usarKLarvas(estructura, 3);

        pasarKTurnos(estructura, 3);
        usarKLarvas(estructura, 3);

        assertThrows(CriaderoSinLarvasException.class, estructura::usarLarva);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

    public void usarKLarvas(Criadero estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.usarLarva();
        }
    }
}