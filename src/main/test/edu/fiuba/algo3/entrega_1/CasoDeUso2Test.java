package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2Test {

    @Test
    public void test01CriaderoNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Criadero(new Posicion(0, 0), new Raza());
        pasarKTurnos(estructura, 3);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test02AccesoNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Acceso(new Posicion(0, 0), new Raza());
        pasarKTurnos(estructura, 7);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test03AsimiladorNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new Asimilador(posicion, new GasVespeno(posicion), new Raza());
        pasarKTurnos(estructura, 5);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test04EspiralNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Espiral(new Posicion(0, 0), new Raza());
        pasarKTurnos(estructura, 9);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test05ExtractorNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new Extractor(posicion, new GasVespeno(posicion), new Raza());
        pasarKTurnos(estructura, 5);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test06GuaridaNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Guarida(new Posicion(0, 0), new Raza());
        pasarKTurnos(estructura, 11);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test07NexoMineralNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Posicion posicion = new Posicion(0, 0);
        Estructura estructura = new NexoMineral(posicion, new Mineral(posicion), new Raza());
        pasarKTurnos(estructura, 3);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test08PilonNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new Pilon(new Posicion(0, 0), new Raza());
        pasarKTurnos(estructura, 4);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test09PuertoEstelarNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new PuertoEstelar(new Posicion(0, 0), new Raza());
        pasarKTurnos(estructura, 9);

        assertThrows(EntidadNoOperativaException.class, estructura::operable);

        estructura.pasarTurno();

        assertDoesNotThrow(estructura::operable);
    }

    @Test
    public void test10ReservaDeReproduccionNoEstaOperativoMientrasSeEncuentraEnConstruccion() {
        Estructura estructura = new ReservaDeReproduccion(new Posicion(0, 0), new Raza());
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
