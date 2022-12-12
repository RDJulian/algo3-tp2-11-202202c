package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CasoDeUso13Test {
    @Test
    public void test01UnCriaderoSeConstruyeCreaMohoLuegoEsDestruidaPeroElMohoSigueEstando() {
        //Mockeo la raza para no depender de recursos.
        Raza raza = mock(Raza.class);

        Area area = new Area(0, 0);
        area.cubrirConMoho();

        ArrayList<Piso> pisos = new ArrayList<>();

        ConstructorEstructuras constructor = new ConstructorCriadero(new ArrayList<>(), raza, pisos);
        Estructura criadero = constructor.construir(area);

        Area areaConstruccion = new Area(-5, -5);
        areaConstruccion.actualizarEstado(pisos);

        criadero.daniar(600);

        assertThrows(EntidadDestruidaException.class, criadero::operable);

        assertDoesNotThrow(() -> constructor.construir(areaConstruccion));
    }
}
