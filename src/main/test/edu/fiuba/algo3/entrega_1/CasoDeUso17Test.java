package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso17Test {
    @Test
    public void test01GuaridaNecesitaUnaReservaDeReproduccionParaPoderConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);

        //Se mockea el area porque no afecta en lo que se prueba.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        ConstructorEstructuras constructor = new ConstructorGuarida(zerg.getEstructuras(), zerg);
        ConstructorEstructuras constructorReserva = new ConstructorReservaDeReproduccion(zerg.getEstructuras(), zerg);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        Estructura estructura = constructorReserva.construir(area);
        pasarKTurnos(estructura, 100);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test02EspiralNecesitaUnaGuaridaParaPoderConstruirse() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(1000);
        zerg.recolectarGas(1000);

        //Se mockea el area porque no afecta en lo que se prueba.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        ConstructorEstructuras constructor = new ConstructorGuarida(zerg.getEstructuras(), zerg);
        ConstructorEstructuras constructorReserva = new ConstructorReservaDeReproduccion(zerg.getEstructuras(), zerg);
        ConstructorEstructuras constructorEspiral = new ConstructorEspiral(zerg.getEstructuras(), zerg);

        Estructura estructura = constructorReserva.construir(area);
        pasarKTurnos(estructura, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorEspiral.construir(area));

        Estructura otraEstructura = constructor.construir(area);
        pasarKTurnos(otraEstructura, 100);

        assertDoesNotThrow(() -> constructorEspiral.construir(area));
    }

    @Test
    public void test03PuertoEstelarNecesitaUnAccesoParaPoderConstruirse() {
        ArrayList<Estructura> estructuras = new ArrayList<>();
        Protoss protoss = mock(Protoss.class);

        //Se mockea el area porque no afecta en lo que se prueba.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruibleRecurso.class), any(ConstruiblePiso.class))).thenReturn(true);

        ConstructorEstructuras constructor = new ConstructorAcceso(estructuras, protoss);
        ConstructorEstructuras constructorPuertoEstelar = new ConstructorPuertoEstelar(estructuras, protoss);

        Estructura estructura = constructor.construir(area);
        pasarKTurnos(estructura, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorPuertoEstelar.construir(area));

        estructuras.add(estructura);

        assertDoesNotThrow(() -> constructorPuertoEstelar.construir(area));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
