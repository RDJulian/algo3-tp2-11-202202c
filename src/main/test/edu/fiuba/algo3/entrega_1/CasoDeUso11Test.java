package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.PuertoEstelar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11Test {
    @Test
    public void test01DaniarUnaEstructuraProtossDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Estructura estructura = new PuertoEstelar();
        estructura.setEstadoEnergetico(new Activo());
        pasarKTurnos(estructura, 10);
        estructura.daniar(135);

        assertEquals(estructura.getDefensa(), 465);

        pasarKTurnos(estructura, 13);

        assertEquals(estructura.getDefensa(), 595);

        estructura.pasarTurno();

        assertEquals(estructura.getDefensa(), 600);
    }

    @Test
    public void test02DaniarUnaEstructuraProtossEnConstruccionDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Estructura estructura = new PuertoEstelar();
        estructura.setEstadoEnergetico(new Activo());
        estructura.daniar(200);

        pasarKTurnos(estructura, 10);

        assertEquals(estructura.getDefensa(), 500);
    }

    @Test
    public void test03DestruirUnaEstructuraProtossNoDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Estructura estructura = new PuertoEstelar();
        pasarKTurnos(estructura, 10);
        estructura.daniar(1200);

        assertEquals(estructura.getDefensa(), 0);

        pasarKTurnos(estructura, 20);

        assertEquals(estructura.getDefensa(), 0);
    }

    @Test
    public void test04DestruirUnaEstructuraProtossEnConstruccionNoDeberiaRegenerarSuEscudoAlPasarTurnos() {
        Estructura estructura = new PuertoEstelar();
        estructura.daniar(1200);

        assertEquals(estructura.getDefensa(), 0);

        pasarKTurnos(estructura, 20);

        assertEquals(estructura.getDefensa(), 0);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
