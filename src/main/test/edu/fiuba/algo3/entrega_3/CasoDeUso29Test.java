package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso29Test {


    @Test
    public void test01ConstruirMasDe40CriaderosNoDeberiaAumentarLaCapacidadDeSuministro() {
        Raza zerg = new Raza();
        Criadero criadero = new Criadero(new Posicion(0, 0), new Raza(), new Nada());
        pasarKTurnos(criadero, 4);

        agregarKEntidades(criadero, zerg, 39);

        assertEquals(195, zerg.suministroRestante());

        agregarKEntidades(criadero, zerg, 1);

        assertEquals(200, zerg.suministroRestante());

        agregarKEntidades(criadero, zerg, 1);

        assertEquals(200, zerg.suministroRestante());

    }

    @Test
    public void test02EntrenarMasDe40AmosSupremosNoDeberiaAumentarLaCapacidadDeSuministro() {
        Raza zerg = new Raza();
        AmoSupremo amoSupremo = new AmoSupremo(new Posicion(0, 0), new Raza());
        pasarKTurnos(amoSupremo, 5);

        agregarKEntidades(amoSupremo, zerg, 39);

        assertEquals(195, zerg.suministroRestante());

        agregarKEntidades(amoSupremo, zerg, 1);

        assertEquals(200, zerg.suministroRestante());

        agregarKEntidades(amoSupremo, zerg, 1);

        assertEquals(200, zerg.suministroRestante());

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
