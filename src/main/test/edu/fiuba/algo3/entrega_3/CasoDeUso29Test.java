package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorAcceso;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso29Test {


    @Test
    public void test01ConstruirMasDe40CriaderosNoDeberiaAumentarLaCapacidadDeSuministro() {
        Raza zerg = new Raza();
        ConstructorEstructuras constructor = new ConstructorCriadero();
        zerg.recolectarMineral(8200);

        construirEstructuraKVeces(constructor,zerg,39);

        assertEquals(195, zerg.suministroRestante());

        construirEstructuraKVeces(constructor,zerg,1);

        assertEquals(200, zerg.suministroRestante());

        construirEstructuraKVeces(constructor,zerg,1);

        assertEquals(200, zerg.suministroRestante());

    }

    @Test
    public void test02EntrenarMasDe40AmosSupremosNoDeberiaAumentarLaCapacidadDeSuministro() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorAmoSupremo();
        zerg.recolectarMineral(2050);

        construirUnidadKVeces(constructor,zerg,new Nada(),39);

        assertEquals(195, zerg.suministroRestante());

        construirUnidadKVeces(constructor,zerg,new Nada(),1);

        assertEquals(200, zerg.suministroRestante());

        construirUnidadKVeces(constructor,zerg,new Nada(),1);

        assertEquals(200, zerg.suministroRestante());

    }


    public void construirUnidadKVeces(ConstructorUnidades constructorUnidades, Raza raza, Estructura estructuraNecesaria, int k) {
        for (int i = 0; i < k; i++) {
            constructorUnidades.construir(new Posicion(i,0),raza, estructuraNecesaria);
        }
    }

    public void construirEstructuraKVeces(ConstructorEstructuras constructorEstructuras, Raza raza, int k) {
        for (int i = 0; i < k; i++) {
            constructorEstructuras.construir(new Posicion(0,i),new edu.fiuba.algo3.modelo.Recurso.Nada(),new Moho(new Posicion(0,i)),raza, new Nada());
        }
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
