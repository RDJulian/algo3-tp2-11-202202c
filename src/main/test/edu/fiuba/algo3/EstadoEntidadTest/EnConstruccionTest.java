package edu.fiuba.algo3.EstadoEntidadTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnConstruccionTest {
    @Test
    public void test01UnCriaderoNoPuedePermitirCorrelatividadSiNoEstaConstruido() {
        Criadero criadero = new Criadero();
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(criadero);

        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);
        zerg.registrarEntidad(estructuraMock);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());

        zerg.recolectarMineral(25);
        assertThrows(ConstruccionNoValidaException.class, () -> zerg.construirZangano(area));
    }
}