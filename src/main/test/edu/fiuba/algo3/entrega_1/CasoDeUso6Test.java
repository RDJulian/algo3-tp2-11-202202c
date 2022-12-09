package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso6Test {

    @Test
    public void test01ElMohoSeExpandeCadaDosTurnosYSePuedeConstruirEnElLuegoDeExpandirse() {
        Moho moho = new Moho(new Posicion(0, 0));
        Posicion posicion = new Posicion(6, 6);
        posicion.actualizarEstado(moho);

        Raza raza = new Raza();
        raza.recolectarMineral(1000);

        ConstructorEstructuras constructor = new ConstructorCriadero(new ArrayList<>(), raza);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, new Nada()));

        moho.pasarTurno();
        moho.pasarTurno();

        posicion.actualizarEstado(moho);

        assertDoesNotThrow(() -> constructor.construir(posicion, new Nada()));
    }
}
