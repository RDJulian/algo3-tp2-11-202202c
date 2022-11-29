package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso28Test {

    void atacarKVeces(Unidad unidad, Daniable entidad, int k) {
        for (int i = 0; i < k; i++) {
            unidad.atacar(entidad);
        }
    }

    @Test
    public void test01UnZealotMataADosUnidadesYPuedeSerAtacado(){
        Unidad unidad = new Zealot(new Posicion(0,0));
        unidad.setEstado(new Operativa());

        Unidad unidad2 = new Zerling(new Posicion(0,1));
        unidad2.setEstado(new Operativa());

        Unidad unidad3 = new Zerling(new Posicion(0,1));
        unidad3.setEstado(new Operativa());

        Unidad unidad4 = new Hidralisco(new Posicion(1, 1));
        unidad4.setEstado(new Operativa());

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);

        assertDoesNotThrow(() -> unidad4.atacar(unidad));
    }
    @Test
    public void test02UnZealotMataATresUnidadesSeVuelveInvisibleYNoPuedeSerAtacado() {
        Unidad unidad = new Zealot(new Posicion(0,0));
        unidad.setEstado(new Operativa());

        Unidad unidad2 = new Zerling(new Posicion(0,1));
        unidad2.setEstado(new Operativa());

        Unidad unidad3 = new Zerling(new Posicion(0,1));
        unidad3.setEstado(new Operativa());

        Unidad unidad4 = new Zerling(new Posicion(0, 1));
        unidad4.setEstado(new Operativa());

        Unidad unidad5 = new Hidralisco(new Posicion(1, 1));
        unidad5.setEstado(new Operativa());

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, unidad4, 5);

        assertThrows(AtaqueNoValidoException.class, () -> unidad5.atacar(unidad));
    }

    @Test
    public void test03UnZealotMataATresUnidadesSeVuelveInvisibleYPuedeSerAtacado(){
        Zealot unidad = new Zealot(new Posicion(0,0));
        unidad.setEstado(new Operativa());

        Unidad unidad2 = new Zerling(new Posicion(0,1));
        unidad2.setEstado(new Operativa());

        Unidad unidad3 = new Zerling(new Posicion(0,1));
        unidad3.setEstado(new Operativa());

        Unidad unidad4 = new Zerling(new Posicion(0, 1));
        unidad4.setEstado(new Operativa());

        Unidad unidad5 = new Hidralisco(new Posicion(1, 1));
        unidad5.setEstado(new Operativa());

        AmoSupremo unidad6 = new AmoSupremo(new Posicion(1, 0));
        unidad6.setEstado(new Operativa());

        Vector<AmoSupremo> AmosSupremos = new Vector<>();
        AmosSupremos.add(unidad6);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, unidad4, 5);

        unidad.revisarInvisibilidad(AmosSupremos);

        assertDoesNotThrow(() -> unidad5.atacar(unidad));
    }

    @Test
    public void test04UnZealotMataAUnaUnidadYDestruyeUnaEstructuraYPuedeSerAtacado(){
        Unidad unidad = new Zealot(new Posicion(0,0));
        unidad.setEstado(new Operativa());

        Unidad unidad2 = new Zerling(new Posicion(0,1));
        unidad2.setEstado(new Operativa());

        Estructura espiral = new ReservaDeReproduccion(new Posicion(0,1));
        espiral.setEstado(new Operativa());

        Unidad unidad3 = new Hidralisco(new Posicion(1, 1));
        unidad3.setEstado(new Operativa());

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, espiral, 125);

        assertDoesNotThrow(() -> unidad3.atacar(unidad));
    }

    @Test
    public void test05UnZealotMataADosUnidadedYDestruyeUnaEstructuraSeConvienrteEnInvisibleYNoPuedeSerAtacado(){
        Unidad unidad = new Zealot(new Posicion(0,0));
        unidad.setEstado(new Operativa());

        Unidad unidad2 = new Zerling(new Posicion(0,1));
        unidad2.setEstado(new Operativa());

        Unidad unidad3 = new Zerling(new Posicion(0,1));
        unidad3.setEstado(new Operativa());

        Estructura espiral = new ReservaDeReproduccion(new Posicion(0,1));
        espiral.setEstado(new Operativa());

        Unidad unidad4 = new Hidralisco(new Posicion(1, 1));
        unidad4.setEstado(new Operativa());

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, espiral, 125);

        assertThrows(AtaqueNoValidoException.class, () -> unidad4.atacar(unidad));
    }

    @Test
    public void test06UnZealotMataADosUnidadesYUnaEstructuraSeVuelveInvisibleYPuedeSerAtacado(){
        Zealot unidad = new Zealot(new Posicion(0,0));
        unidad.setEstado(new Operativa());

        Unidad unidad2 = new Zerling(new Posicion(0,1));
        unidad2.setEstado(new Operativa());

        Unidad unidad3 = new Zerling(new Posicion(0,1));
        unidad3.setEstado(new Operativa());

        Estructura espiral = new ReservaDeReproduccion(new Posicion(0,1));
        espiral.setEstado(new Operativa());

        Unidad unidad4 = new Hidralisco(new Posicion(1, 1));
        unidad4.setEstado(new Operativa());

        AmoSupremo unidad5 = new AmoSupremo(new Posicion(1, 0));
        unidad5.setEstado(new Operativa());

        Vector<AmoSupremo> AmosSupremos = new Vector<>();
        AmosSupremos.add(unidad5);

        atacarKVeces(unidad, unidad2, 5);
        atacarKVeces(unidad, unidad3, 5);
        atacarKVeces(unidad, espiral, 125);

        unidad.revisarInvisibilidad(AmosSupremos);

        assertDoesNotThrow(() -> unidad4.atacar(unidad));
    }
}
