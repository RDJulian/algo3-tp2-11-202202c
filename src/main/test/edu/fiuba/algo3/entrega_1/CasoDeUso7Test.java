package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso7Test {

    @Test
    public void test01ZanganoObtieneMineralCorrectamenteParaLosZerg() {
        Reserva reservaMineral = new Reserva();
        Reserva reservaGas = new Reserva();
        Raza raza = new Raza(reservaMineral, reservaGas);
        Recurso mineral = new Mineral(new Posicion(0, 0));
        Zangano zangano = new Zangano(new Posicion(0, 0));

        zangano.ocupar(mineral);
        zangano.setRaza(raza);
        zangano.extraerRecurso();

        assertEquals(reservaMineral.getRecurso(), 10);
    }

    @Test
    public void test02ExtractorObtieneGasCorrectamenteParaLosZerg() {
        Reserva reservaMineral = new Reserva();
        Reserva reservaGas = new Reserva();
        Raza raza = new Raza(reservaMineral, reservaGas);
        GasVespeno gasVespeno = new GasVespeno(new Posicion(0, 0));
        Extractor extractor = new Extractor(new Posicion(0, 0), gasVespeno, raza);

        pasarKTurnos(extractor, 6);

        extractor.agregarZangano(new Zangano(new Posicion(0, 0)));
        extractor.agregarZangano(new Zangano(new Posicion(0, 0)));
        extractor.agregarZangano(new Zangano(new Posicion(0, 0)));
        extractor.pasarTurno();

        assertEquals(reservaGas.getRecurso(), 30);

        extractor.pasarTurno();

        assertEquals(reservaGas.getRecurso(), 60);
    }

    @Test
    public void test03NexoMineralObtieneMineralCorrectamenteParaLosZerg() {
        Reserva reservaMineral = new Reserva();
        Reserva reservaGas = new Reserva();
        Raza raza = new Raza(reservaMineral, reservaGas);
        Recurso mineral = new Mineral(new Posicion(0, 0));
        NexoMineral nexoMineral = new NexoMineral(new Posicion(0, 0), mineral, raza);

        pasarKTurnos(nexoMineral, 5);

        assertEquals(reservaMineral.getRecurso(), 20);

        nexoMineral.pasarTurno();

        assertEquals(reservaMineral.getRecurso(), 40);
    }

    @Test
    public void test04AsimiladorObtieneGasCorrectamenteParaLosZerg() {
        Reserva reservaMineral = new Reserva();
        Reserva reservaGas = new Reserva();
        Raza raza = new Raza(reservaMineral, reservaGas);
        Recurso gasVespeno = new GasVespeno(new Posicion(0, 0));
        Asimilador asimilador = new Asimilador(new Posicion(0, 0), gasVespeno, raza);

        pasarKTurnos(asimilador, 7);

        assertEquals(reservaGas.getRecurso(), 20);

        asimilador.pasarTurno();

        assertEquals(reservaGas.getRecurso(), 40);
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
