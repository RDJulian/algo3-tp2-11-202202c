package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso19Test {
    @Test
    public void test01UnaUnidadConAtaqueDeTierraPuedeAtacarAOtraUnidadDeTierra() {
        Unidad unaUnidad = new Zerling(new Posicion(0, 0));
        unaUnidad.setEstado(new Operativa());
        Unidad otraUnidad = new Zealot(new Posicion(0, 0));

        assertDoesNotThrow(() -> unaUnidad.atacar(otraUnidad));
    }

    @Test
    public void test02UnaUnidadConAtaqueDeTierraNoPuedeAtacarAOtraUnidadDeAire() {
        Unidad unaUnidad = new Zerling(new Posicion(0, 0));
        unaUnidad.setEstado(new Operativa());
        Unidad otraUnidad = new Scout(new Posicion(0, 0));

        assertThrows(AtaqueNoValidoException.class, () -> unaUnidad.atacar(otraUnidad));
    }

    //No hay ninguna Unidad que no tenga ataque de tierra. Esto se deberia probar
    //pasandole directamente a TipoUnidad los daños, pero no diria nada de las Unidades.
    //Mocking no serviria por el momento porque las unidades dependen de su TipoUnidad y no al reves.
    //Si la excepcion se lanzara en Unidad, podria funcionar pero seria mover la responsabilidad.

    @Test
    public void test03UnaUnidadConAtaqueDeAirePuedeAtacarAOtraUnidadDeAire() {
        Unidad unaUnidad = new Mutalisco(new Posicion(0, 0));
        unaUnidad.setEstado(new Operativa());
        Unidad otraUnidad = new Scout(new Posicion(0, 0));

        assertDoesNotThrow(() -> unaUnidad.atacar(otraUnidad));
    }
}
