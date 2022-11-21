package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16Test {
    //La forma en que se resuelve estos casos no esta tan buena.
    //Supuesto, engloba al caso de uso.
    @Test
    public void test01UnaEstructuraNoSePuedeConstruirSobreOtra() {
        Posicion posicion = new Posicion(0, 0);
        new Criadero(posicion);
        assertThrows(PosicionOcupadaException.class, posicion::ocupable);
    }

    //Es similar al caso de arriba, no es el GasVespeno el que deba responder si su posicion esta ocupada o no.
    //Una estructura automaticamente no es construible si la posicion esta ocupada. La unica excepcion a esto es
    //si el Zangano esta ocupando el Mineral, y en ese caso hay una sobrecarga que hace el chequeo porque no
    //pasa por ningun constructor como los de Estructura.
    @Test
    public void test02UnaEstructuraNoSePuedeConstruirSobreUnVolcanConUnaEstructura() {
        Posicion posicion = new Posicion(0, 0);
        Recurso gasVespeno = new GasVespeno(posicion);
        new Extractor(posicion, gasVespeno, new Raza());

        assertThrows(PosicionOcupadaException.class, posicion::ocupable);
    }

    @Test
    public void test03UnNexoMineralNoSePuedeConstruirSiUnZanganoEstaExtrayendo() {
        Posicion posicion = new Posicion(0, 0);
        Recurso mineral = new Mineral(posicion);
        Zangano zangano = new Zangano(new Posicion(0, 0));

        zangano.ocupar(mineral);

        assertThrows(PosicionOcupadaException.class, posicion::ocupable);
    }

    //Suponemos que no puede ni siquiera ir a esa posicion/ocupar ese mineral porque esta el Nexo.
    @Test
    public void test04UnZanganoNoPuedeExtraerMineralSiUnNexoMineralEstaConstruido() {
        Posicion posicion = new Posicion(0, 0);
        Recurso mineral = new Mineral(posicion);
        Zangano zangano = new Zangano(new Posicion(0, 0));

        new NexoMineral(posicion, mineral, new Raza());

        assertThrows(PosicionOcupadaException.class, () -> zangano.ocupar(mineral));
    }
}
