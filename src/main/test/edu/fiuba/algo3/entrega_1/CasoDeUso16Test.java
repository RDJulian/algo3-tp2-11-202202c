package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16Test {
    //Supuesto, engloba al caso de uso.
    @Test
    public void test01UnaEstructuraNoSePuedeConstruirSobreOtra() {
        Posicion posicion = new Posicion(0, 0);
        new Criadero(posicion, new Raza(), new Nada());
        assertThrows(PosicionOcupadaException.class, () -> new Criadero(posicion, new Raza(), new Nada()));
    }

    @Test
    public void test02UnaEstructuraNoSePuedeConstruirSobreUnVolcanConUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Recurso gasVespeno = new GasVespeno(posicion);
        new Extractor(posicion, new Raza(), gasVespeno);

        assertThrows(PosicionOcupadaException.class, () -> new Extractor(posicion, new Raza(), gasVespeno));
    }

    @Test
    public void test03UnNexoMineralNoSePuedeConstruirSiUnZanganoEstaExtrayendo() {
        Posicion posicion = new Posicion(0, 0);
        posicion.energizar();
        Recurso mineral = new Mineral(posicion);
        Zangano zangano = new Zangano();

        zangano.pasarTurno();
        zangano.moverse(posicion);

        assertThrows(PosicionOcupadaException.class, () -> new NexoMineral(posicion, new Raza(), mineral));
    }

    //Suponemos que no puede ni siquiera ir a esa posicion/ocupar ese mineral porque esta el Nexo.
    @Test
    public void test04UnZanganoNoPuedeExtraerMineralSiUnNexoMineralEstaConstruido() {
        Posicion posicion = new Posicion(0, 0);
        Recurso mineral = new Mineral(posicion);
        Zangano zangano = new Zangano();

        zangano.pasarTurno();
        new NexoMineral(posicion, new Raza(), mineral);

        assertThrows(PosicionOcupadaException.class, () -> zangano.moverse(posicion));
    }
}
