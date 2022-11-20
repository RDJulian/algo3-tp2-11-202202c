package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2Test {

    @Test
    public void test01CriaderoNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Criadero(new Posicion(0, 0));
        pasarKTurnos(estructura, 3);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test02AccesoNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Acceso(new Posicion(0, 0));
        pasarKTurnos(estructura, 7);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test03AsimiladorNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Asimilador(new Posicion(0, 0), new GasVespeno(), new Reserva());
        pasarKTurnos(estructura, 5);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test04EspiralNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Espiral(new Posicion(0, 0));
        pasarKTurnos(estructura, 9);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test05ExtractorNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Extractor(new Posicion(0, 0), new GasVespeno(), new Reserva());
        pasarKTurnos(estructura, 5);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test06GuaridaNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Guarida(new Posicion(0, 0));
        pasarKTurnos(estructura, 11);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test07NexoMineralNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new NexoMineral(new Posicion(0, 0), new Mineral(), new Reserva());
        pasarKTurnos(estructura, 3);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test08PilonNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Pilon(new Posicion(0, 0));
        pasarKTurnos(estructura, 4);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test09PuertoEstelarNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new PuertoEstelar(new Posicion(0, 0));
        pasarKTurnos(estructura, 9);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test10ReservaDeReproduccionNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new ReservaDeReproduccion(new Posicion(0, 0));
        pasarKTurnos(estructura, 11);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
