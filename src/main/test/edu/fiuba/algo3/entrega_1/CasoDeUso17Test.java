package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
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
        ArrayList<Estructura> estructuras = new ArrayList<>();
        Raza raza = mock(Raza.class);

        //Se mockea el area porque no afecta en lo que se prueba.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        ConstructorEstructuras constructor = new ConstructorGuarida(estructuras, raza);
        ConstructorEstructuras constructorReserva = new ConstructorReservaDeReproduccion(estructuras, raza);

        Estructura estructura = constructorReserva.construir(area);
        pasarKTurnos(estructura, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));

        estructuras.add(estructura);

        assertDoesNotThrow(() -> constructor.construir(area));
    }

    @Test
    public void test02EspiralNecesitaUnaGuaridaParaPoderConstruirse() {
        ArrayList<Estructura> estructuras = new ArrayList<>();
        Raza raza = mock(Raza.class);

        //Se mockea el area porque no afecta en lo que se prueba.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        ConstructorEstructuras constructor = new ConstructorGuarida(estructuras, raza);
        ConstructorEstructuras constructorReserva = new ConstructorReservaDeReproduccion(estructuras, raza);
        ConstructorEstructuras constructorEspiral = new ConstructorEspiral(estructuras, raza);

        Estructura estructura = constructorReserva.construir(area);
        pasarKTurnos(estructura, 100);
        estructuras.add(estructura);

        Estructura otraEstructura = constructor.construir(area);
        pasarKTurnos(otraEstructura, 100);

        assertThrows(ConstruccionNoValidaException.class, () -> constructorEspiral.construir(area));

        estructuras.add(otraEstructura);

        assertDoesNotThrow(() -> constructorEspiral.construir(area));
    }

    @Test
    public void test03PuertoEstelarNecesitaUnAccesoParaPoderConstruirse() {
        ArrayList<Estructura> estructuras = new ArrayList<>();
        Raza raza = mock(Raza.class);

        //Se mockea el area porque no afecta en lo que se prueba.
        Area area = mock(Area.class);
        when(area.construible(any(ConstruiblePiso.class))).thenReturn(true);
        when(area.construible(any(ConstruibleRecurso.class))).thenReturn(true);

        ConstructorEstructuras constructor = new ConstructorAcceso(estructuras, raza);
        ConstructorEstructuras constructorPuertoEstelar = new ConstructorPuertoEstelar(estructuras, raza);

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
