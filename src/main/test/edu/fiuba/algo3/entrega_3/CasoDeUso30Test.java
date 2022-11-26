package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Nada;
import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso30Test {


    @Test
    public void test01Entrenar201ZanganosConLaCapacidadMaximaDeSuministroDeberiaLanzarError() {
        Raza zerg = new Raza();
        zerg.recolectarMineral(13025);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        Posicion posicion = new Posicion(-1,-1);
        Estructura criaderoNecesario = constructorCriadero.construir(posicion,new edu.fiuba.algo3.modelo.Recurso.Nada(), new Moho(posicion),zerg, new Nada());
        pasarKTurnos(criaderoNecesario,4);
        ConstructorUnidades constructorZangano = new ConstructorZangano();

        construirEstructuraKVeces(constructorCriadero,zerg,39);
        construirUnidadKVeces(constructorZangano,zerg,criaderoNecesario,199);

        assertEquals(1, zerg.suministroRestante());

        construirUnidadKVeces(constructorZangano,zerg,criaderoNecesario,1);

        assertEquals(0, zerg.suministroRestante());

        assertThrows(SuministroInsuficienteException.class, () -> construirUnidadKVeces(constructorZangano,zerg,criaderoNecesario,1));

    }

    @Test
    public void test02Entrenar51ZanganosConLaCapacidadMaximaDeSuministroDeberiaLanzarError() {
        Raza zerg = new Raza();
        zerg.recolectarMineral(10550);
        zerg.recolectarGas(5100);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        ConstructorUnidades constructorGuardian = new ConstructorGuardian();

        construirEstructuraKVeces(constructorCriadero,zerg,40);
        construirUnidadKVeces(constructorGuardian,zerg,new Nada(),49);

        assertEquals(4, zerg.suministroRestante());

        construirUnidadKVeces(constructorGuardian,zerg,new Nada(),1);

        assertEquals(0, zerg.suministroRestante());

        assertThrows(SuministroInsuficienteException.class, () -> construirUnidadKVeces(constructorGuardian,zerg,new Nada(),1));

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
