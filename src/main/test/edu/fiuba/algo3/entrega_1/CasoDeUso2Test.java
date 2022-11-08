package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Exceptions.EstructuraNoOperativaException;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2Test {

    @Test
    public void test01CriaderoNoEstaOperativoMientrasSeEncuentraEnConstruccion(){
        Criadero criadero = new Criadero();
        pasarKTurnos(criadero, 3);
        assertThrows(EstructuraNoOperativaException.class, () -> {
            criadero.engendrarZangano();
        });
    }

    @Test
    public void test02CriaderoSeTerminaDeConstruirYEstaOperativoDespuesDePasarLosTurnosCorrespondientes(){
        Criadero criadero = new Criadero();
        pasarKTurnos(criadero, 4);
        criadero.engendrarZangano();
        assertEquals(criadero.getLarvas(), 2);
    }
/*
    @Test
    public void test03ExtractorNoEstaOperativoMientrasSeEncuentraEnConstruccion(){
        Extractor extractor = new Extractor();
        pasarKTurnos(criadero, 3);
        assertThrows(EstructuraNoOperativaException.class, () -> {
            criadero.engendrarZangano();
        });
    }

    @Test
    public void test02CriaderoSeTerminaDeConstruirYEstaOperativoDespuesDePasarLosTurnosCorrespondientes(){
        Criadero criadero = new Criadero();
        pasarKTurnos(criadero, 4);
        criadero.engendrarZangano();
        assertEquals(criadero.getLarvas(), 2);
    }
*/
    //COMPLETAR CON TODOS LOS EDIFICIOS
    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
