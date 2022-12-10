package edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.SobreGasVespeno;
import edu.fiuba.algo3.modelo.Entidad.Comando.AgregarZangano;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Vida.SinEscudo;

public class Extractor extends Estructura implements ExtraeRecurso {
    private Zanganos zanganos;

    public Extractor(Area area, Raza raza) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(100, 0);


        boolean construible = new SobreGasVespeno().construible(area)
                && new RangoMoho().construible(area);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        this.area = area.ocupar();
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(750);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.zanganos = new Zanganos();

        raza.registarEntidad(this);
    }

    public Extractor() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(750);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.zanganos = new Zanganos();
        this.raza = new Raza();
    }

    @Override
    public void extraerRecurso() {
        zanganos.extraerRecurso(area);
    }

    public void agregarZangano(Zangano zangano) {
        estadoOperativo.operable(new AgregarZangano(zanganos, zangano));
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