package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.SobreGasVespeno;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Asimilador extends Estructura implements ExtraeRecurso {

    public Asimilador(Area area, Raza raza) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(100, 0);

        boolean construible = new SobreGasVespeno().construible(area)
                && new RangoPilon().construible(area);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        this.area = area.ocupar();
        //Instanciacion de clases comunes
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        raza.registarEntidad(this);
    }

    public Asimilador() {
        //Instanciacion de clases comunes
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
    }

    @Override
    public void extraerRecurso() {
        area.extraerRecurso(20, this.raza);
    }


    @Override
    public void pasarTurno() {
        estadoOperativo = estadoOperativo.pasarTurno(vida, defensa, new ExtraerRecurso(this));
    }

    @Override
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}