package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso26Test {
    //Se puede dar los recursos justos para chequear el costo, pero el comportamiento seria el mismo.
    //El chequeo esta encapsulado en Constructor.
    @Test
    public void test01UnZanganoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorZangano();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new Criadero(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test02UnAmoSupremoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorAmoSupremo();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new Criadero(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test03UnDevoradorNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorDevorador();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new Criadero(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test04UnDragonNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorDragon();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new Acceso(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test05UnGuardianNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorGuardian();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new Criadero(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test06UnHidraliscoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorHidralisco();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new Guarida(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test07UnMutaliscoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorMutalisco();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new Espiral(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test08UnZealotNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorZealot();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new Acceso(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test09UnScoutNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorScout();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new PuertoEstelar(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }

    @Test
    public void test10UnZerlingNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorZerling();
        Posicion posicion = new Posicion(0,0);
        Estructura estructuraNecesaria = new ReservaDeReproduccion(posicion);
        pasarKTurnos(estructuraNecesaria, 20);

        //Aumento la capacidad de suministro al maximo
        zerg.recolectarMineral(8000);
        ConstructorEstructuras constructorCriadero = new ConstructorCriadero();
        construirEstructuraKVeces(constructorCriadero,zerg,40);

        assertThrows(RecursoInsuficienteException.class, ()-> constructor.construir(posicion,zerg, estructuraNecesaria));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(()-> constructor.construir(posicion,zerg, estructuraNecesaria));
    }
    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

    public void construirEstructuraKVeces(ConstructorEstructuras constructorEstructuras, Raza raza, int k) {
        for (int i = 0; i < k; i++) {
            constructorEstructuras.construir(new Posicion(0,i),new edu.fiuba.algo3.modelo.Recurso.Nada(),new edu.fiuba.algo3.modelo.Piso.Nada(),raza, new Nada());
        }
    }
}
