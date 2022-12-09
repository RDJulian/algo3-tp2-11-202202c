package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso3Test {
    @Test
    public void test01EstructuraNoSePuedeConstruirSobreRecursoSiNoEsUnaDeLasEstructurasCorrectas() {
        Raza raza = new Raza();

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorAcceso(estructuras, raza));
        constructores.add(new ConstructorCriadero(estructuras, raza));
        constructores.add(new ConstructorEspiral(estructuras, raza));
        constructores.add(new ConstructorGuarida(estructuras, raza));
        constructores.add(new ConstructorPilon(estructuras, raza));
        constructores.add(new ConstructorPuertoEstelar(estructuras, raza));
        constructores.add(new ConstructorReservaDeReproduccion(estructuras, raza));

        //Se mockea la posicion para no depender del tipo de piso.
        Posicion posicion = mock(Posicion.class);
        when(posicion.construible(any(ConstruiblePiso.class))).thenReturn(true);

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

        //Se mockea la posicion para no depender del tipo de piso.
        Posicion posicion = mock(Posicion.class);
        when(posicion.construible(any(ConstruiblePiso.class))).thenReturn(true);

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

        //Se mockea la posicion para no depender del tipo de piso.
        Posicion posicion = mock(Posicion.class);
        when(posicion.construible(any(ConstruiblePiso.class))).thenReturn(true);

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

        //Se mockea la posicion para no depender del tipo de piso.
        Posicion posicion = mock(Posicion.class);
        when(posicion.construible(any(ConstruiblePiso.class))).thenReturn(true);
        
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
