package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso1Test {

    @Test
    public void test01CriaderoRecienCreadoTiene3Larvas() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        pasarKTurnos(criadero, 4);
        criadero.getLarvas();
        assertEquals(criadero.getLarvas(), 3);
    }

    @Test
    public void test02CriaderoConsumeUnaLarvaParaEngendrarUnZangano() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        pasarKTurnos(criadero, 4);
        criadero.engendrarZangano();
        assertEquals(criadero.getLarvas(), 2);
    }

    @Test
    public void test03CriaderoRegeneraUnaLarvaDespuesDePasarUnTurno() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        pasarKTurnos(criadero, 4);
        criadero.engendrarZangano();
        criadero.pasarTurno();
        assertEquals(criadero.getLarvas(), 3);
    }

    @Test
    public void test04CriaderoConsumeDosLarvasParaEngendrarZanganos() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        pasarKTurnos(criadero, 4);
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        assertEquals(criadero.getLarvas(), 1);
    }

    @Test
    public void test05CriaderoRegeneraDosLarvasDespuesDePasarDosTurnos() {
        Criadero criadero = new Criadero(new Posicion(0, 0));
        pasarKTurnos(criadero, 4);
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        pasarKTurnos(criadero, 2);
        assertEquals(criadero.getLarvas(), 2);
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
