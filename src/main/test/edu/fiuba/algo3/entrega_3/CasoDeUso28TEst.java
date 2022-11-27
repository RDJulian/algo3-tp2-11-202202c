package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso28TEst {
    @Test
    public void test01CreoUnZealotInvisibleYNoPuedeSerAtacado() {
        Unidad unidad = new Zealot(new Posicion(0,0));
        unidad.setEstado(new Operativa());

        Unidad otraUnidad = new Hidralisco(new Posicion(1, 1));
        otraUnidad.setEstado(new Operativa());

        assertThrows(AtaqueNoValidoException.class, () -> otraUnidad.atacar(unidad));
    }

    @Test
    public void test02CreoUnZealotInvisibleYPuedeSerAtacadoPorqueEstaEnRangoDeDeteccionDeUnAmoSupremo(){
        Unidad unidad = new Zealot(new Posicion(0,0));
        unidad.setEstado(new Operativa());

        Unidad otraUnidad = new Hidralisco(new Posicion(1, 1));
        otraUnidad.setEstado(new Operativa());

        Unidad terceraUnidad = new AmoSupremo(new Posicion(1,0));
        terceraUnidad.setEstado(new Operativa());

        assertDoesNotThrow(() -> otraUnidad.atacar(unidad));
    }
}
