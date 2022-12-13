package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.*;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CasoDeUso30Test {
    @Test
    public void test01Entrenar201ZanganosConLaCapacidadMaximaDeSuministroDeberiaLanzarError() {
        Zerg zerg = new Zerg(0, 0);
        zerg.recolectarMineral(10000);

        //Este criadero solo mockea las larvas, y no afecta al suministro.
        Criadero estructura = mock(Criadero.class);
        doNothing().when(estructura).usarLarva();
        when(estructura.afectarSuministro(any(int.class))).thenAnswer(i -> i.getArguments()[0]);
        zerg.registrarEntidad(estructura);

        Criadero criadero = new Criadero(new Area(0, 0));
        pasarKTurnos(criadero, 4);
        agregarKEntidades(criadero, zerg, 40);

        ConstructorUnidades constructorZangano = new ConstructorZangano(zerg.getEstructuras(), zerg);

        construirKVeces(constructorZangano, 199);

        assertEquals(1, zerg.suministroRestante());

        construirKVeces(constructorZangano, 1);

        assertEquals(0, zerg.suministroRestante());

        assertThrows(SuministroInsuficienteException.class, () -> constructorZangano.construir(new Area(0, 0)));
    }

    @Test
    public void test02Entrenar51GuardianesConLaCapacidadMaximaDeSuministroDeberiaLanzarError() {
        Zerg zerg = new Zerg(0, 0);

        zerg.recolectarMineral(10000);
        zerg.recolectarGas(10000);

        Criadero criadero = new Criadero(new Area(0, 0));
        pasarKTurnos(criadero, 4);
        agregarKEntidades(criadero, zerg, 40);

        ConstructorUnidades constructorGuardian = new ConstructorGuardian(zerg.getEstructuras(), zerg);

        construirKVeces(constructorGuardian, 49);

        assertEquals(4, zerg.suministroRestante());

        construirKVeces(constructorGuardian, 1);

        assertEquals(0, zerg.suministroRestante());

        assertThrows(SuministroInsuficienteException.class, () -> constructorGuardian.construir(new Area(0, 0)));

    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    public void agregarKEntidades(Criadero criadero, Zerg zerg, int k) {
        for (int i = 0; i < k; i++) {
            zerg.registrarEntidad(criadero);
        }
    }

    public void construirKVeces(ConstructorUnidades constructor, int k) {
        for (int i = 0; i < k; i++) {
            constructor.construir(areaZerg());
        }
    }

    public Area areaZerg() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
    }
}
