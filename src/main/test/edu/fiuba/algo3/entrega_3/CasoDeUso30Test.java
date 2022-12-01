package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso30Test {


    @Test
    public void test01Entrenar201ZanganosConLaCapacidadMaximaDeSuministroDeberiaLanzarError() {
        Raza zerg = new Raza();
        zerg.recolectarMineral(25);
        Estructura criaderoNecesario = new Criadero(new Posicion(0, 0), new Raza());
        pasarKTurnos(criaderoNecesario, 4);
        agregarKEntidades(criaderoNecesario, zerg, 40);

        Zangano zangano = new Zangano(new Posicion(0, 0), zerg);
        ConstructorUnidades constructorZangano = new ConstructorZangano();

        agregarKEntidades(zangano, zerg, 199);

        assertEquals(1, zerg.suministroRestante());

        agregarKEntidades(zangano, zerg, 1);

        assertEquals(0, zerg.suministroRestante());

        assertThrows(SuministroInsuficienteException.class, () -> constructorZangano.construir(new Posicion(0, 0), zerg, criaderoNecesario));

    }

    @Test
    public void test02Entrenar51GuardianeConLaCapacidadMaximaDeSuministroDeberiaLanzarError() {
        Raza zerg = new Raza();
        zerg.recolectarMineral(50);
        zerg.recolectarGas(100);
        Estructura criadero = new Criadero(new Posicion(0, 0), new Raza());
        pasarKTurnos(criadero, 4);
        agregarKEntidades(criadero, zerg, 40);

        Guardian guardian = new Guardian(new Posicion(0, 0), new Raza());
        ConstructorUnidades constructorGuardian = new ConstructorGuardian();

        agregarKEntidades(guardian, zerg, 49);

        assertEquals(4, zerg.suministroRestante());

        agregarKEntidades(guardian, zerg, 1);

        assertEquals(0, zerg.suministroRestante());

        assertThrows(SuministroInsuficienteException.class, () -> constructorGuardian.construir(new Posicion(0, 0), zerg, criadero));

    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    public void agregarKEntidades(Estructura entidad, Raza zerg, int k) {
        for (int i = 0; i < k; i++) {
            zerg.registarEntidad(entidad);
        }
    }

    public void agregarKEntidades(Unidad entidad, Raza zerg, int k) {
        for (int i = 0; i < k; i++) {
            zerg.registarEntidad(entidad);
        }
    }
}
