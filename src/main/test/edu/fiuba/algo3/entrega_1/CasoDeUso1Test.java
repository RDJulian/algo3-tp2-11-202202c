package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.Zangano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso1Test {

    @Test
    public void test01CriaderoRecienCreadoTiene3Larvas() {
        Criadero criadero = new Criadero();
        criadero.getLarvas();
        assertEquals(criadero.getLarvas(), 3);
    }

    @Test
    public void test02CriaderoConsumeUnaLarvaParaEngendrarUnZangano() {
        Criadero criadero = new Criadero();
        criadero.engendrarZangano();
        assertEquals(criadero.getLarvas(), 2);
    }

    @Test
    public void test03CriaderoRegeneraUnaLarvaDespuesDePasarUnTurno() {
        Criadero criadero = new Criadero();
        criadero.engendrarZangano();
        criadero.pasarTurno();
        assertEquals(criadero.getLarvas(), 3);
    }
    @Test
    public void test04CriaderoConsumeDosLarvasParaEngendrarZanganos() {
        Criadero criadero = new Criadero();
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        assertEquals(criadero.getLarvas(), 1);
    }

    @Test
    public void test05CriaderoRegeneraDosLarvasDespuesDePasarDosTurnos() {
        Criadero criadero = new Criadero();
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.pasarTurno();
        criadero.pasarTurno();
        assertEquals(criadero.getLarvas(), 2);
    }
}
