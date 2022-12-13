package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorPilon;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorAmoSupremo;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorUnidades;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CasoDeUso31Test {


    @Test
    public void test01DestruirCriaderosDeberiaDisminuirLaCapacidadDeSuministroEn5() {
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.reiniciar();

        ConstructorEstructuras constructor = new ConstructorCriadero(zerg.getEstructuras(), zerg);
        zerg.recolectarMineral(600);

        Estructura criadero1 = constructor.construir(areaZerg());
        pasarKTurnos(criadero1, 4);

        Estructura criadero2 = constructor.construir(areaZerg());
        pasarKTurnos(criadero2, 4);

        Estructura criadero3 = constructor.construir(areaZerg());
        pasarKTurnos(criadero3, 4);

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
        Protoss protoss = Protoss.obtenerInstancia();
        protoss.reiniciar();

        ConstructorEstructuras constructor = new ConstructorPilon(protoss.getEstructuras(), protoss);
        protoss.recolectarMineral(600);

        Estructura pilon1 = constructor.construir(areaProtoss());
        pasarKTurnos(pilon1, 5);

        Estructura pilon2 = constructor.construir(areaProtoss());
        pasarKTurnos(pilon2, 5);

        Estructura pilon3 = constructor.construir(areaProtoss());
        pasarKTurnos(pilon3, 5);

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
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.reiniciar();

        //Este criadero solo mockea las larvas, y no afecta al suministro.
        Criadero estructura = mock(Criadero.class);
        doNothing().when(estructura).usarLarva();
        when(estructura.afectarSuministro(any(int.class))).thenAnswer(i -> i.getArguments()[0]);
        zerg.registrarEntidad(estructura);

        ConstructorUnidades constructor = new ConstructorAmoSupremo(zerg.getEstructuras(), zerg);
        zerg.recolectarMineral(150);

        Unidad amo1 = constructor.construir(areaZerg());
        pasarKTurnos(amo1, 5);

        Unidad amo2 = constructor.construir(areaZerg());
        pasarKTurnos(amo2, 5);

        Unidad amo3 = constructor.construir(areaZerg());
        pasarKTurnos(amo3, 5);

        assertEquals(15, zerg.suministroRestante());

        amo1.destruir();

        assertEquals(10, zerg.suministroRestante());

        amo2.destruir();

        assertEquals(5, zerg.suministroRestante());

        amo3.destruir();

        assertEquals(0, zerg.suministroRestante());
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    public Area areaProtoss() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
    }

    public Area areaZerg() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
    }
}
