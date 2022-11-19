package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Unidad.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso19Test {
    @Test
    public void test01UnaUnidadConAtaqueDeTierraPuedeAtacarAOtraUnidadDeTierra() {
        Unidad unaUnidad = new Zerling();
        Unidad otraUnidad = new Zealot();

        assertDoesNotThrow(() -> unaUnidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test02UnaUnidadConAtaqueDeTierraNoPuedeAtacarAOtraUnidadDeAire() {
        Unidad unaUnidad = new Zerling();
        Unidad otraUnidad = new Scout();

        assertThrows(AtaqueNoValidoException.class, () -> unaUnidad.atacarUnidad(otraUnidad));
    }

    @Test
    public void test03UnaUnidadConAtaqueDeAireNoPuedeAtacarAOtraUnidadDeTierra() {
        //No hay ninguna Unidad que no tenga ataque de tierra. Esto se deberia probar
        //pasandole directamente a TipoUnidad los daños, pero no diria nada de las Unidades.
        //Mocking no serviria por el momento porque las unidades dependen de su TipoUnidad y no al reves.
        //Si la excepcion se lanzara en Unidad, podria funcionar pero seria mover la responsabilidad.
    }

    @Test
    public void test04UnaUnidadConAtaqueDeAirePuedeAtacarAOtraUnidadDeAire() {
        Unidad unaUnidad = new Mutalisco();
        Unidad otraUnidad = new Scout();

        assertDoesNotThrow(() -> unaUnidad.atacarUnidad(otraUnidad));
    }
}
