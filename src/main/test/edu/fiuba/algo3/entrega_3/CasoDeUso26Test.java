package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso26Test {
    //Se puede dar los recursos justos para chequear el costo, pero el comportamiento seria el mismo.
    //El chequeo esta encapsulado en Constructor.

    public ArrayList<Estructura> estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        return estructuras;
    }

    @Test
    public void test01UnZanganoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorZangano(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new Criadero(posicion, new Raza(), new Nada());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test02UnAmoSupremoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorAmoSupremo(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new Criadero(posicion, new Raza(), new Nada());
        pasarKTurnos(estructuraNecesaria, 20);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test03UnDevoradorNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorDevorador(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new Criadero(posicion, new Raza(), new Nada());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test04UnDragonNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorDragon(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new Acceso(posicion, new Raza(), new Nada());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test05UnGuardianNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorGuardian(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new Criadero(posicion, new Raza(), new Nada());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test06UnHidraliscoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorHidralisco(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new Guarida(posicion, new Raza(), new Nada(), estructuraMockeadaParaTestear());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test07UnMutaliscoNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorMutalisco(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new Espiral(posicion, new Raza(), new Nada(), estructuraMockeadaParaTestear());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test08UnZealotNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorZealot(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new Acceso(posicion, new Raza(), new Nada());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test09UnScoutNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorScout(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new PuertoEstelar(posicion, new Raza(), new Nada(), estructuraMockeadaParaTestear());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    @Test
    public void test10UnZerlingNoSePuedeConstruirSiNoSeCuentaConLaCantidadDeRecursoNecesario() {
        Raza zerg = new Raza();
        ConstructorUnidades constructor = new ConstructorZerling(new ArrayList<>(), zerg);
        Posicion posicion = new Posicion(0, 0);
        Estructura estructuraNecesaria = new ReservaDeReproduccion(posicion, new Raza(), new Nada());
        pasarKTurnos(estructuraNecesaria, 20);

        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(zerg, criadero, 40);

        assertThrows(RecursoInsuficienteException.class, () -> constructor.construir(posicion));

        zerg.recolectarGas(1000);
        zerg.recolectarMineral(1000);

        assertDoesNotThrow(() -> constructor.construir(posicion));
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

    public void agregarKEntidades(Raza zerg, Estructura entidad, int k) {
        for (int i = 0; i < k; i++) {
            zerg.registarEntidad(entidad);
        }
    }
}
