package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {
    @Test
    public void test01EstructuraNoSePuedeConstruirSobreRecursoSiNoEsUnaDeLasEstructurasCorrectas() {
        Raza raza = new Raza();
        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorAcceso(new ArrayList<>(), raza));
        constructores.add(new ConstructorCriadero(new ArrayList<>(), raza));
        constructores.add(new ConstructorEspiral(new ArrayList<>(), raza));
        constructores.add(new ConstructorGuarida(new ArrayList<>(), raza));
        constructores.add(new ConstructorPilon(new ArrayList<>(), raza));
        constructores.add(new ConstructorPuertoEstelar(new ArrayList<>(), raza));
        constructores.add(new ConstructorReservaDeReproduccion(new ArrayList<>(), raza));

        Posicion posicion = new Posicion(0, 0);
        Recurso gasVespeno = new GasVespeno(posicion);
        Recurso mineral = new Mineral(posicion);

        raza.recolectarMineral(10000);
        raza.recolectarGas(10000);

        for (ConstructorEstructuras constructor : constructores) {
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, gasVespeno));
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, mineral));
        }
    }

    @Test
    public void test02AsimiladorSePuedeConstruirSobreElGasVespeno() {
        Raza raza = new Raza();
        ConstructorEstructuras constructor = new ConstructorAsimilador(new ArrayList<>(), raza);

        Posicion posicion = new Posicion(0, 0);
        Recurso gasVespeno = new GasVespeno(posicion);
        Recurso mineral = new Mineral(posicion);

        raza.recolectarMineral(1000);
        raza.recolectarGas(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion, gasVespeno));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, mineral));
    }

    @Test
    public void test03ExtractorSePuedeConstruirSobreElGasVespeno() {
        Raza raza = new Raza();
        ConstructorEstructuras constructor = new ConstructorExtractor(new ArrayList<>(), raza);

        Posicion posicion = new Posicion(0, 0);
        Recurso gasVespeno = new GasVespeno(posicion);
        Recurso mineral = new Mineral(posicion);

        raza.recolectarMineral(1000);
        raza.recolectarGas(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion, gasVespeno));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, mineral));
    }

    @Test
    public void test04NexoMineralSePuedeConstruirSobreMineral() {
        Raza raza = new Raza();
        ConstructorEstructuras constructor = new ConstructorNexoMineral(new ArrayList<>(), raza);

        Posicion posicion = new Posicion(0, 0);
        Recurso gasVespeno = new GasVespeno(posicion);
        Recurso mineral = new Mineral(posicion);

        raza.recolectarMineral(1000);
        raza.recolectarGas(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion, mineral));
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, gasVespeno));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
