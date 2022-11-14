package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Extractor;
import edu.fiuba.algo3.modelo.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {

    @Test
    public void test01EstructuraNoSePuedeConstruirSobreElGasVespeno() {
        Estructura estructura = new Criadero();
        Recurso recurso = new GasVespeno();
        assertThrows(ConstruccionNoValida.class, () -> estructura.construible(recurso));
    }

    @Test
    public void test02ExtractorSePuedeConstruirSobreElGasVespeno() {
        Estructura estructura = new Extractor();
        Recurso recurso = new GasVespeno(new Posicion(0, 0));
        assertDoesNotThrow(() -> estructura.construible(recurso));
    }

    @Test
    public void test03AsimiladorSePuedeConstruirSobreElGasVespeno() {
        Estructura estructura = new Asimilador();
        Recurso recurso = new GasVespeno(new Posicion(0, 0));
        assertDoesNotThrow(() -> estructura.construible(recurso));
    }
}
