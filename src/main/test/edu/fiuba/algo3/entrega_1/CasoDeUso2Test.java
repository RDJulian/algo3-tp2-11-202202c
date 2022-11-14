package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraNoOperativa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2Test {

    @Test
    public void test01CriaderoNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Criadero();
        pasarKTurnos(estructura, 3);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test02AccesoNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Acceso();
        estructura.setEstadoEnergetico(new Activo());
        pasarKTurnos(estructura, 7);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test03AsimiladorNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Asimilador();
        pasarKTurnos(estructura, 5);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test04EspiralNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Espiral();
        pasarKTurnos(estructura, 9);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test05ExtractorNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Extractor();
        pasarKTurnos(estructura, 5);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test06GuaridaNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Guarida();
        pasarKTurnos(estructura, 11);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test07NexoMineralNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new NexoMineral();
        pasarKTurnos(estructura, 3);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test08PilonNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Pilon();
        pasarKTurnos(estructura, 4);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test09PuertoEstelarNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new PuertoEstelar();
        estructura.setEstadoEnergetico(new Activo());
        pasarKTurnos(estructura, 9);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    @Test
    public void test10ReservaDeReproduccionNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new ReservaDeReproduccion();
        pasarKTurnos(estructura, 11);

        assertThrows(EstructuraNoOperativa.class, estructura::operar);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operar);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
