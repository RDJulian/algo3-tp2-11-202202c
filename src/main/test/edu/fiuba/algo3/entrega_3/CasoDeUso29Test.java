package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso29Test {


    @Test
    public void test01ConstruirMasDe40CriaderosNoDeberiaAumentarLaCapacidadDeSuministro() {
        Zerg zerg = new Zerg(0, 0);

        Criadero criadero = new Criadero(new Area(0, 0));
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
        Zerg zerg = new Zerg(0, 0);

        AmoSupremo amoSupremo = new AmoSupremo(new Area(0, 0));
        pasarKTurnos(amoSupremo, 5);

        agregarKEntidades(amoSupremo, zerg, 39);

        assertEquals(195, zerg.suministroRestante());

        agregarKEntidades(amoSupremo, zerg, 1);

        assertEquals(200, zerg.suministroRestante());

        agregarKEntidades(amoSupremo, zerg, 1);

        assertEquals(200, zerg.suministroRestante());
    }

    @Test
    public void test03UnAmoSupremoEnConstruccionNoAportaSuministro() {
        Zerg zerg = new Zerg(0, 0);

        AmoSupremo amoSupremo = new AmoSupremo(new Area(0, 0));
        zerg.registrarEntidad(amoSupremo);

        assertEquals(0, zerg.suministroRestante());

        pasarKTurnos(amoSupremo, 5);

        assertEquals(5, zerg.suministroRestante());
    }

    @Test
    public void test03UnCriaderoEnConstruccionNoAportaSuministro() {
        Zerg zerg = new Zerg(0, 0);

        Criadero criadero = new Criadero(new Area(0, 0));
        zerg.registrarEntidad(criadero);

        assertEquals(0, zerg.suministroRestante());

        pasarKTurnos(criadero, 4);

        assertEquals(5, zerg.suministroRestante());
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    public void agregarKEntidades(Criadero entidad, Zerg zerg, int k) {
        for (int i = 0; i < k; i++) {
            zerg.registrarEntidad(entidad);
        }
    }

    public void agregarKEntidades(AmoSupremo entidad, Zerg zerg, int k) {
        for (int i = 0; i < k; i++) {
            zerg.registrarEntidad(entidad);
        }
    }
}
