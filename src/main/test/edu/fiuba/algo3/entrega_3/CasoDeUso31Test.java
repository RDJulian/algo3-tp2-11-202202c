package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorPilon;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorAmoSupremo;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorUnidades;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso31Test {


    @Test
    public void test01DestruirCriaderosDeberiaDisminuirLaCapacidadDeSuministroEn5() {
        Raza zerg = new Raza();
        ConstructorEstructuras constructor = new ConstructorCriadero();
        zerg.recolectarMineral(600);
        Posicion posicion1 = new Posicion(0,0);
        Estructura criadero1 = constructor.construir(posicion1,new edu.fiuba.algo3.modelo.Recurso.Nada(),new edu.fiuba.algo3.modelo.Piso.Nada(),zerg, new Nada());
        Posicion posicion2 = new Posicion(0,1);
        Estructura criadero2 = constructor.construir(posicion2,new edu.fiuba.algo3.modelo.Recurso.Nada(),new edu.fiuba.algo3.modelo.Piso.Nada(),zerg, new Nada());
        Posicion posicion3 = new Posicion(0,2);
        Estructura criadero3 = constructor.construir(posicion3,new edu.fiuba.algo3.modelo.Recurso.Nada(),new edu.fiuba.algo3.modelo.Piso.Nada(),zerg, new Nada());

        assertEquals(15, zerg.suministroRestante());

        criadero1.destruir();

        assertEquals(10, zerg.suministroRestante());

        criadero2.destruir();

        assertEquals(5, zerg.suministroRestante());

        criadero3.destruir();

        assertEquals(0, zerg.suministroRestante());
    }

    @Test
    public void test02DestruirPilonesDeberiaDisminuirLaCapacidadDeSuministroEn5() {
        Raza protoss = new Raza();
        ConstructorEstructuras constructor = new ConstructorPilon();
        protoss.recolectarMineral(600);
        Posicion posicion1 = new Posicion(0,0);
        Estructura pilon1 = constructor.construir(posicion1,new edu.fiuba.algo3.modelo.Recurso.Nada(),new edu.fiuba.algo3.modelo.Piso.Nada(),protoss, new Nada());
        Posicion posicion2 = new Posicion(0,1);
        Estructura pilon2 = constructor.construir(posicion2,new edu.fiuba.algo3.modelo.Recurso.Nada(),new edu.fiuba.algo3.modelo.Piso.Nada(),protoss, new Nada());
        Posicion posicion3 = new Posicion(0,2);
        Estructura pilon3 = constructor.construir(posicion3,new edu.fiuba.algo3.modelo.Recurso.Nada(),new edu.fiuba.algo3.modelo.Piso.Nada(),protoss, new Nada());

        assertEquals(15, protoss.suministroRestante());

        pilon1.destruir();

        assertEquals(10, protoss.suministroRestante());

        pilon2.destruir();

        assertEquals(5, protoss.suministroRestante());

        pilon3.destruir();

        assertEquals(0, protoss.suministroRestante());
    }

    @Test
    public void test03MatarAmosSupremosDeberiaDisminuirLaCapacidadDeSuministroEn5() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorAmoSupremo();
        zerg.recolectarMineral(150);

        Posicion posicion1 = new Posicion(0,0);
        Unidad amo1 = constructor.construir(posicion1,zerg, new Nada());
        Posicion posicion2 = new Posicion(0,1);
        Unidad amo2 = constructor.construir(posicion2,zerg, new Nada());
        Posicion posicion3 = new Posicion(0,2);
        Unidad amo3 = constructor.construir(posicion3,zerg, new Nada());

        assertEquals(15, zerg.suministroRestante());

        amo1.destruir();

        assertEquals(10, zerg.suministroRestante());

        amo2.destruir();

        assertEquals(5, zerg.suministroRestante());

        amo3.destruir();

        assertEquals(0, zerg.suministroRestante());
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
