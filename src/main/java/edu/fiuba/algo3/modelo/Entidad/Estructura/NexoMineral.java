package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.SobreMineral;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Vida.Escudo;
import edu.fiuba.algo3.modelo.Entidad.Vida.Normal;

public class NexoMineral extends Estructura implements ExtraeRecurso {
    public NexoMineral(Area area, Raza raza) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(50, 0);


        boolean construible = new SobreMineral().construible(area)
                && new RangoPilon().construible(area);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }
        this.area = area.ocupar();
        //Instanciacion de clases comunes
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        raza.registarEntidad(this);
    }

    public NexoMineral() {
        //Instanciacion de clases comunes
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
        this.raza = new Raza();
    }

    @Override
    public void extraerRecurso() {
        area.extraerRecurso(20, raza); //Asumimos 20.
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
