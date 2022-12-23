package edu.fiuba.algo3.RecursoTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecursoTest {
    @Test
    public void test01UnGasVespenoConMenosRecursoDelQueSeVaAExtraerIgualDaLasUnidadesQueLeQueden() {
        Recurso recurso = new GasVespeno(9);
        assertDoesNotThrow(() -> recurso.extraerRecurso(10, new Zerg()));
        assertThrows(RecursoVacioException.class, () -> recurso.extraerRecurso(10, new Zerg()));
    }

    @Test
    public void test02UnMineralConMenosRecursoDelQueSeVaAExtraerIgualDaLasUnidadesQueLeQueden() {
        Recurso recurso = new Mineral(9);
        assertDoesNotThrow(() -> recurso.extraerRecurso(10, new Zerg()));
        assertThrows(RecursoVacioException.class, () -> recurso.extraerRecurso(10, new Zerg()));
    }
}